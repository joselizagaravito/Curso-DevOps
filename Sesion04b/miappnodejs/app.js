const express = require('express');
const os = require('os');
const app = express();
const port = 80;

let visits = 0;

app.get('/', (req, res) => {
  const name = process.env.NAME || 'Invitado'; 
  const language = process.env.LANGUAGE || 'Desconocido'; 
  const hostname = os.hostname();
  visits += 1;

  const html = `
    <h3>Hello ${name}!</h3>
    <h4>Aplicación ${language}!</h4>
    <b>Hostname:</b> ${hostname}<br/>
    <b>Visits:</b> ${visits}
  `;
  
  res.send(html);
});

app.listen(port, () => {
  console.log(`Aplicación escuchando en http://localhost:${port}`);
});
