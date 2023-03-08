from flask import render_template, redirect, request, session
from flask_app import app
from flask_app.models import sighting, user

## NEW SIGHTING ROUTES
@app.route('/new_sighting', methods=['POST'])
def new_sighting_redirect():
    return redirect('/new/sighting')

@app.route('/new/sighting')
def new_sighting():
    data = {'id' : session['user_id']}
    user_data = user.User.user_info(data)
    return render_template('/new_sighting.html', user_data = user_data)

@app.route('/report', methods=['POST'])
def report():
    if not sighting.Sighting.validate_sighting(request.form):
        return redirect('/new/sighting')
    else:
        new_sighting = sighting.Sighting.new_sighting(request.form)
        print("__NEW SIGHTING__", new_sighting)
        return redirect('/dashboard')

## VIEW, EDIT, AND DELETE ROUTES

@app.route('/edit/<int:id>')
def edit_page(id):
    data = {'id' : id}
    selected_sighting = sighting.Sighting.one_sighting(data)
    for info in selected_sighting:
        if info.user.id != session['user_id']:
            redirect('/dashboard')
        else:
            return render_template('edit_sighting.html', sighting_data = selected_sighting)
    return redirect('/dashboard')

@app.route('/apply_changes',methods=['POST'])
def edit_sighting():
    if not sighting.Sighting.validate_sighting(request.form):
        id = request.form['id']
        return redirect(f'edit/{id}')
    else:
        sighting.Sighting.edit_sighting(request.form)
        return redirect('/dashboard')

@app.route('/show/<int:id>')
def view_page(id):
    data = {'id' : id}
    user_info = {'id' : session['user_id']}
    sighting_data = sighting.Sighting.one_sighting(data)
    user_data = user.User.user_info(user_info)
    return render_template('view_sighting.html', sighting_data = sighting_data, user_data = user_data)

@app.route('/delete/<int:id>')
def delete_sighting(id):
    data = {'id': id}
    selected_sighting = sighting.Sighting.one_sighting(data)
    for info in selected_sighting:
        if info.user.id != session['user_id']:
            redirect('/dashboard')
        else:
            sighting.Sighting.delete_sighting(data)
    return redirect('/dashboard')
