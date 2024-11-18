import './AlumnoRow.css';
import {TableCell, TableRow} from "@mui/material";


function AlumnoRow(props) {
    return (
        <TableRow>
            <TableCell>{props.alumno.id}</TableCell>
            <TableCell>{props.alumno.idUser}</TableCell>
            <TableCell>{props.alumno.nombre}</TableCell>
            <TableCell>{props.alumno.apellido}</TableCell>
            <TableCell>{props.alumno.email}</TableCell>
        </TableRow>
    );
}

export default AlumnoRow;
