// Definición de la clase principal que realiza la delegación
class Empleado(val nombre: String) {
  def trabajar(): Unit = {
    println(s"$nombre está trabajando duro.")
  }
}

// Definición de la clase que delega el trabajo a un empleado
class Gerente(nombre: String, val empleado: Empleado) {
  def coordinarTrabajo(): Unit = {
    println(s"El gerente $nombre está coordinando el trabajo del empleado.")
    empleado.trabajar() // Delega el trabajo al empleado
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    // Crear un objeto Empleado y un objeto Gerente que delega el trabajo al empleado
    val empleado1 = new Empleado("Juan")
    val gerente1 = new Gerente("María", empleado1)

    // El gerente coordina el trabajo delegado al empleado
    gerente1.coordinarTrabajo()
  }
}