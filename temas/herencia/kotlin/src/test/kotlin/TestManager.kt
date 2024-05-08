import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertTrue

class TestManager {
    private val manager = Manager()
    private val originalOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    fun testPreparaGrupo() {
        val miembros = listOf(
            Cantante("John"),
            Guitarrista("Paul"),
            Pianista("George")
        )
        manager.preparaGrupo(miembros)

        val expectedOutput = "El manager dice a la banda que se prepare.\n" +
                             "------------------------------------------\n" +
                             "John calienta sus cuerdas vocales.\n" +
                             "Paul comprueba la afinación de su guitarra.\n" +
                             "George calienta tocando un solo de piano.\n" +
                             "------------------------------------------\n" +
                             "La banda está lista para actuar.\n" +
                             "==========================================\n"

        assertTrue(outputStreamCaptor.toString().contains(expectedOutput))
    }

    @Test
    fun testActuaGrupo() {
        val miembros = listOf(
            Cantante("John"),
            Guitarrista("Paul"),
            Pianista("George")
        )
        manager.actuaGrupo(miembros)

        val expectedOutput = "El manager da la señal para que comience la actuación.\n" +
                             "------------------------------------------\n" +
                             "John hace su actuación,\n" +
                             "John tiene una voz de oro!\n" +
                             "Paul hace su actuación,\n" +
                             "Paul toca la guitarra fenomenal.\n" +
                             "George hace su actuación,\n" +
                             "George desliza sus dedos sobre las teclas con gran destreza.\n" +
                             "------------------------------------------\n" +
                             "¡La actuación ha sido un exitazo!\n"

        assertTrue(outputStreamCaptor.toString().contains(expectedOutput))
    }
}
