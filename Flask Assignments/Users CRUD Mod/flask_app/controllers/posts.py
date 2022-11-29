from flask_app import app
from flask import render_template, redirect, session, request
from flask_app.models.post import Post
from flask_app.models.user import User

@app.route('/create_post/<int:id>',methods=['POST'])
def create_post(id):
    data = {
        'content' : request.form['content'],
        'user_id' : id
    }
    Post.save(data)
    return redirect('/')

@app.route('/add_new_post/<int:id>', methods=['POST'])
def add_new_post(id):
    data = {
        'id' : id
    }
    return render_template('user_post_new.html', user = User.get_user(data))