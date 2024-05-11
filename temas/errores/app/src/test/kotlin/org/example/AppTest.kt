package org.example

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals
import kotlin.test.fail
import java.io.IOException

class AppTest {
    @Test 
    fun appHasAGreeting() {
        val classUnderTest = App()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }
    
    @Test
    fun testDivisionByZero() {
        try {
            divide(10, 0)
            fail("Expected ArithmeticException")
        } catch (e: ArithmeticException) {
            assertEquals("No se puede dividir por cero.", e.message, "Unexpected exception message")
        }
    }
    
    @Test
    fun testInvalidAgeException() {
        try {
            checkAge(16)
            fail("Expected InvalidAgeException")
        } catch (e: InvalidAgeException) {
            assertEquals("No tienes la edad suficiente.", e.message, "Unexpected exception message")
        }
    }
    
    @Test
    fun testIOException() {
        val fileName = "nonexistent_file.txt"
        try {
            readFile(fileName)
            fail("Expected IOException")
        } catch (e: IOException) {
            assertEquals("No se pudo leer el archivo '$fileName'.", e.message, "Unexpected exception message")
        }
    }
    
    @Test
    fun testIndexOutOfBoundsException() {
        try {
            mightThrowException()
            fail("Expected IndexOutOfBoundsException")
        } catch (e: IndexOutOfBoundsException) {
            // No se puede predecir el mensaje exacto de la excepción, 
            // ya que depende del entorno de ejecución y de cómo se imprime el stack trace
            assertNotNull(e.message, "Exception message should not be null")
        }
    }
    
    // No es posible probar el método writeFile directamente en los test unitarios 
    // sin introducir dependencias adicionales o complicaciones en el entorno de prueba.
}
