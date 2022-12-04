from flask_app import app
from flask import render_template, redirect, request
from flask_app.models.author import Author
from flask_app.models.book import Book

@app.route('/')
def home():
    return render_template('authors.html', authors = Author.all_authors())

@app.route('/add_author', methods=['POST'])
def add_author():
    data = {
        'name' : request.form['name']
    }
    Author.add_author(data)
    return redirect('/')

@app.route('/author_favorites/<int:id>/post', methods=['POST'])
def author_favorites_post(id):
    return redirect(f"/author_favorites/{id}")

@app.route('/author_favorites/<int:id>')
def author_favorites(id):
    data = {
        'id' : id
    }
    favorites = Author.get_author_with_books(data)
    book_list = Book.all_books()
    return render_template('/author_favorites.html', favorites = favorites, book_list = book_list)

@app.route('/add_author_favorite/<int:id>', methods=['POST'])
def add_author_favorites(id):
    data = {
        'book_id' : request.form['book_id'],
        'author_id' : id
    }
    Author.add_authors_favorite(data)
    return redirect(f"/author_favorites/{id}")

@app.route('/home', methods=['POST'])
def return_home():
    return redirect('/')
