from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_app.models import user

from flask_app import app
from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)


class Sighting:
    db = 'sasquatches_db'

    def __init__(self, data):
        self.id = data['id']
        self.location = data['location']
        self.what_happened = data['what_happened']
        self.date_of_sighting = data['date_of_sighting']
        self.num_of_sasquatches = data['num_of_sasquatches']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.user = None

    ## CLASSMETHODS FOR INSERTING, UPDATING, AND DELETING DATA
    @classmethod
    def new_sighting(cls,sighting_data):
        data = {
            'location' : sighting_data['location'],
            'what_happened' : sighting_data['what_happened'],
            'date_of_sighting' : sighting_data['date_of_sighting'],
            'num_of_sasquatches' : sighting_data['num_of_sasquatches'],
            'user_id' : sighting_data['user_id']
        }
        query = """
                INSERT INTO sightings (location, what_happened, date_of_sighting, num_of_sasquatches, user_id)
                VALUES (%(location)s, %(what_happened)s, %(date_of_sighting)s, %(num_of_sasquatches)s, %(user_id)s);
                """

        id = connectToMySQL(cls.db).query_db(query,data)
        print("__NEW SIGHTING ID__",id)
        return id
    
    @classmethod
    def edit_sighting(cls,sighting_data):
        data = {
            'id' : sighting_data['id'],
            'location' : sighting_data['location'],
            'what_happened' : sighting_data['what_happened'],
            'date_of_sighting' : sighting_data['date_of_sighting'],
            'num_of_sasquatches' : sighting_data['num_of_sasquatches'],
        }
        query = """
                UPDATE sightings SET
                location = %(location)s, what_happened = %(what_happened)s, date_of_sighting = %(date_of_sighting)s, num_of_sasquatches = %(num_of_sasquatches)s, updated_at = NOW()
                WHERE sightings.id = %(id)s;
                """
        id = connectToMySQL(cls.db).query_db(query,data)
        print("__UPDATED SIGHTING ID__",id)
        return id
    
    @classmethod
    def delete_sighting(cls,sighting_data):
        data = {'id': sighting_data['id']}
        query = "DELETE FROM sightings WHERE id = %(id)s"
        id = connectToMySQL(cls.db).query_db(query,data)
        print("__DELETED SIGHTING ID__",id)
        return id

    ## SELECTING SIGHTING DATA
    @classmethod
    def all_sightings(cls):
        query = """
                SELECT * FROM sightings JOIN users on sightings.user_id = users.id
                """
        results = connectToMySQL(cls.db).query_db(query)
        all_sightings = []
        for info in results:
            one_sighting = cls(info)
            one_users_info = {
                'id' : info['users.id'],
                'first_name': info['first_name'],
                'last_name' : info['last_name'],
                'email' : info['email'],
                'password' : info['password'],
                'created_at' : info['users.created_at'],
                'updated_at' : info['users.updated_at']
            }
            sighting_creator = user.User(one_users_info)
            print(sighting_creator)
            print(one_users_info)

            one_sighting.user = sighting_creator

            all_sightings.append(one_sighting)
        return all_sightings

    @classmethod
    def one_sighting(cls,data):
        query = """
                SELECT * FROM sightings JOIN users on sightings.user_id = users.id
                WHERE sightings.id = %(id)s
                """
        results = connectToMySQL(cls.db).query_db(query,data)
        one_sighting = []
        for info in results:
            sighting_data = cls(info)
            one_users_info = {
                'id' : info['users.id'],
                'first_name': info['first_name'],
                'last_name' : info['last_name'],
                'email' : info['email'],
                'password' : info['password'],
                'created_at' : info['users.created_at'],
                'updated_at' : info['users.updated_at']
            }
            sighting_creator = user.User(one_users_info)
            print(sighting_creator)
            print(one_users_info)

            sighting_data.user = sighting_creator

            one_sighting.append(sighting_data)
        return one_sighting
        
    ## VALIDATING SIGHTING INPUT
    @staticmethod
    def validate_sighting(sighting_data):
        is_valid = True

        # LENGTHS AND BLANK FIELDS
        if len(sighting_data['location']) == 0 or len(sighting_data['what_happened']) == 0:
            flash('All fields required.')
            is_valid = False
        elif len(sighting_data['location']) < 1:
            flash('Location must be at least 2 characters.')
            is_valid = False
        if sighting_data['num_of_sasquatches'] < str(1):
            flash('Mininum of 1 sasquatch required.')
            is_valid = False

        # DATE
        if not sighting_data['date_of_sighting']:
            flash('Must input date of sighting.')
            is_valid = False
        return is_valid
