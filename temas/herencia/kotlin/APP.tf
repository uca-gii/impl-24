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
    context    = "path_to_node_backend_directory"
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
