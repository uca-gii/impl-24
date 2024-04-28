# Etapa de construcción del frontend
FROM node:16 as build

# Establece el directorio de trabajo para el frontend
WORKDIR /app

# Copia el package.json y package-lock.json (o yarn.lock) para instalar dependencias
COPY app/package*.json ./

# Instala las dependencias del proyecto
RUN npm install
RUN npm install axios
RUN npm install cors
RUN npm install @mui/material @emotion/react @emotion/styled

# Copia específicamente los archivos necesarios para construir el frontend
COPY app/public public/
COPY app/src/ src/

# Construye el frontend. Esto generará una carpeta 'build' con todos los archivos estáticos
RUN npm run build

# Etapa de producción para el backend
FROM ruby:3.0 as production

# Instala Node.js
RUN curl -fsSL https://deb.nodesource.com/setup_16.x | bash - && \
    apt-get install -y nodejs

# Establece el directorio de trabajo
WORKDIR /app

# Copia el package.json y package-lock.json para instalar las dependencias de Node.js de producción
COPY app/package*.json ./
RUN npm install --only=production

# Instala Minitest y otras gemas necesarias
RUN gem install minitest

# Copia el backend.js
COPY app/backend.js ./

# Copia los archivos de Ruby y los tests de Ruby
COPY ruby_src/ ruby_src/
COPY ruby_test/ ruby_test/

# Copia los archivos estáticos generados del frontend a la carpeta pública
COPY --from=build /app/build/ public/

# Expone el puerto que usa el servidor Express
EXPOSE 3000

# Comando para arrancar el servidor de Express
CMD ["node", "backend.js"]