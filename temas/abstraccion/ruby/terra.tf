terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 3.0.1"
    }
  }
}

provider "docker" {}

# Definición del recurso para construir la imagen Docker
resource "docker_image" "app_image" {
  name         = "mi-app:latest"
  build {
    context    = path.module
    dockerfile = "Dockerfile"
  }
}

# Definición del recurso para correr un contenedor Docker
resource "docker_container" "app_container" {
  image = docker_image.app_image.name
  name  = "mi-app-container"
  ports {
    internal = 3000
    external = 3000
  }
}