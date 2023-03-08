from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
import re

from flask_app import app
from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)

ALPHABETICAL_REGEX = re.compile(r'^[a-zA-Z ]+$')
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

class User:
    db = 'sasquatches_db'

    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    ## CLASSMETHODS FOR INPUTTING, EDITING, SELECTING, AND DELETING DATA
    @classmethod
    def register(cls, user_data):
        hashed_pw = bcrypt.generate_password_hash(user_data['password'])
        data = {
            'first_name' : user_data['first_name'],
            'last_name' : user_data['last_name'],
            'email' : user_data['email'],
            'password' : hashed_pw,
        }
        query = """
                INSERT INTO users (first_name, last_name, email, password)
                VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s);
                """
        id = connectToMySQL(cls.db).query_db(query,data)
        print('__REGISTERED USER ID__', id)
        return id

    @classmethod
    def login(cls,email):
        data = {'email': email}
        query = """
                SELECT * FROM users WHERE email = %(email)s;
                """
        results = connectToMySQL(cls.db).query_db(query,data)
        if len(results) == 0:
            return False
        else:
            return cls(results[0])


    ## CLASSMETHOD FOR SELECT DATA
    def all_users(cls):
        query = """
                SELECT * FROM users;
                """
        results = connectToMySQL(cls.db).query_db(query)
        users = []
        for info in results:
            users.append(cls(info))
        return users

    @classmethod
    def user_info(cls, data):
        query = """
            SELECT * FROM users WHERE id = %(id)s
            """
        return connectToMySQL(cls.db).query_db(query,data)

    ## STATICMETHODS FOR VALIDATING USER INPUT
    @staticmethod
    def validate_reg(input):
        is_valid = True
        user_exists = User.login(input['email'])
        
        # LENGTHS
        if len(input['first_name']) == 0 or len(input['last_name']) == 0 or len(input['email']) == 0 or len(input['password']) == 0:
            flash('Fields must not be blank!','register')
            is_valid = False
        elif len(input['first_name']) < 3:
            flash('First name must be at least 2 characters.','register')
            is_valid = False
        elif len(input['last_name']) < 3:
            flash('Last name must be at least 2 characters.','register')
            is_valid = False
        elif len(input['password']) < 7:
            flash('Password must be at least 8 characters.','register')
            is_valid = False

        # FORMAT AND CHARACTERS
        elif not EMAIL_REGEX.match(input['email']):
            flash('Invalid Email Format.')
            is_valid = False
        if not ALPHABETICAL_REGEX.match(input['first_name']):
            flash('First name can only be alphabetical letters.','register')
            is_valid = False
        if not ALPHABETICAL_REGEX.match(input['last_name']):
            flash('Last name can only be alphabetical letters.','register')
            is_valid = False
        if input['confirm_password'] != input['password']:
            flash('Passwords must match!','register')
            is_valid = False

        # EXISTING USER
        if user_exists is not False:
            flash('Email already exists.','register')
            is_valid = False
        return is_valid

    ## VALIDATE LOGIN
    @staticmethod
    def validate_login(login):
        is_valid = True
        user_in_db = User.login(login['email'])
        print(user_in_db)

        if not login['email'] or not EMAIL_REGEX.match(login['email']):
            flash('Invalid Email Address!','login')
            is_valid = False
        if user_in_db is False:
            flash('Incorrect Email/Password.','login')
            is_valid = False
        
        else:
            if len(login['password']) < 7 or not bcrypt.check_password_hash(user_in_db.password,login['password']):
                flash('Incorrect Email/Password.','login')
                is_valid = False
        
        if is_valid:
            return user_in_db
        else: 
            return is_valid
