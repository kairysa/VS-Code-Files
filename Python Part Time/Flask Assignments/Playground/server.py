from flask import Flask, render_template

app = Flask(__name__)

@app.route('/play')
def three_blue_boxes():
    return render_template("three_boxes.html")

@app.route('/play/<int:num>')
def x_boxes(num):
    return render_template("x_boxes.html",num=num)

@app.route('/play/<int:num>/<string:color>')
def x_boxes_color(num,color):
    return render_template("x_boxes_color.html",num=num,color=color)

if __name__ =="__main__":
    app.run(debug=True)