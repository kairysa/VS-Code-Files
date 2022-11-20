from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'

@app.route('/')
def counter():
    if 'visits' in session:
        session['visits'] += 1
    elif 'visits' not in session:
        session['visits'] = 1
    return render_template("index.html")

@app.route('/add', methods=['POST'])
def plusOne():
    return redirect('/')

@app.route('/add2', methods=['POST'])
def plusTwo():
    session['visits'] += 1
    return redirect('/')
    
@app.route('/clear', methods=['POST'])
def clearVisits():
    session['visits'] = 0
    return redirect('/')

@app.route('/destroy_session')
def destroySession():
    session.pop('visits')
    return redirect('/')

@app.route('/custom', methods=['POST'])
def customValue():
    session['visits'] += (int(request.form['customValue']) - 1)
    return redirect('/')

if __name__ == "__main__":
    app.run(debug=True)

