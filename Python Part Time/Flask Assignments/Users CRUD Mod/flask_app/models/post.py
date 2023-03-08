from flask_app.config.mysqlconnection import connectToMySQL

class Post:
    def __init__(self,data):
        self.content = data['content']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def save(cls,data):
        query = "INSERT INTO posts (content, created_at, updated_at, user_id) VALUES ( %(content)s, NOW(), NOW(), %(user_id)s);"
        return connectToMySQL('users_cr').query_db(query,data)
    @classmethod
    def get_posts(cls,data):
        query = "SELECT * FROM posts WHERE user_id = %(id)s"
        return connectToMySQL('users_cr').query_db(query,data)