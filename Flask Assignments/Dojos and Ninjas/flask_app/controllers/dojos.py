from flask_app import app
from flask import render_template, request, redirect, session, url_for
from flask_app.models.dojo import Dojo

@app.route('/')
def index():
    return render_template('index.html', dojos=Dojo.get_dojos())

@app.route('/new_dojo', methods=['POST'])
def new_dojo():
    data = {
        'name' : request.form['name']
    }
    Dojo.create_dojo(data)
    return redirect('/')

@app.route('/add_ninja', methods=["POST"])
def ninja_redirect():
    return redirect('/new_ninja_page')

@app.route('/new_ninja_page')
def ninja_page():
    return render_template('new_ninja.html', dojos=Dojo.get_dojos())

@app.route('/home', methods=['POST'])
def home():
    return redirect('/')

@app.route('/select_dojo/<int:id>/post', methods=["POST"])
def select_dojo(id):
    return redirect(f"/select_dojo/{id}")

@app.route('/select_dojo/<int:id>')
def selected_dojo(id):
    data = {
        'id' : id
    }
    all_info = Dojo.get_dojo_with_ninjas(data)
    return render_template('dojos_with_ninjas.html',all_info = all_info)
