# Definir el proveedor local
provider "local" {}

# Configurar la provisión del archivo HTML
resource "local_file" "index" {
  filename = "${path.module}/index.html"
}

# Configurar la provisión del archivo Ruby
resource "local_file" "calculator" {
  filename = "${path.module}/calculator.rb"
}

# Ejecutar un script Ruby
resource "null_resource" "ruby_script" {
  provisioner "local-exec" {
    command = "ruby ${path.module}/calculator.rb"
  }
}
