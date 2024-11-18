import './App.css';
import {AppBar, Box, createTheme, CssBaseline, ThemeProvider, Toolbar, Typography} from "@mui/material";
import PanelListado from "./PanelListado";

function App() {

    return (
        <ThemeProvider theme={createTheme()}>
            <Box sx={{display: 'flex'}}>
                <CssBaseline/>
                <AppBar>
                    <Toolbar>
                        <Typography
                            component="h1"
                            variant="h6"
                            color="inherit"
                            noWrap
                            sx={{flexGrow: 1}}
                        >
                            Gestioneitor
                        </Typography>
                    </Toolbar>
                </AppBar>
                <Box
                    component="main"
                    sx={{
                        flexGrow: 1,
                        height: '90vh',
                        marginTop: '10vh',
                        overflow: 'auto',
                    }}
                >
                    <PanelListado/>
                </Box>
            </Box>
        </ThemeProvider>
    );
}

export default App;
