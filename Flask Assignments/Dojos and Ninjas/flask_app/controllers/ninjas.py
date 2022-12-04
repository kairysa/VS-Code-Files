from flask_app import app
from flask import render_template, request, redirect, session, url_for
from flask_app.models.ninja import Ninja

@app.route('/create_ninja', methods=["POST"])
def create_ninja():
    data = {
        'first_name' : request.form['first_name'],
        'last_name' : request.form['last_name'],
        'age' : request.form['age'],
        'dojo_id' : request.form['dojo_id']
    }
    Ninja.create_user(data)
    return redirect('/')

@app.route('/update_ninja/<int:id>/<int:dojo>', methods=["POST"])
def update_ninja(id,dojo):
    data = {
        'id' : id
    }
    if request.form['update'] == 'delete':
        Ninja.delete_ninja(data)
        return redirect(f"/select_dojo/{dojo}")
    elif request.form['update'] == 'edit':
        return redirect(f"/edit_user/{id}")

@app.route('/edit_user/<int:id>')
def edit_ninja_page(id):
    data = {
        'id' : id,
    }
    ninja = Ninja.get_ninja(data)
    return render_template('edit_ninja.html', ninja=ninja)

@app.route('/edit_ninja/<int:id>/<int:dojo_id>', methods = ['POST'])
def apply_changes(id, dojo_id):
    data = {
        'id' : id,
        'first_name' : request.form['first_name'],
        'last_name' : request.form['last_name'],
        'age' : request.form['age']
    }
    Ninja.edit_ninja(data)
    return redirect(f"/select_dojo/{dojo_id}")