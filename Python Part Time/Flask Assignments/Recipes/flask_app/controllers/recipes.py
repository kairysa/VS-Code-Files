from flask import render_template, redirect, request, session
from flask_app import app
from flask_app.models import recipe, user

## NEW RECIPE ROUTES
@app.route('/new_recipe', methods=['POST'])
def recipe_page_link():
    return redirect('/new')

@app.route('/new')
def recipe_page():
    data = {'id' : session['user_id']}
    user_data = user.User.user_info(data)
    return render_template('/new_recipe.html', user_data = user_data)

@app.route('/publish', methods=['POST'])
def publish():
    if not recipe.Recipe.validate_recipe(request.form):
        return redirect('/new')
    else:
        new_recipe = recipe.Recipe.new_recipe(request.form)
        print("__NEW RECIPE__", new_recipe)
        return redirect('/recipes')

## VIEW, EDIT, AND DELETE ROUTES

@app.route('/edit/<int:id>')
def edit_page(id):
    data = {'id' : id}
    selected_recipe = recipe.Recipe.one_recipe(data)
    for info in selected_recipe:
        if info.user.id != session['user_id']:
            redirect('/recipes')
        else:
            return render_template('edit_recipe.html', recipe_data = selected_recipe)
    return redirect('/recipes')

@app.route('/apply_changes',methods=['POST'])
def edit_recipe():
    if not recipe.Recipe.validate_recipe(request.form):
        id = request.form['id']
        return redirect(f'edit/{id}')
    else:
        recipe.Recipe.edit_recipe(request.form)
        return redirect('/recipes')

@app.route('/view/<int:id>')
def view_page(id):
    data = {'id' : id}
    user_info = {'id' : session['user_id']}
    recipe_data = recipe.Recipe.one_recipe(data)
    user_data = user.User.user_info(user_info)
    return render_template('view_recipe.html', recipe_data = recipe_data, user_data = user_data)

@app.route('/delete/<int:id>')
def delete_recipe(id):
    data = {'id': id}
    selected_recipe = recipe.Recipe.one_recipe(data)
    for info in selected_recipe:
        if info.user.id != session['user_id']:
            redirect('/recipes')
        else:
            recipe.Recipe.delete_recipe(data)
    return redirect('/recipes')
