# Utilise une image Node.js comme base
FROM node:latest

# Installe TypeScript globalement
RUN npm install -g typescript

# Crée un répertoire de travail dans le conteneur
WORKDIR /app

# Copie le fichier package.json dans le répertoire de travail
COPY package.json .

# Installe les dépendances
RUN npm install

# Copie tous les fichiers du répertoire actuel dans le répertoire de travail du conteneur
COPY . .

# Compile le fichier TypeScript
RUN tsc main.ts

# Commande à exécuter lorsque le conteneur démarre
CMD ["node", "main.js"]