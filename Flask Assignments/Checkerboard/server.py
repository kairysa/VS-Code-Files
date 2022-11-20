from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def base():
    return render_template("base.html")

@app.route('/4')
def basefour():
    return render_template("basefour.html")

@app.route("/<int:num>/<int:num2>/")
def customboarddefault(num,num2): 
    return render_template("custom.html",num=int(num),num2=int(num2))

@app.route("/<int:num>/<int:num2>/<string:color1>/<string:color2>/")
def customboard(num,num2,color1,color2):
    return render_template("custom.html",num=int(num),num2=int(num2),color1=color1,color2=color2)


if __name__ == "__main__":
    app.run(debug=True)