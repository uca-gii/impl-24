
terraform {
  required_providers {
    docker = {
      source = "kreuzwerker/docker"
      version = "~> 3.0.1"
    }
  }
}

provider "docker" {
  host = "npipe:////./pipe/docker_engine"
}

resource "docker_image" "ubuntu" {
  name = "ubuntu:latest"
  keep_locally = false
}

resource "docker_container" "ubuntu" {
  image = docker_image.ubuntu.image_name
  name = "ubuntu_latest"
  ports {
    internal = 80
    external = 4568
  }
  provisioner "local_exec" {
    command = sudo apt update
    command = sudo apt install ruby -y
    command = gem install sinatra
    command = gem install aquarium
    command = sudo apt intall wget -y
    command = wget -P . https://github.com/martaajonees/impl-24/blob/feat-aspectos/temas/aspectos/ruby/appAspectos.rb
    command = ruby appAspectos.rb
  }
}
  

