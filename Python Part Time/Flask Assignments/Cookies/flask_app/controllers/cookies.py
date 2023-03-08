from flask_app import app
from flask import render_template, request, redirect
from flask_app.models.cookie import Cookie

@app.route('/')
def home():
    return render_template('cookies.html', cookies = Cookie.all_orders())

@app.route('/update_cookie/<int:id>', methods=['POST'])
def update_cookie(id):
    if request.form['update'] == 'edit':
        return redirect(f"/edit_cookie/{id}")
    elif request.form['update'] == 'delete':
        data = {
            'id' : id
        }
        Cookie.delete(data)
        return redirect('/')

@app.route('/edit_cookie/<int:id>')
def edit_cookie_page(id):
    data = {
        'id' : id
    }
    return render_template('edit_cookie.html', order = Cookie.one_order(data))

@app.route('/new_order/post', methods=['POST'])
def new_order_post():
    return redirect(f"/new_order")

@app.route('/new_order')
def new_order_page():
    return render_template('new_cookie.html')

@app.route('/home', methods=["POST"])
def return_home():
    return redirect('/')

@app.route('/log_new_order', methods=['POST'])
def log_new_order():
    if not Cookie.validate_log(request.form):
        return redirect('/new_order')
    else:
        data = {
            'name' : request.form['name'],
            'cookie_type' : request.form['cookie_type'],
            'num_of_boxes' : request.form['num_of_boxes'],
        }
        Cookie.save(data)
        return redirect('/')

@app.route('/edit_cookie_order/<int:id>', methods=['POST'])
def edit_cookie(id):
    if not Cookie.validate_log(request.form):
        return redirect(f"/edit_cookie/{id}")
    else:
        data = {
            'id' : id,
            'name' : request.form['name'],
            'cookie_type' : request.form['cookie_type'],
            'num_of_boxes' : request.form['num_of_boxes']
        }
        Cookie.edit(data)
        return redirect('/')