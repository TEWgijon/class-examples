const express = require('express')
const swig = require('swig')
const app = express()
const port = 3000

app.get('/', (req, res) => {
    var respuesta = swig.renderFile('views/MainMenu.html', {});
    res.send(respuesta);
})
app.get('/listado', (req, res) => {
    var respuesta = swig.renderFile('views/ListadoAlumnos.html', {});
    res.send(respuesta);
})

app.listen(port, () => {
    console.log(`Servidor escuchando en el puerto ${port}`)
})