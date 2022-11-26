from flask import Flask, render_template, request, redirect, session
import random
app = Flask(__name__)
app.secret_key = "ouh key so secret"

@app.route('/')
def index():
    if 'money' not in session:
        session['money'] = 0   
        return render_template('index.html') 
    else:
        return render_template('index.html')

@app.route('/process_money', methods=["POST"])
def process_money():
    if request.form['gold'] == 'farm':
        num = random.randint(10,20)
        session['money'] += num
        session['income'] = num
    elif request.form['gold'] == 'cave':
        num = random.randint(5,10)
        session['money'] += num
        session['income'] = num
    elif request.form['gold'] == 'house':
        num = random.randint(2,5)
        session['money'] += num
        session['income'] = num
    elif request.form['gold'] == 'casino':
        num = random.randint(-50,50)
        session['money'] += num
        session['income'] = num
    return redirect('/')

if __name__ == "__main__":
    app.run(debug=True)