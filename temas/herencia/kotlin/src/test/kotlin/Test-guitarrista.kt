import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import java.io.ByteArrayOutputStream
import org.junit.jupiter.api.Assertions.*
import java.io.PrintStream
import kotlin.test.assertEquals


class GuitarristaTest {
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
        val guitarrista = Guitarrista("Paco")
        guitarrista.tocaInstrumento()
        
        assertEquals("Paco toca la guitarra fenomenal.\n", outputStreamCaptor.toString())
    }

    @Test
    fun testActua() {
        val guitarrista = Guitarrista("Paco")
        guitarrista.actua()
        
        assertEquals("Paco hace su actuación,\nPaco toca la guitarra fenomenal.\n", outputStreamCaptor.toString())
    }

    @Test
    fun testPreparacion() {
        val guitarrista = Guitarrista("Paco")
        guitarrista.preparacion()
        
        assertEquals("Paco comprueba la afinación de su guitarra.\n", outputStreamCaptor.toString())
    }
}