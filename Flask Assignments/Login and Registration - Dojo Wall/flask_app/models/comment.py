from flask_app import app
from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_app.models import user, post

class Comment:
    db = 'users_schema'
    
    def __init__(self,data):
        self.id = data['id']
        self.content = data['content']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.post = None
        self.creator = None

    @classmethod
    def publish_comment(cls, comment_data):
        data = {
            'content' : comment_data['content'],
            'post_id' : comment_data['post_id'],
            'user_id' : comment_data['user_id']
        }
        query = """
                INSERT INTO comments (content, post_id, user_id)
                VALUES (%(content)s, %(post_id)s, %(user_id)s)
                """

        id = connectToMySQL(cls.db).query_db(query,data)
        print('__PUBLISHED COMMENT__', id)
        return id

    @classmethod
    def delete_post(cls, comment_data):
        data = {'id': comment_data['id']}

        query = """
                DELETE FROM comments WHERE id = %(id)s
                """
        id = connectToMySQL(cls.db).query_db(query,data)
        print("__DELETED COMMENT__", id)
        return id

    @classmethod
    def get_all_comments_with_user(cls):
        query = """
                SELECT * FROM comments 
                JOIN users ON comments.user_id = users.id
                JOIN posts on comments.post_id = posts.id
                """
        results = connectToMySQL(cls.db).query_db(query)
        all_comments = []
        for row in results:
            one_comment = cls(row)
            one_comments_user_info = {
                'id' : row['users.id'],
                'first_name': row['first_name'],
                'last_name' : row['last_name'],
                'email' : row['email'],
                'password' : row['password'],
                'created_at' : row['users.created_at'],
                'updated_at' : row['users.updated_at']
            }
            commenter = user.User(one_comments_user_info)
            one_posts_info = {
                'id' : row['posts.id'],
                'content' : row['posts.content'],
                'created_at' : row['posts.created_at'],
                'updated_at' : row['posts.updated_at']
            }
            post_info = post.Post(one_posts_info)
            
            print(commenter)
            print(post_info)
            
            one_comment.creator = commenter
            one_comment.post = post_info

            all_comments.append(one_comment)
        return all_comments

    @staticmethod
    def validate_comment(comment):
        is_valid = True
        if len(comment['content']) == 0:
            flash('* Comment content cannot be blank!','comment')
            is_valid = False
        return is_valid
