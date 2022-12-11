from flask import render_template, redirect, request, session
from flask_app import app
from flask_app.models import user, post, comment


@app.route('/')
def home():
    return render_template('login.html')

@app.route('/register/link', methods=['POST'])
def register_page_link():
    return redirect('/register')

@app.route('/register')
def register_page():
    return render_template('register.html')

@app.route('/register_user', methods=['POST'])
def register():
    if not user.User.validate_reg(request.form):
        return redirect('/register')
    else:
        user_id = user.User.register(request.form)
        session['user_id'] = user_id
        print(session['user_id'])
        return redirect('/dashboard')

@app.route('/login', methods=['POST'])
def login():
    logged_user = user.User.validate_login(request.form)
    print(logged_user)
    if not logged_user:
        return redirect('/')
    session['user_id'] = logged_user.id
    return redirect('/dashboard')

@app.route('/dashboard')
def dashboard():
    data = {'id' : session['user_id']}
    user_data = user.User.user_info(data)
    post_data = post.Post.get_all_posts_with_user()
    comment_data = comment.Comment.get_all_comments_with_user()
    return render_template('dashboard.html', user = user_data, posts = post_data, comments = comment_data)

@app.route('/logout', methods=['POST'])
def logout():
    session.pop('user_id')
    return redirect('/')