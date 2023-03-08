from flask_app import app
from flask import render_template, redirect, session, request, flash
from flask_app.models.user import User #user is just example. the py file would typically be a pluralized form of whatever we're working on. (i.e: users.py whilst the model file would be user.py)

