const express = require('express')
const swig = require('swig')
const app = express()
const port = 3000

const db = require('./modules/gestor-db')
db.init("database.db")

app.get('/api/alumnos', (req, res) => {
    db.obtenerAlumnos((alumnos) => {
        if (alumnos == null) {
            res.status(500);
            res.json({ error: "Se ha producido un error" });
        } else {
            res.status(200)
            res.send(JSON.stringify(alumnos));
        }
    })
});

app.get('/alumnos', (req, res) => {
    db.obtenerAlumnos((alumnos) => {
        if (alumnos == null) {
            alumnos = [];
        }

        var respuesta = swig.renderFile('views/ListadoAlumnos.html', {
            alumnos: alumnos
        });
        res.send(respuesta);
    })
});

app.listen(port, () => {
    console.log(`Servidor escuchando en el puerto ${port}`)
})