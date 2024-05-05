open class miembroGrupo(val name: String) {
    open fun actua() {
        println("$name hace su actuación,")
    }

    open fun preparacion() {
        println("$name se prepara para la actuación.")
    }
}

interface musicoConInstrumento {
    fun tocaInstrumento()
}

class Cantante(name: String) : miembroGrupo(name) {
    override fun actua() {
        super.actua()
        canta()
    }

    override fun preparacion() {
        println("$name calienta sus cuerdas vocales.")
    }

    fun canta() {
        println("$name tiene una voz de oro!")
    }
}

class Guitarrista(name: String) : miembroGrupo(name), musicoConInstrumento {
    override fun actua() {
        super.actua()
        tocaInstrumento()
    }

    override fun preparacion() {
        println("$name comprueba la afinación de su guitarra.")
    }

    override fun tocaInstrumento() {
        println("$name toca la guitarra fenomenal.")
    }
}

class Pianista(name: String) : miembroGrupo(name), musicoConInstrumento {
    override fun actua() {
        super.actua()
        tocaInstrumento()
    }

    override fun preparacion() {
        println("$name calienta tocando un solo de piano.")
    }

    override fun tocaInstrumento() {
        println("$name desliza sus dedos sobre las teclas con gran destreza.")
    }
}

class CantanteGuitarrista(name: String) : miembroGrupo(name), musicoConInstrumento {
    private val cantante = Cantante(name)
    private val guitarrista = Guitarrista(name)

    override fun actua() {
        super.actua()
        cantante.canta()
        guitarrista.tocaInstrumento()
    }

    override fun preparacion() {
        println("$name realiza una doble preparacion de voz y guitarra.")
        cantante.preparacion()
        guitarrista.preparacion()
    }

    override fun tocaInstrumento() {
        guitarrista.tocaInstrumento()
    }
}

class Manager {
    fun preparaGrupo(miembros: List<miembroGrupo>) {
        println("El manager dice a la banda que se prepare.")
        println("------------------------------------------")
        miembros.forEach { 
            it.preparacion()
        }
        println("------------------------------------------")
        println("La banda está lista para actuar.")
        println("==========================================")
    }

    fun actuaGrupo(miembros: List<miembroGrupo>) {
        println("El manager da la señal para que comience la actuación.")
        println("------------------------------------------")
        miembros.forEach {
            it.actua()
        }
        println("------------------------------------------")
        println("¡La actuación ha sido un exitazo!")
    }
}

fun main() {
    val camaron = Cantante("Camarón")
    val paco = Guitarrista("Paco")
    val diego = Pianista("Diego")
    val david = CantanteGuitarrista("David")


    val miembroGrupos: List<miembroGrupo> = listOf(camaron, paco, diego, david)
    val manager = Manager()

    manager.preparaGrupo(miembroGrupos)
    manager.actuaGrupo(miembroGrupos)
}