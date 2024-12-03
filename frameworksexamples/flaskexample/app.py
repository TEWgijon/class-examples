from flask import Flask, render_template

app = Flask(__name__)


@app.route('/')
def hello_world():
    alumnos = [
        {"id": 1, "idUser": 1234, "nombre": "Juan", "apellido": "Pérez", "email": "juanpe@email.com"},
        {"id": 2, "idUser": 2314, "nombre": "Sara", "apellido": "Álvarez", "email": "saraal@email.com"},
        {"id": 3, "idUser": 6543, "nombre": "Oscar", "apellido": "Iglesias", "email": "oscarig@email.com"},
    ]
    return render_template("listado.html", alumnos=alumnos)


if __name__ == '__main__':
    app.run()
