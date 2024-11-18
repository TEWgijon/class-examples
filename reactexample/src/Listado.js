import './Listado.css';
import AlumnoRow from "./AlumnoRow";
import {Table, TableBody, TableCell, TableHead, TableRow} from "@mui/material";

const alumnos = [
    {id: 1, idUser: 1234, nombre: "Juan", apellido: "Pérez", email: "juanpe@email.com"},
    {id: 2, idUser: 2314, nombre: "Sara", apellido: "Álvarez", email: "saraal@email.com"},
    {id: 3, idUser: 6543, nombre: "Oscar", apellido: "Iglesias", email: "oscarig@email.com"},
];

function Listado() {
    const rows = alumnos.map(a =>
        <AlumnoRow alumno={a}/>
    );
    return (
        <Table>
            <TableHead>
                <TableRow>
                    <TableCell>id</TableCell>
                    <TableCell>idUser</TableCell>
                    <TableCell>Nombre</TableCell>
                    <TableCell>Apellido</TableCell>
                    <TableCell>Email</TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
                {rows}
            </TableBody>
        </Table>
    );
}

export default Listado;
