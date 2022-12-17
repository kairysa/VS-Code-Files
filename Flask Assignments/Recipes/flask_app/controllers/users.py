from flask import render_template, redirect, request, session
from flask_app import app
from flask_app.models import user, recipe

## LOGIN/LOGOUT/DASHBOARD
@app.route('/')
def login_register():
    return render_template('index.html')

@app.route('/register', methods=['POST'])
def register():
    if not user.User.validate_reg(request.form):
        return redirect('/')
    else:
        user_id = user.User.register(request.form)
        session['user_id'] = user_id
        print(session['user_id'])
        return redirect('/recipes')

@app.route('/home', methods=['POST'])
def home():
    return redirect('/recipes')

@app.route('/login', methods=['POST'])
def login():
    logged_user = user.User.validate_login(request.form)
    if not logged_user:
        return redirect('/')
    session['user_id'] = logged_user.id
    return redirect('/recipes')
    
@app.route('/recipes')
def dashboard():
    data = {'id' : session['user_id']}
    user_data = user.User.user_info(data)
    recipe_data = recipe.Recipe.all_recipes()
    return render_template('recipes.html',user_data = user_data, recipe_data = recipe_data)

@app.route('/logout', methods=['POST'])
def logout():
    session.pop('user_id')
    return redirect('/')