from flask import render_template, redirect, request, session
from flask_app import app
from flask_app.models import user, post, comment

@app.route('/post', methods=['POST'])
def publish_post():
    if not post.Post.validate_post(request.form):
        return redirect('/dashboard')
    else:
        post.Post.create_post(request.form)
        return redirect('/dashboard')

@app.route('/delete', methods=['POST'])
def delete_post():
    post.Post.delete_post(request.form)
    return redirect('/dashboard')