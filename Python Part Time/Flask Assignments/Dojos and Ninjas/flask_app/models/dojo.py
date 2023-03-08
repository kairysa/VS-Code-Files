from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import ninja

class Dojo:
    db = 'dojos_and_ninjas_schema'

    def __init__(self,data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.ninjas = []
    
    @classmethod
    def get_dojos(cls):
        query = "SELECT * FROM dojos"
        results = connectToMySQL(cls.db).query_db(query)
        dojos = []
        for dojo in results:
            dojos.append(cls(dojo))
        return dojos
    
    @classmethod
    def create_dojo(cls,data):
        query = "INSERT INTO dojos (name, created_at, updated_at) VALUES ( %(name)s, NOW(), NOW())"
        return connectToMySQL(cls.db).query_db(query,data)

    @classmethod
    def get_dojo_with_ninjas(cls,data):
        query = "SELECT * FROM dojos LEFT JOIN ninjas on dojos.id = ninjas.dojo_id WHERE dojos.id = %(id)s"
        results = connectToMySQL(cls.db).query_db(query,data)
        dojo = cls(results[0])
        for info in results:
            ninja_data = {
                'id' : info['ninjas.id'],
                'first_name' : info['first_name'],
                'last_name' : info['last_name'],
                'age' : info['age'],
                'created_at' : info['ninjas.created_at'],
                'updated_at' : info['ninjas.updated_at'],
                'dojo_id' : info['dojo_id']
            }
            dojo.ninjas.append(ninja.Ninja(ninja_data))
        return dojo