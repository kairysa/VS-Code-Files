from flask import Flask, render_template, session, redirect, request
app = Flask(__name__)
app.secret_key = "The most secret of secret keys to ever exist"
import random

@app.route('/')
def index():
    if 'randomInt' not in session:
        session['randomInt'] = random.randint(1, 100)
        return render_template('index.html')
    else:
        return render_template('index.html')
    

@app.route('/guess', methods=['POST'])
def guess():
    session['guess'] = int(request.form['guesser'])
    return redirect('/')

@app.route('/repeat', methods=['POST'])
def clear():
    session.pop('randomInt')
    session.pop('guess')
    return redirect('/')

if __name__ == "__main__":
    app.run(debug=True)