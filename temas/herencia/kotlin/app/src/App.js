import React, { useState } from 'react';
import { Container, styled, TextField, Button, Box, Typography, FormControl, InputLabel, Select, MenuItem, Paper, Grid, useTheme } from '@mui/material';


const StyledPaper = styled(Paper)(({ theme }) => ({
  marginTop: theme.spacing(2),
  padding: theme.spacing(2),
  backgroundColor: '#f7f7f7',
  fontFamily: 'Monospace',
  color: theme.palette.text.secondary,
  whiteSpace: 'pre-wrap', 
  overflowX: 'auto'   
}));

const Footer = styled('footer')(({ theme }) => ({
  marginTop: theme.spacing(8),
  padding: theme.spacing(3),
  backgroundColor: '#e3f2fd',
  color: theme.palette.text.secondary,
  textAlign: 'center'
}));

function App() {
  const theme = useTheme();
  const [inputs, setInputs] = useState([{ name: "", role: "" }]);
  const [output, setOutput] = useState("");
  const roles = ["Cantante", "Guitarrista", "Pianista", "Cantante y Guitarrista"];

  const handleInputChange = (index, field, value) => {
    const newInputs = [...inputs];
    newInputs[index][field] = value;
    setInputs(newInputs);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    const response = await fetch('/api/execute', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=utf-8',
      },
      body: JSON.stringify(inputs),
    });
    const data = await response.text();
    setOutput(data);
  };

  const addInput = () => {
    setInputs([...inputs, { name: "", role: "" }]);
  };

  return (
    <Box sx={{ flexGrow: 1}}>
      <Container maxWidth="md" sx={{ my: 4 }}>
        <Typography variant="h4" gutterBottom>
          Añade los miembros del grupo:
        </Typography>
        <form onSubmit={handleSubmit}>
          {inputs.map((input, index) => (
            <Box key={index} marginY={2}>
              <TextField
                fullWidth
                label="Nombre"
                variant="outlined"
                name="name"
                value={input.name}
                onChange={e => handleInputChange(index, 'name', e.target.value)}
                margin="normal"
              />
              <FormControl fullWidth margin="normal">
                <InputLabel>Rol</InputLabel>
                <Select
                  label="Rol"
                  name="role"
                  value={input.role}
                  onChange={e => handleInputChange(index, 'role', e.target.value)}
                >
                  {roles.map((role, i) => (
                    <MenuItem key={i} value={role}>{role}</MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Box>
          ))}
          <Grid container spacing={2}>
            <Grid item>
              <Button variant="contained" color="primary" onClick={addInput}>
                Añadir más
              </Button>
            </Grid>
            <Grid item>
              <Button variant="contained" color="secondary" type="submit">
                Ejecutar
              </Button>
            </Grid>
          </Grid>
          <Typography variant="h4" gutterBottom marginTop={4}>
            Al pulsar ejecutar verás los resultados de la actuación:
          </Typography>
          <StyledPaper elevation={3}>
            {output}
          </StyledPaper>
        </form>
      </Container>
      <Footer>
        <Typography variant="body1">
          Ejemplo Herencia con Kotlin.
        </Typography>
        <Typography variant="body2">
          Contacto: <a href="mailto:pabloarquecebri@gmail.com" style={{ color: theme.palette.secondary.main }}>pabloarquecebri@gmail.com</a>
        </Typography>
      </Footer>
    </Box>
  );
}

export default App;
