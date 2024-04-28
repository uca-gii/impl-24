import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Button, Container, Typography, Select, MenuItem, FormControl, InputLabel, Box, Paper } from '@mui/material';

function App() {
  const [code, setCode] = useState('');
  const [testCode, setTestCode] = useState('');
  const [testResults, setTestResults] = useState('');
  const [selectedFile, setSelectedFile] = useState('Animal');

  useEffect(() => {
    if (selectedFile) {
      // GET para mostrar códigos de ruby
      axios.get(`/api/code?file=${selectedFile}`).then(response => {
        setCode(response.data.source);
      }).catch(error => {
        console.error('Error fetching code:', error);
        alert('Error fetching code: ' + error.message);
      });
      
      // GET para mostrar códigos de test de ruby
      axios.get(`/api/test?file=${selectedFile}_test`).then(response => {
        setTestCode(response.data.results);
      }).catch(error => {
        console.error('Error fetching test results:', error);
        alert('Error fetching test results: ' + error.message);
      });
    }
  }, [selectedFile]);

  // Controla cada vez que se cambia de archivo
  const handleChange = (event) => {
    setSelectedFile(event.target.value);
  };

  
  const runTests = () => {
    // GET para mostrado de resultados de ejecución de test
    axios.get(`/api/run-test?file=${selectedFile}_test.rb`).then(response => {
      setTestResults(response.data.results);
    }).catch(error => {
      console.error('Error running tests:', error);
      alert('Error running tests: ' + error.message);
    });
  };

  // Cuerpo del index.html
  return (
    <Container maxWidth="md">
      <Box mt={4}>
        <FormControl fullWidth>
          <InputLabel id="demo-simple-select-label">Seleccionar Archivo</InputLabel>
          <Select
            labelId="demo-simple-select-label"
            id="demo-simple-select"
            value={selectedFile}
            label="Seleccionar Archivo"
            onChange={handleChange}
          >
            <MenuItem value="Animal">Animal</MenuItem>
            <MenuItem value="Acuatico">Acuático</MenuItem>
            <MenuItem value="Terrestre">Terrestre</MenuItem>
            <MenuItem value="Ave">Ave</MenuItem>
          </Select>
        </FormControl>
        <Typography variant="h5" gutterBottom component="div" mt={2}>
          Código Fuente
        </Typography>
        <Paper style={{ padding: 16, backgroundColor: '#f7f7f7', whiteSpace: 'pre-wrap', overflowX: 'auto' }}>
          {code}
        </Paper>
        <Typography variant="h5" gutterBottom component="div" mt={4}>
          Código Tests
        </Typography>
        <Paper style={{ padding: 16, backgroundColor: '#f7f7f7', whiteSpace: 'pre-wrap', overflowX: 'auto' }}>
          {testCode}
        </Paper>
        <Button variant="contained" color="primary" onClick={runTests} style={{ marginTop: 20 }}>
          Ejecutar Tests
        </Button>
        {testResults && (
          <div>
            <Typography variant="h6" gutterBottom component="div" mt={4}>
              Resultados de los Tests
            </Typography>
            <Paper style={{ padding: 16, backgroundColor: '#e0e0e0', whiteSpace: 'pre-wrap', overflowX: 'auto' }}>
              {testResults}
            </Paper>
          </div>
        )}
      </Box>
    </Container>
  );
}

export default App;
