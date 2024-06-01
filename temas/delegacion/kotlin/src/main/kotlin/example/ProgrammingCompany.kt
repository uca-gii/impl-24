package example

interface Trabajador {
    val nombre: String

    fun preparar() {
        println("$nombre está preparándose para trabajar.")
    }

    fun trabajar() {}
}

class Programador(override val nombre: String): Trabajador {
    override fun trabajar() {
        println("${nombre} está escribiendo código.")
    }
}

class Escritor(override val nombre: String): Trabajador {
    override fun trabajar() {
        println("${nombre} está escribiendo un informe.")
    }
}

class AtencionAlCliente(override val nombre: String): Trabajador {
    override fun trabajar() {
        println("${nombre} está atendiendo a un cliente.")
    }
}

class Gerente(override val nombre: String): Trabajador {
    private val escritor = Escritor(nombre)
    private val atencion = AtencionAlCliente(nombre)

    override fun trabajar() {
        escritor.trabajar()
        atencion.trabajar()
    }
}

class DesarrolladorCompleto(override val nombre: String): Trabajador {
    private val programador = Programador(nombre)
    private val escritor = Escritor(nombre)
    private val atencion = AtencionAlCliente(nombre)

    override fun trabajar() {
        programador.trabajar()
        escritor.trabajar()
        atencion.trabajar()
    }
}

class Jefe {
    fun prepararTrabajadores(trabajadores: List<Trabajador>) {
        println("El jefe está preparando a los trabajadores.")
        println("--------------------------------------------")
        trabajadores.forEach {
            it.preparar()
        }
        println("--------------------------------------------")
        println("Todos los trabajadores están preparados.")
        println("============================================")
    }

    fun manejarTrabajadores(trabajadores: List<Trabajador>) {
        println("El jefe da la señal para que los trabajadores hagan sus tareas.")
        println("---------------------------------------------------------------------")
        trabajadores.forEach{
            it.trabajar()
        }
        println("---------------------------------------------------------------------")
        println("¡Todos los trabajadores han completado sus tareas!")
    }
}