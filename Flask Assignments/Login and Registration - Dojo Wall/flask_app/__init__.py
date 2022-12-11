from flask import Flask
app = Flask(__name__)
app.secret_key = "gotta keep these logins secret"