const fs = require('fs');
const express = require('express');
const path = require('path');
const cors = require('cors');
const { exec } = require('child_process');
const app = express();
const port = 3000;


app.use(express.static('public'));
app.use(cors());

// Get para enviar códigos de ruby
app.get('/api/code', (req, res) => {
    const { file } = req.query;
    const filePath = path.join(__dirname, 'ruby_src', `${file}.rb`);
    fs.readFile(filePath, 'utf8', (err, data) => {
        if (err) {
            res.status(404).send('Archivo no encontrado');
            return;
        }
        res.json({ source: data });
    });
});

// GET para enviar códigos de tests.
app.get('/api/test', (req, res) => {
    const { file } = req.query;
    const filePath = path.join(__dirname, 'ruby_test', `${file}.rb`);
    fs.readFile(filePath, 'utf8', (err, data) => {
        if (err) {
            res.status(404).send('Archivo no encontrado');
            return;
        }
        res.json({ results: data });
    });
});

// GET para ejecución de tests y envío de resultados.
app.get('/api/run-test', (req, res) => {
    const { file } = req.query;
    exec(`ruby ruby_test/${file} -v
    `, (error, stdout, stderr) => {
      if (error) {
        console.error(`exec error: ${error}`);
        return res.status(500).send({ error: `Execution error: ${error.message}` });
      }
      if (stderr) {
        console.error(`stderr: ${stderr}`);
        return res.status(500).send({ error: stderr });
      }
      res.send({ results: stdout });
    });
});

// Puerto auxiliar para ejecución de tests
const PORT = process.env.PORT || 3001;
app.listen(PORT, () => {
  console.log(`Test ejecutandose en el puerto ${PORT}`);
});

app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

app.listen(port, () => {
    console.log(`Servidor ejecutándose en http://localhost:${port}`);
});
