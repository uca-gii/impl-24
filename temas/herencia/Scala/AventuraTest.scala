trait SabeLuchar{
	def luchar();
}
trait SabeNadar{
	def nadar();
}
trait SabeVolar{
	def volar();
}

class PersonajeDeAccion(){
    def luchar(): Unit = println("El Personaje de Accion lucha.")
}
class Heroe () extends PersonajeDeAccion with SabeLuchar with SabeNadar with SabeVolar{
    def nadar(): Unit = println("El heroe nada.")
    def volar(): Unit = println("El heroe vuela.")
}
object Aventura{ //Mirar si no es class
	def luchador(x: SabeLuchar): Unit = x.luchar()
	def nadador(x: SabeNadar): Unit = x.nadar()
	def volador(x: SabeVolar): Unit = x.volar()
	def personajeAccion(x:PersonajeDeAccion): Unit = x.luchar()

}

object AventuraTest{
	def main(args: Array[String]) ={
		val i = new Heroe() //variable de tipo heroe
		//val A = new Aventura();
		Aventura.luchador(i) //Tratar como un sabeLuchar
		Aventura.nadador(i) //Tratar como un sabeNadar
		Aventura.volador(i) //Tratar como un sabeVolar
		Aventura.personajeAccion(i) //Tratar como un PersonajeDeAccion
	}
}