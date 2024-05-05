terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 3.0.1"
    }
  }
}

provider "docker" {}

resource "docker_image" "node_backend" {
  name         = "kotlin-app:latest"
  build {
    context    = path.module
    dockerfile = "Dockerfile"
  }
}

resource "docker_container" "node_backend_container" {
  image = docker_image.node_backend.name
  name  = "node_backend"
  ports {
    internal = 3100
    external = 3100
  }
}
