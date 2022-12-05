from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
import re

ALPHABETICAL_REGEX = re.compile(r'^[a-zA-Z ]+$') 

class Cookie:
    db = 'cookies_schema'

    def __init__(self,data):
        self.id = data['id']
        self.name = data['name']
        self.cookie_type = data['cookie_type']
        self.num_of_boxes = data['num_of_boxes']

    @classmethod
    def all_orders(cls):
        query = "SELECT * FROM cookies"
        results = connectToMySQL(cls.db).query_db(query)
        cookies = []
        for info in results:
            cookies.append(cls(info))
        return cookies

    @classmethod
    def one_order(cls,data):
        query = "SELECT * FROM cookies WHERE id = %(id)s"
        results = connectToMySQL(cls.db).query_db(query,data)
        order = []
        for info in results:
            order.append(cls(info))
        return order

    @classmethod
    def save(cls,data):
        query = """
                INSERT INTO cookies (name, cookie_type, num_of_boxes )
                VALUES (%(name)s, %(cookie_type)s, %(num_of_boxes)s)
                """
        return connectToMySQL(cls.db).query_db(query,data)

    @classmethod
    def edit(cls,data):
        query = """
                UPDATE cookies
                SET name = %(name)s, cookie_type = %(cookie_type)s, num_of_boxes = %(num_of_boxes)s
                WHERE id = %(id)s
                """
        return connectToMySQL(cls.db).query_db(query,data)

    @classmethod
    def delete(cls,data):
        query = """
                DELETE FROM cookies
                WHERE id = %(id)s
                """
        return connectToMySQL(cls.db).query_db(query,data)

    @staticmethod
    def validate_log(log):
        is_valid = True
        if len(log['name']) == 0 or len(log['cookie_type']) == 0:
            flash('All fields are required.')
            is_valid = False
        elif len(log['name']) < 2:
            flash('Name must be at least 2 characters long.')
            is_valid = False
        elif not ALPHABETICAL_REGEX.match(log['name']):
            flash('Name can only be Alphabetical letters')
            is_valid = False
        elif len(log['cookie_type']) < 2:
            flash('Cookie Type must be at least 2 characters long.')
            is_valid = False
        elif not ALPHABETICAL_REGEX.match(log['cookie_type']):
            flash('Cookie Type can only be Alphabetical letters')
            is_valid = False
        if log['num_of_boxes'] <= str(0):
            flash('You must order at least 1 box of cookies.')
            is_valid = False
        return is_valid