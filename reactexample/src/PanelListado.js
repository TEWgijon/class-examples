import './PanelListado.css';
import {Button, Container, Grid, Paper} from "@mui/material";
import Listado from "./Listado";
import {useState} from "react";

function PanelListado() {
    const [visible, setVisible] = useState(true);

    function toggleVisible() {
        setVisible(!visible);
    }

    return (
        <Container maxWidth="lg" sx={{mt: 4, mb: 4}}>
            <Grid container spacing={3}>
                <Grid item xs={12}>
                    <Paper sx={{p: 2, display: 'flex', flexDirection: 'column'}}>
                        {visible && <Listado/>}
                    </Paper>
                </Grid>
            </Grid>

            <Button variant="contained" onClick={toggleVisible}>{visible ? "Ocultar" : "Mostrar"}</Button>
        </Container>
    );
}

export default PanelListado;
