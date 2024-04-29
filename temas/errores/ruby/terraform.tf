# terraform

provider "null" {}

resource "null_resource" "start_server" {
  provisioner "local-exec" {
    command     = "python3 -m http.server 8083 &"
    working_dir = "${path.module}"
  }
}
