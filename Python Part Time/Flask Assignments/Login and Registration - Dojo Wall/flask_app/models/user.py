from flask_app import app
from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_bcrypt import Bcrypt
import re
from flask_app.models import comment, post

bcrypt = Bcrypt(app)

ALPHABETICAL_REGEX = re.compile(r'^[a-zA-Z ]+$')
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

class User:
    db = 'users_schema'

    def __init__(self,data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.posts = []
        self.comments = []

    @classmethod
    def register(cls, request_data):
        pw_hash = bcrypt.generate_password_hash(request_data['password'])
        data = {
            'first_name' : request_data['first_name'],
            'last_name' : request_data['last_name'],
            'email' : request_data['email'],
            'password' : pw_hash
            }
        query = """
                INSERT INTO users (first_name, last_name, email, password, created_at, updated_at)
                VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s, NOW(), NOW());
                """
        id = connectToMySQL(cls.db).query_db(query,data)
        print("Registered User ID: ",id)
        return id
    
    @classmethod
    def get_by_email(cls,email):
        data = {'email': email}
        query = """
                SELECT * FROM users WHERE email = %(email)s;
                """
        results = connectToMySQL(cls.db).query_db(query,data)
        if len(results) == 0:
            return False
        else:
            return cls(results[0])

    @classmethod
    def user_info(cls, data):
        query = """
            SELECT * FROM users WHERE id = %(id)s
            """
        return connectToMySQL(cls.db).query_db(query,data)

    # validate registration
    @staticmethod
    def validate_reg(reg):
        is_valid = True
        email_in_db = User.get_by_email(reg['email'])

        if len(reg['first_name']) == 0 or len(reg['last_name']) == 0 or len(reg['email']) == 0 or len(reg['password']) == 0:
            flash('All fields are required.')
            is_valid = False
        elif len(reg['first_name']) < 2:
            flash('First name must be at least 2 characters.')
            is_valid = False
        elif len(reg['last_name']) < 2:
            flash('Last name must be at least 2 characters.')
            is_valid = False
        elif len(reg['password']) < 8:
            flash('Password must be at least 8 characters.')
            is_valid = False

        elif not ALPHABETICAL_REGEX.match(reg['first_name']):
            flash('First name can only be Alphabetical letters.')
            is_valid = False
        elif not ALPHABETICAL_REGEX.match(reg['first_name']):
            flash('Last name can only be Alphabetical letters.')
            is_valid = False

        if not EMAIL_REGEX.match(reg['email']):
            flash('Invalid Email Format.')
            is_valid = False
        if email_in_db is not False:
            flash("User with this email already exists!")
            is_valid = False
        if reg['confirm-password'] != reg['password']:
            flash('Passwords must match!')
            is_valid = False
        return is_valid

    #validate login
    @staticmethod
    def validate_login(login):
        is_valid = True
        user_in_db = User.get_by_email(login['email'])
        print(user_in_db)

        if not login['email'] or not EMAIL_REGEX.match(login['email']):
            flash('Invalid Email Address!')
            is_valid = False
        if user_in_db is False:
            flash('Incorrect Email/Password.')
            is_valid = False
        
        else:
            if len(login['password']) < 8 or not bcrypt.check_password_hash(user_in_db.password,login['password']):
                flash('Incorrect Email/Password.')
                is_valid = False
        
        if is_valid:
            return user_in_db
        else: 
            return is_valid