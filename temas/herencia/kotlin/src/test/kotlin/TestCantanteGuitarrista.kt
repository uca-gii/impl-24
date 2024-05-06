import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import java.io.ByteArrayOutputStream
import org.junit.jupiter.api.Assertions.*
import java.io.PrintStream
import kotlin.test.assertEquals

class TestCantanteGuitarrista {
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
    fun testTocaInstrumento() {
        val cantanteGuitarrista = CantanteGuitarrista("David")
        cantanteGuitarrista.tocaInstrumento()
        
        assertEquals("David toca la guitarra fenomenal.\n", outputStreamCaptor.toString())
    }

    @Test
    fun testCanta() {
        val cantanteGuitarrista = CantanteGuitarrista("David")
        cantanteGuitarrista.canta()
        
        assertEquals("David tiene una voz de oro!\n", outputStreamCaptor.toString())
    }

    @Test
    fun testActua() {
        val cantanteGuitarrista = CantanteGuitarrista("David")
        cantanteGuitarrista.actua()
        
        assertEquals("David hace su actuación,\nDavid toca la guitarra fenomenal.\nDavid tiene una voz de oro!\n", outputStreamCaptor.toString())
    }

    @Test
    fun testPreparacion() {
        val cantanteGuitarrista = CantanteGuitarrista("David")
        cantanteGuitarrista.preparacion()
        
        assertEquals("David realiza una doble preparacion de voz y guitarra.\nDavid calienta sus cuerdas vocales.\nDavid comprueba la afinación de su guitarra.\n", outputStreamCaptor.toString())
    }
}