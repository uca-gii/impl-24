import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import java.io.ByteArrayOutputStream
import org.junit.jupiter.api.Assertions.*
import java.io.PrintStream
import kotlin.test.assertEquals

class CantanteTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun testCanta() {
        val cantante = Cantante("Camarón")
        cantante.canta()
        
        assertEquals("Camarón tiene una voz de oro!\n", outputStreamCaptor.toString())
    }

    @Test
    fun testActua() {
        val cantante = Cantante("Camarón")
        cantante.actua()
        
        assertEquals("Camarón hace su actuación,\nCamarón tiene una voz de oro!\n", outputStreamCaptor.toString())
    }

    @Test
    fun testPreparacion() {
        val cantante = Cantante("Camarón")
        cantante.preparacion()
        
        assertEquals("Camarón calienta sus cuerdas vocales.\n", outputStreamCaptor.toString())
    }
}
