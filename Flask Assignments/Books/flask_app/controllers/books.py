from flask_app import app
from flask import render_template, redirect, request
from flask_app.models.book import Book
from flask_app.models.author import Author


@app.route('/add_book', methods=['POST'])
def add_book():
    data = {
        'title' : request.form['title'],
        'num_of_pages' : request.form['num_of_pages']
    }
    Book.add_book(data)
    return redirect('/books')

@app.route('/books_link', methods=['POST'])
def books_link():
    return redirect('/books')

@app.route('/books')
def all_books():
    return render_template('books.html', books = Book.all_books())

@app.route('/books_favorites/<int:id>/post', methods=['POST'])
def books_favorites_post(id):
    return redirect(f"/books_favorites/{id}")

@app.route('/books_favorites/<int:id>')
def books_favorites(id):
    data = {
        'id' : id
    }
    favorites = Book.get_book_with_authors(data)
    all_authors = Author.all_authors()
    return render_template('book_authors.html', favorites = favorites, all_authors = all_authors)

@app.route('/add_book_favorite/<int:id>', methods=['POST'])
def add_book_favorites(id):
    data = {
        'author_id' : request.form['author_id'],
        'book_id' : id
    }
    Book.add_books_favorite(data)
    return redirect(f"/books_favorites/{id}")