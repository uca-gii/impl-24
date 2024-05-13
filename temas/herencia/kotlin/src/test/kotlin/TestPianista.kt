import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import java.io.ByteArrayOutputStream
import org.junit.jupiter.api.Assertions.*
import java.io.PrintStream
import kotlin.test.assertEquals

class TestPianista {
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
        val pianista = Pianista("Diego")
        pianista.tocaInstrumento()
        
        assertEquals("Diego desliza sus dedos sobre las teclas con gran destreza.\n", outputStreamCaptor.toString())
    }

    @Test
    fun testActua() {
        val pianista = Pianista("Diego")
        pianista.actua()
        
        assertEquals("Diego hace su actuación,\nDiego desliza sus dedos sobre las teclas con gran destreza.\n", outputStreamCaptor.toString())
    }

    @Test
    fun testPreparacion() {
        val pianista = Pianista("Diego")
        pianista.preparacion()
        
        assertEquals("Diego calienta tocando un solo de piano.\n", outputStreamCaptor.toString())
    }
}