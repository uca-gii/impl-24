# Utilise l'image de base officielle OpenJDK 17
FROM openjdk:17-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier le contenu du dossier src dans le conteneur
COPY src /app/src

# Compiler tous les fichiers Java
RUN javac /app/src/example/dependencyinjection/*.java -d /app/out

# Définir l'ENTRYPOINT pour exécuter la classe Main
ENTRYPOINT ["java", "-cp", "/app/out", "example.dependencyinjection.Main"]
