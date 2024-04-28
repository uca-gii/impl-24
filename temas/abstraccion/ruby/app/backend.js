const fs = require('fs');
const express = require('express');
const path = require('path');
const cors = require('cors');
const { exec } = require('child_process');
const app = express();
const port = 3000;


app.use(express.static('public'));
app.use(cors());

app.get('/api/code', (req, res) => {
    const { file } = req.query;  // Ejemplo: file=Animal
    const filePath = path.join(__dirname, 'ruby_src', `${file}.rb`);
    fs.readFile(filePath, 'utf8', (err, data) => {
        if (err) {
            res.status(404).send('Archivo no encontrado');
            return;
        }
        res.json({ source: data });
    });
});

app.get('/api/test', (req, res) => {
    const { file } = req.query;  // Ejemplo: file=Animal_test
    const filePath = path.join(__dirname, 'ruby_test', `${file}.rb`);
    fs.readFile(filePath, 'utf8', (err, data) => {
        if (err) {
            res.status(404).send('Archivo no encontrado');
            return;
        }
        res.json({ results: data });
    });
});

app.get('/api/run-test', (req, res) => {
    const { file } = req.query;  // El nombre del archivo de test, por ejemplo: 'animal_test.rb'
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

const PORT = process.env.PORT || 3001;
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});

app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

app.listen(port, () => {
    console.log(`Servidor ejecutándose en http://localhost:${port}`);
});
