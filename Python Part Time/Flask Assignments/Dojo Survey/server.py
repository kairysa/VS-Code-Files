from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = "super secret key"

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/result', methods=['POST'])
def info():
    session['info'] = request.form
    print(session['info'])
    return redirect('/')

@app.route('/clear', methods=["POST"])
def clear():
    session.pop('info')
    return redirect('/')

if __name__ == "__main__":
    app.run(debug=True)