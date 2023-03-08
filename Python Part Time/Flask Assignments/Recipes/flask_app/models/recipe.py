from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_app.models import user
import re

from flask_app import app
from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)


class Recipe:
    db = 'recipes'

    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.description = data['description']
        self.instructions = data['instructions']
        self.date_cooked = data['date_cooked']
        self.under_thirty = data['under_thirty']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.user = None

    ## CLASSMETHODS FOR INSERTING, UPDATING, AND DELETING DATA
    @classmethod
    def new_recipe(cls,recipe_data):
        data = {
            'name' : recipe_data['name'],
            'description' : recipe_data['description'],
            'instructions' : recipe_data['instructions'],
            'date_cooked' : recipe_data['date_cooked'],
            'under_thirty' : recipe_data['under_thirty'],
            'user_id' : recipe_data['user_id']
        }
        query = """
                INSERT INTO recipes (name, description, instructions, date_cooked, under_thirty, user_id)
                VALUES (%(name)s, %(description)s, %(instructions)s, %(date_cooked)s, %(under_thirty)s, %(user_id)s)
                """

        id = connectToMySQL(cls.db).query_db(query,data)
        print("__NEW RECIPE ID__",id)
        return id
    
    @classmethod
    def edit_recipe(cls,recipe_data):
        data = {
            'id' : recipe_data['id'],
            'name' : recipe_data['name'],
            'description' : recipe_data['description'],
            'instructions' : recipe_data['instructions'],
            'date_cooked' : recipe_data['date_cooked'],
            'under_thirty' : recipe_data['under_thirty'],
        }
        query = """
                UPDATE recipes SET
                name = %(name)s, description = %(description)s, instructions = %(instructions)s, date_cooked = %(date_cooked)s, under_thirty = %(under_thirty)s, updated_at = NOW()
                WHERE id = %(id)s
                """
        id = connectToMySQL(cls.db).query_db(query,data)
        print("__UPDATED RECIPE ID__",id)
        return id
    
    @classmethod
    def delete_recipe(cls,recipe_data):
        data = {'id': recipe_data['id']}
        query = "DELETE FROM recipes WHERE id = %(id)s"
        id = connectToMySQL(cls.db).query_db(query,data)
        print("__DELETED RECIPE ID__",id)
        return id

    ## SELECTING RECIPE DATA
    @classmethod
    def all_recipes(cls):
        query = """
                SELECT * FROM recipes JOIN users on recipes.user_id = users.id
                """
        results = connectToMySQL(cls.db).query_db(query)
        all_recipes = []
        for info in results:
            one_recipe = cls(info)
            one_users_info = {
                'id' : info['users.id'],
                'first_name': info['first_name'],
                'last_name' : info['last_name'],
                'email' : info['email'],
                'password' : info['password'],
                'created_at' : info['users.created_at'],
                'updated_at' : info['users.updated_at']
            }
            recipe_creator = user.User(one_users_info)
            print(recipe_creator)
            print(one_users_info)

            one_recipe.user = recipe_creator

            all_recipes.append(one_recipe)
        return all_recipes

    @classmethod
    def one_recipe(cls,data):
        query = """
                SELECT * FROM recipes JOIN users on recipes.user_id = users.id
                WHERE recipes.id = %(id)s
                """
        results = connectToMySQL(cls.db).query_db(query,data)
        one_recipe = []
        for info in results:
            recipe_data = cls(info)
            one_users_info = {
                'id' : info['users.id'],
                'first_name': info['first_name'],
                'last_name' : info['last_name'],
                'email' : info['email'],
                'password' : info['password'],
                'created_at' : info['users.created_at'],
                'updated_at' : info['users.updated_at']
            }
            recipe_creator = user.User(one_users_info)
            print(recipe_creator)
            print(one_users_info)

            recipe_data.user = recipe_creator

            one_recipe.append(recipe_data)
        return one_recipe
        
    ## VALIDATING RECIPE INPUT
    @staticmethod
    def validate_recipe(recipe_data):
        is_valid = True

        # LENGTHS AND BLANK FIELDS
        if len(recipe_data['name']) == 0 or len(recipe_data['description']) == 0 or len(recipe_data['instructions']) == 0:
            flash('Fields cannot be blank!')
            is_valid = False
        elif len(recipe_data['name']) < 3:
            flash('Name must be at least 2 characters.')
            is_valid = False
        elif len(recipe_data['description']) < 7 or len(recipe_data['instructions']) < 7:
            flash('Description and Instructions need at least 8 characters.')
            is_valid = False

        # DATE AND UNDER THIRTY
        if not recipe_data['date_cooked']:
            flash('Must input date cooked.')
            is_valid = False
        if 'under_thirty' not in recipe_data:
            flash('Please select a Y/N option.')
            is_valid = False
        return is_valid
