terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 3.0.1"
    }
  }
}

provider "docker" {}

resource "docker_image" "kotlin-delegacion" {
  name         = "kotlin-delegacion:latest"
  build {
    context    = path.module
    dockerfile = "Dockerfile"
  }
}

resource "docker_container" "kotlin-delegacion-container" {
  image = docker_image.kotlin-delegacion.name
  name  = "kotlin-del"
  ports {
    internal = 3300
    external = 3300
  }
}
