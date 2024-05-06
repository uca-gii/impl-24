// Definición de los traits
trait Volador {
  def fecha(): Unit 
  def volar(): Unit = println("¡Estoy volando!")
 // def saludo(): Unit = println("Hola, soy un animal volador!")
}

trait Nadador {
  def nadar(): Unit = println("¡Estoy nadando!")
  //def saludo(): Unit = println("Hola, soy un animal nadador!")
}

trait Caminante {
  def caminar(): Unit = println("¡Estoy caminando!")
  //def saludo(): Unit = println("Hola, soy un animal que puede andar!")
}

// Clase que hereda de los tres traits
class Animal extends Volador with Nadador with Caminante {
    def fecha(): Unit = println("¡Hoy es jueves!")
    //def caminar(): Unit = println("No puedo caminando!")
}

class Oviparo {
    def reproduccion(): Unit = println("¡Pongo huevos!")
}

// Objeto singleton Main
object Main {
  def main(args: Array[String]): Unit = {
    val animal = new Animal
    // val persona = new Caminante()
    // val golondrina = new Oviparo with Volador

    animal.volar()    // El animal puede volar
    animal.nadar()    // El animal puede nadar
    animal.caminar()  // El animal puede caminar
    animal.fecha()

    // golondrina.volar()
    // golondrina.reproduccion()

    // animal.saludo() // Aquí debería ocurrir una ambigüedad ya que Animal hereda varios métodos 'saludo'
  }
}
