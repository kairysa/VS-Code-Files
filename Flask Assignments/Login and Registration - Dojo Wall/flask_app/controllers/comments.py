from flask import render_template, redirect, request, session
from flask_app import app
from flask_app.models import user, post, comment

@app.route('/comment', methods=['POST'])
def publish_comment():
    if not comment.Comment.validate_comment(request.form):
        return redirect('dashboard')
    else:
        comment.Comment.publish_comment(request.form)
        return redirect('/dashboard')

@app.route('/delete_comment', methods=['POST'])
def delete_comment():
    comment.Comment.delete_post(request.form)
    return redirect('/dashboard')