const sqlite3 = require('sqlite3').verbose();

module.exports = {
    db: null,
    init: function (connectionURL) {
        this.db = new sqlite3.Database(connectionURL, err => {
            if (err)
                console.error(err.message);
        });
    },
    obtenerAlumnos: function (funcionCallback) {
        if (this.db == null) {
            console.error("Database not connected");
            return funcionCallback(null);
        }
        this.db.all("SELECT * FROM Alumno", [], (err, rows) => {
            if (err) {
                console.error(err.message);
                return funcionCallback(null);
            }

            return funcionCallback(rows)
        });
    }
}