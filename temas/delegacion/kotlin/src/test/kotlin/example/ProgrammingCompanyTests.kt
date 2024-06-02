package example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ProgrammingCompanyTests {
    private fun captureOutput(work: () -> Unit): String {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        work()
        return outputStream.toString()
    }

    @Test
    fun `Programador trabaja correctamente`() {
        val programador = Programador("Juan")
        val output = captureOutput { programador.trabajar() }
        assertTrue(output.contains("Juan está escribiendo código."))
    }

    @Test
    fun `Escritor trabaja correctamente`() {
        val escritor = Escritor("Ana")
        val output = captureOutput { escritor.trabajar() }
        assertTrue(output.contains("Ana está escribiendo un informe."))
    }

    @Test
    fun `Gerente trabaja correctamente`() {
        val gerente = Gerente("Carlos")
        val output = captureOutput { gerente.trabajar() }
        assertTrue(output.contains("Carlos está escribiendo un informe.") && output.contains("Carlos está atendiendo a un cliente."))
    }

    @Test
    fun `EscritorPreparado se prepara correctamente`() {
        val escritorPreparado = EscritorPreparado("Sofia")
        val output = captureOutput { escritorPreparado.preparar() }
        assertTrue(output.contains("Sofia ya se preparó antes."))
    }

    @Test
    fun `DesarrolladorCompleto trabaja correctamente`() {
        val completo = DesarrolladorCompleto("Luis")
        val output = captureOutput {
            completo.trabajar()
        }
        assertTrue(
            output.contains("Luis está escribiendo código.") &&
            output.contains("Luis está escribiendo un informe.") &&
            output.contains("Luis está atendiendo a un cliente.")
        )
    }

    @Test
    fun `Jefe prepara y maneja trabajadores correctamente`() {
        val trabajadores = listOf(Programador("Juan"), Escritor("Ana"), AtencionAlCliente("Carlos"))
        val jefe = Jefe()
        val output = captureOutput {
            jefe.prepararTrabajadores(trabajadores)
            jefe.manejarTrabajadores(trabajadores)
        }
        assertTrue(output.contains("El jefe está preparando a los trabajadores.") && output.contains("¡Todos los trabajadores han completado sus tareas!"))
    }
}
