terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 3.0.1"
    }
  }
}

provider "docker" {}

resource "docker_image" "aspectos_java" {
  name         = "aspectos-java:latest"
  build {
    context    = path.module
    dockerfile = "Dockerfile"
  }
}

resource "docker_container" "aspectos_java_container" {
  image = docker_image.aspectos_java.name
  name  = "aspectos_java_container"
  ports {
    internal = 3200
    external = 3200
  }
}
