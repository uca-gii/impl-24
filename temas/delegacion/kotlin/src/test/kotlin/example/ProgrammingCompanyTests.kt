package example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class TrabajadorTests {

    private fun captureOutput(work: () -> Unit): String {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        work()
        return outputStream.toString()
    }

    @Test
    fun `test Programador preparar y trabajar`() {
        val programador = Programador("Juan")
        val outputPreparar = captureOutput { programador.preparar() }
        val outputTrabajar = captureOutput { programador.trabajar() }
        assertTrue(outputPreparar.contains("Juan está preparándose para trabajar."))
        assertTrue(outputTrabajar.contains("Juan está escribiendo código."))
    }

    @Test
    fun `test Escritor preparar y trabajar`() {
        val escritor = Escritor("Ana")
        val outputPreparar = captureOutput { escritor.preparar() }
        val outputTrabajar = captureOutput { escritor.trabajar() }
        assertTrue(outputPreparar.contains("Ana está preparándose para trabajar."))
        assertTrue(outputTrabajar.contains("Ana está escribiendo un informe."))
    }

    @Test
    fun `test AtencionAlCliente preparar y trabajar`() {
        val atencion = AtencionAlCliente("Carlos")
        val outputPreparar = captureOutput { atencion.preparar() }
        val outputTrabajar = captureOutput { atencion.trabajar() }
        assertTrue(outputPreparar.contains("Carlos está preparándose para trabajar."))
        assertTrue(outputTrabajar.contains("Carlos está atendiendo a un cliente."))
    }

    @Test
    fun `test Gerente preparar y trabajar`() {
        val gerente = Gerente("Sofia")
        val outputPreparar = captureOutput { gerente.preparar() }
        val outputTrabajar = captureOutput { gerente.trabajar() }
        assertTrue(outputPreparar.contains("Sofia está preparándose para trabajar."))
        assertTrue(outputTrabajar.contains("Sofia está escribiendo un informe."))
        assertTrue(outputTrabajar.contains("Sofia está atendiendo a un cliente."))
    }

    @Test
    fun `test DesarrolladorCompleto preparar y trabajar`() {
        val dev = DesarrolladorCompleto("Luis")
        val outputPreparar = captureOutput { dev.preparar() }
        val outputTrabajar = captureOutput { dev.trabajar() }
        assertTrue(outputPreparar.contains("Luis está preparándose para trabajar."))
        assertTrue(outputTrabajar.contains("Luis está escribiendo código."))
        assertTrue(outputTrabajar.contains("Luis está escribiendo un informe."))
        assertTrue(outputTrabajar.contains("Luis está atendiendo a un cliente."))
    }

    @Test
    fun `test Jefe prepararTrabajadores`() {
        val jefe = Jefe()
        val trabajadores = listOf(
            Programador("Juan"),
            Escritor("Ana"),
            AtencionAlCliente("Carlos"),
            Gerente("Sofia"),
            DesarrolladorCompleto("Luis")
        )
        val output = captureOutput { jefe.prepararTrabajadores(trabajadores) }
        assertTrue(output.contains("Juan está preparándose para trabajar."))
        assertTrue(output.contains("Ana está preparándose para trabajar."))
        assertTrue(output.contains("Carlos está preparándose para trabajar."))
        assertTrue(output.contains("Sofia está preparándose para trabajar."))
        assertTrue(output.contains("Luis está preparándose para trabajar."))
    }

    @Test
    fun `test Jefe manejarTrabajadores`() {
        val jefe = Jefe()
        val trabajadores = listOf(
            Programador("Juan"),
            Escritor("Ana"),
            AtencionAlCliente("Carlos"),
            Gerente("Sofia"),
            DesarrolladorCompleto("Luis")
        )
        val output = captureOutput { jefe.manejarTrabajadores(trabajadores) }
        assertTrue(output.contains("Juan está escribiendo código."))
        assertTrue(output.contains("Ana está escribiendo un informe."))
        assertTrue(output.contains("Carlos está atendiendo a un cliente."))
        assertTrue(output.contains("Sofia está escribiendo un informe."))
        assertTrue(output.contains("Sofia está atendiendo a un cliente."))
        assertTrue(output.contains("Luis está escribiendo código."))
        assertTrue(output.contains("Luis está escribiendo un informe."))
        assertTrue(output.contains("Luis está atendiendo a un cliente."))
    }
}
