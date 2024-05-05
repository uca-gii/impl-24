# Etapa de construcción del frontend
FROM node:20 as build

WORKDIR /app

COPY app/src/package.json ./

# Instala las dependencias del proyecto
RUN npm install --loglevel=error

COPY app/public public/
COPY app/src/App.js src/
COPY app/src/index.js src/

RUN npm run build

from node:20 as production

WORKDIR /app

COPY app/src/package.json ./

RUN npm install --only=production --loglevel=error

RUN apt-get update && \
    apt-get install -y default-jdk wget unzip && \
    wget https://github.com/JetBrains/kotlin/releases/download/v1.9.23/kotlin-compiler-1.9.23.zip && \
    unzip kotlin-compiler-1.9.23.zip -d /opt/kotlin && \
    rm kotlin-compiler-1.9.23.zip

# Establece el PATH para el compilador de Kotlin
ENV PATH="${PATH}:/opt/kotlin/kotlinc/bin"

# Copia el backend.js
COPY app/src/backend.js ./

COPY src/main/kotlin/ kotlin_src/

# Copia los archivos estáticos generados del frontend a la carpeta pública
COPY --from=build /app/build/ public/

# Expone el puerto que usa el servidor Express
EXPOSE 3100

# Comando para arrancar el servidor de Express
CMD ["node", "backend.js"]