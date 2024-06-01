package ejemplo

class Trabajador(val nombre: String) {
    fun trabajar() {
        println("$nombre está realizando tareas generales.")
    }
}

class Programador(nombre: String) {
    private val trabajador = Trabajador(nombre)

    fun trabajar() {
        trabajador.preparar()
        println("${trabajador.nombre} está escribiendo código.")
    }
}

class Escritor(nombre: String) {
    private val trabajador = Trabajador(nombre)

    fun trabajar() {
        trabajador.preparar()
        println("${trabajador.nombre} está escribiendo un informe.")
    }
}

class AtencionAlCliente(nombre: String) {
    private val trabajador = Trabajador(nombre)

    fun trabajar() {
        trabajador.preparar()
        println("${trabajador.nombre} está atendiendo a un cliente.")
    }
}

class Gerente(nombre: String) {
    private val escritor = Escritor(nombre)
    private val atencion = AtencionAlCliente(nombre)

    fun trabajar() {
        escritor.trabajar()
        atencion.trabajar()
    }
}

class DesarrolladorCompleto(nombre: String) {
    private val programador = Programador(nombre)
    private val escritor = Escritor(nombre)
    private val atencion = AtencionAlCliente(nombre)

    fun trabajar() {
        programador.trabajar()
        escritor.trabajar()
        atencion.trabajar()
    }
}

class Jefe {
    fun manejarTrabajadores(trabajadores: List<Any>) {
        println("El jefe da la señal para que los trabajadores hagan sus tareas.")
        println("---------------------------------------------------------------------")
        trabajadores.forEach{
            when (it) {
                is Programador -> it.trabajar()
                is Escritor -> it.trabajar()
                is AtencionAlCliente -> it.trabajar()
                is Gerente -> it.trabajar()
                is DesarrolladorCompleto -> it.trabajar()
                is Trabajador -> it.trabajar()
                else -> println("Tipo de trabajador desconocido.")
            }
        }
        println("---------------------------------------------------------------------")
        println("¡Todos los trabajadores han completado sus tareas!")
    }
}
