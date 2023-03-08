from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import author

class Book:
    db = 'books_and_authors_schema'

    def __init__(self,data):
        self.id = data['id']
        self.title = data['title']
        self.num_of_pages = data['num_of_pages']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.authors = []

    @classmethod
    def all_books(cls):
        query = "SELECT * FROM books"
        results = connectToMySQL(cls.db).query_db(query)
        books = []
        for info in results:
            books.append(cls(info))
        return books

    @classmethod
    def get_book_with_authors(cls, data):
        query = """
                SELECT * FROM books
                LEFT JOIN favorites ON favorites.book_id = books.id
                LEFT JOIN authors ON favorites.author_id = authors.id
                WHERE books.id = %(id)s;
                """
        results = connectToMySQL(cls.db).query_db(query,data)
        book = cls(results[0])
        for info in results:
            author_data = {
                'id' : info['authors.id'],
                'name' : info['name'],
                'created_at' : info['authors.created_at'],
                'updated_at' : info['authors.updated_at']
            }
            book.authors.append(author.Author(author_data))
        return book

    @classmethod
    def add_book(cls, data):
        query = """
                INSERT INTO books ( title, num_of_pages, created_at, updated_at)
                VALUES ( %(title)s, %(num_of_pages)s, NOW(), NOW() );
                """
        return connectToMySQL(cls.db).query_db(query, data)

    @classmethod
    def add_books_favorite(cls,data):
        query = """
                INSERT INTO favorites ( book_id, author_id )
                VALUES ( %(book_id)s, %(author_id)s )
                """/
        return connectToMySQL(cls.db).query_db(query,data)