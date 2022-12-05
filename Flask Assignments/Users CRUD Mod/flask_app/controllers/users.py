from flask_app import app
from flask import render_template, redirect, session, request
from flask_app.models.user import User
from flask_app.models.post import Post

@app.route('/')
def index():
    return render_template('index.html', all_users = User.users_info())

@app.route('/new_friend/post', methods=['POST'])
def new_friend_post():
    return redirect('/new_friend')

@app.route('/new_friend')
def new_friend():
    return render_template('user_new.html')

@app.route('/update_user/<int:id>', methods=['POST'])
def update_user(id):
    if request.form['update'] == 'edit':
        return redirect(f"/edit_page/{id}")
    elif request.form['update'] == 'show':
        return redirect(f"/show_page/{id}")
    elif request.form['update'] == 'delete':
        data = {
            'id' : id
        }
        User.delete_user(data)
        return redirect('/')
    elif request.form['update'] == 'post':
        return redirect(f"/post_page/{id}")

@app.route('/edit_page/<int:id>')
def edit_page(id):
    data = {
        'id' : id
    }
    return render_template('user_edit.html', user = User.get_user(data))

@app.route('/show_page/<int:id>')
def show_page(id):
    data = {
        'id' : id
    }
    return render_template('user_show.html',user = User.get_user(data))

@app.route('/add_friend',methods=['POST'])
def add_friend():
    if not User.validate_user(request.form):
        return redirect('/new_friend')
    data = {
        'fname': request.form['fname'],
        'lname': request.form['lname'],
        'email': request.form['email']
    }
    User.save(data)
    return redirect('/')

@app.route('/edit_friend/<int:id>', methods=['POST'])
def edit_user(id):
    if not User.validate_user(request.form):
        return redirect(f"/edit_page/{id}")
    else:
        data = {
            'id' : id,
            'fname': request.form['fname'],
            'lname' : request.form['lname'],
            'email': request.form['email']
        }
        User.edit(data)
    return redirect(f"/show_page/{id}")

@app.route('/home', methods=["POST"])
def home():
    return redirect("/")