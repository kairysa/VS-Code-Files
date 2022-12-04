from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import book

class Author:
    db = 'books_and_authors_schema'

    def __init__(self,data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.books = []

    @classmethod
    def all_authors(cls):
        query = 'SELECT * FROM authors'
        results = connectToMySQL(cls.db).query_db(query)
        authors = []
        for info in results:
            authors.append(cls(info))
        return authors
    
    @classmethod
    def get_author_with_books(cls, data):
        query = """
                SELECT * FROM authors
                LEFT JOIN favorites ON favorites.author_id = authors.id
                LEFT JOIN books ON favorites.book_id = books.id
                WHERE authors.id = %(id)s
                """
        results = connectToMySQL(cls.db).query_db(query,data)
        author = cls(results[0])
        for info in results:
            book_data = {
                'id' : info['books.id'],
                'title' : info['title'],
                'num_of_pages' : info['num_of_pages'],
                'created_at' : info['books.created_at'],
                'updated_at' : info['books.updated_at']
            }
            author.books.append(book.Book(book_data))
        return author

    @classmethod
    def add_author(cls, data):
        query = """
                INSERT INTO authors (name, created_at, updated_at)
                VALUES ( %(name)s, NOW(), NOW() );
                """
        return connectToMySQL(cls.db).query_db(query, data)

    @classmethod
    def add_authors_favorite(cls,data):
        query = """
                INSERT INTO favorites ( book_id, author_id )
                VALUES ( %(book_id)s, %(author_id)s )
                """
        return connectToMySQL(cls.db).query_db(query,data)