const fs = require('fs');
const express = require('express');
const path = require('path');
const cors = require('cors');
const { exec } = require('child_process');
const app = express();
const PORT = 3300;

app.use(express.json());
app.use(express.static('public'));
app.use(cors());

app.post('/api/execute', (req, res) => {
    const participants = req.body;
    let kotlinCode = "package example\n";
    kotlinCode += "fun main() {\n";
    kotlinCode += "val jefe = Jefe()\n";
    kotlinCode += "val trabajadores = mutableListOf<Trabajador>()\n";
  
    participants.forEach(p => {
        switch (p.role) {
            case "Programador":
                kotlinCode += `trabajadores.add(Programador("${p.name}"))\n`;
                break;
            case "Escritor":
                kotlinCode += `trabajadores.add(Escritor("${p.name}"))\n`;
                break;
            case "EscritorPreparado":
                kotlinCode += `trabajadores.add(EscritorPreparado("${p.name}"))\n`;
                break;
            case "AtencionAlCliente":
                kotlinCode += `trabajadores.add(AtencionAlCliente("${p.name}"))\n`;
                break;
            case "Gerente":
                kotlinCode += `trabajadores.add(Gerente("${p.name}"))\n`;
                break;
            case "DesarrolladorCompleto":
                kotlinCode += `trabajadores.add(DesarrolladorCompleto("${p.name}"))\n`;
                break;
            default:
                kotlinCode += `println("Role ${p.role} desconocido para ${p.name}")\n`;
        }
    });
  
    kotlinCode += "jefe.prepararTrabajadores(trabajadores)\n";
    kotlinCode += "jefe.manejarTrabajadores(trabajadores)\n";
    kotlinCode += "}\n";
  
    fs.writeFileSync('./kotlin_src/example/DynamicMain.kt', kotlinCode, 'utf8');
  
    exec('kotlinc ./kotlin_src/example/DynamicMain.kt ./kotlin_src/example/ProgrammingCompany.kt -include-runtime -d ./kotlin_src/example/DynamicMain.jar && java -Dfile.encoding=UTF-8 -jar ./kotlin_src/example/DynamicMain.jar', (error, stdout, stderr) => {
        if (error) {
            console.error(`exec error: ${error}`);
            return res.status(500).send(stderr);
        }
        res.setHeader('Content-Type', 'text/plain; charset=utf-8')
        res.send(stdout);
    });
});

app.get('*', (req, res) => {
    res.sendFile(path.resolve(__dirname, 'public', 'index.html'));
});

app.listen(PORT, () => console.log(`Server running on http://localhost:${PORT}`));
