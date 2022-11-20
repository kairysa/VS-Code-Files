from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)

@app.route('/')
def index():
    return render_template("index.html")

@app.route('/checkout',methods=['POST'])
def fruit_list():
    print(request.form)
    redirect("receipt")

@app.route("/receipt")
def show_user():
    print("Showing the User the checkout screen")
    return render_template("checkout.html")

if __name__ == "__main__":
    app.run(debug=True)