from flask_app import app
from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_app.models import user, comment

class Post:
    db = 'users_schema'
    
    def __init__(self,data):
        self.id = data['id']
        self.content = data['content']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.comments = []
        self.creator = None

    @classmethod
    def create_post(cls, post_data):
        data = {
            'content' : post_data['content'],
            'user_id' : post_data['id']
        }

        query = """
                INSERT INTO posts (content, user_id)
                VALUES (%(content)s, %(user_id)s)
                """

        id = connectToMySQL(cls.db).query_db(query,data)
        print("__NEW POST__", id)
        return id

    @classmethod
    def delete_post(cls, post_data):
        data = {'id': post_data['id']}

        query = """
                DELETE FROM posts WHERE id = %(id)s
                """
        id = connectToMySQL(cls.db).query_db(query,data)
        print("__DELETED POST__", id)
        return id

    @classmethod
    def get_all_posts_with_user(cls):
        query = """
                SELECT * FROM posts JOIN users ON posts.user_id = users.id;
                """
        results = connectToMySQL(cls.db).query_db(query)
        all_posts = []
        for row in results:
            one_post = cls(row)
            one_posts_user_info = {
                'id' : row['users.id'],
                'first_name': row['first_name'],
                'last_name' : row['last_name'],
                'email' : row['email'],
                'password' : row['password'],
                'created_at' : row['users.created_at'],
                'updated_at' : row['users.updated_at']
            }
            poster = user.User(one_posts_user_info)
            
            print(poster)
            print(one_posts_user_info)
            
            one_post.creator = poster

            all_posts.append(one_post)
        return all_posts

    @staticmethod
    def validate_post(post):
        is_valid = True
        if len(post['content']) == 0:
            flash('* Post content cannot be blank!', 'post')
            is_valid = False
        return is_valid
