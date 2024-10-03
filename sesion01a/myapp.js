require('dotenv').config(); // Para cargar variables de entorno desde un archivo .env
const http = require('http');

// Usa variables de entorno para el hostname y el puerto
const hostname = process.env.HOSTNAME || '127.0.0.1';
const port = process.env.PORT || 3000;

const server = http.createServer((req, res) => {
  // Manejo de rutas básicas
  if (req.url === '/' && req.method === 'GET') {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');
    res.end('Hello World\n');
  } else if (req.url === '/json' && req.method === 'GET') {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify({ message: 'Hello World in JSON' }));
  } else {
    // Manejo de rutas no encontradas
    res.statusCode = 404;
    res.setHeader('Content-Type', 'text/plain');
    res.end('404 Not Found\n');
  }
});

// Manejo de errores del servidor
server.listen(port, hostname, (err) => {
  if (err) {
    console.error('Error al iniciar el servidor:', err);
  } else {
    console.log(`Server running at http://${hostname}:${port}/`);
  }
});
