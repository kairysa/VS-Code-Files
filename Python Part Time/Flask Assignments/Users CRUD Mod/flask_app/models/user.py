from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
import re

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')



class User:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.posts = []
    
    @classmethod
    def users_info(cls):
        query = "SELECT * FROM users"
        results = connectToMySQL('users_cr').query_db(query)
        users = []
        for user in results:
            users.append( cls(user))
        return users

    @classmethod
    def save(cls,data):
        query = "INSERT INTO users (first_name, last_name, email, created_at, updated_at) VALUES ( %(fname)s, %(lname)s, %(email)s, NOW(), NOW());"
        return connectToMySQL('users_cr').query_db(query,data)
    @classmethod
    def edit(cls,data):
        query = "UPDATE users SET first_name = %(fname)s, last_name = %(lname)s, email = %(email)s, updated_at = NOW() WHERE id = %(id)s"
        return connectToMySQL('users_cr').query_db(query,data)
    @classmethod
    def get_user(cls,data):
        query = "SELECT * FROM users WHERE id = %(id)s"
        return connectToMySQL('users_cr').query_db(query,data)
    @classmethod
    def delete_user(cls,data):
        query = "DELETE FROM users WHERE id = %(id)s"
        return connectToMySQL('users_cr').query_db(query,data)

    @staticmethod
    def validate_user(user):
        is_valid = True

        if len(user['email']) == 0:
            flash('Email is required.')
            is_valid = False
        elif not EMAIL_REGEX.match(user['email']):
            flash('Invalid Email Format!')
            is_valid = False
        if len(user['fname']) < 3:
            flash('First name must be at least 3 characters.')
            is_valid = False
        if len(user['lname']) < 3:
            flash('Last name must be at least 3 characters.')
            is_valid = False
        
        return is_valid