const express = require('express');
const app = express();
const port = process.env.PORT || 3000; // Usa el puerto desde variables de entorno o el 3000

// Middleware para parsear el cuerpo de las solicitudes en formato JSON
app.use(express.json());

// Ruta principal
app.get('/', (req, res) => {
  res.send('Hola');
});
// Ruta json
app.get('/json', (req, res) => {
  res.status(200).json({ message: 'Hola en formato JSON' });
});

// Manejo de errores para rutas no encontradas (404)
app.use((req, res, next) => {
  res.status(404).send({ message: 'Ruta no encontrada' });
});

// Middleware global para manejar errores
app.use((err, req, res, next) => {
  console.error(err.stack);
  res.status(500).send({ message: 'Ocurrio algun error!' });
});

// Iniciar el servidor
app.listen(port, () => {
  console.log(`Servidor se ejecuta en el puerto ${port}`);
});
