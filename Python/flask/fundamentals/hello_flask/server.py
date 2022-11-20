from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def hello_world():
    return render_template("index.html")

@app.route('/success')
def success():
    return "Success!"

@app.route('/dojo')
def dojo():
    return "Dojo!"

@app.route('/hello/<string:banana>/<int:num>')
def hello(banana,num):
    return render_template("hello.html",banana=banana,num=num)

if __name__=="__main__":    
    app.run(debug=True)

# import statements, maybe some other routes

