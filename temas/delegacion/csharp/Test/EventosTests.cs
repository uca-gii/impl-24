using Xunit;
using System;

public class EventosTest
{
    // Prueba para verificar que se notifica correctamente por correo electrónico
    [Fact]
    public void NotificarPorCorreo_Test()
    {
        // Arrange
        string mensaje = "Prueba de notificación por correo electrónico";
        string expectedOutput = "Notificación por correo electrónico: " + mensaje;
        
        // Act
        using (var consoleOutput = new ConsoleOutput())
        {
            GestorEventosCalendario.NotificarPorCorreo(mensaje);

            // Assert
            Assert.Equal(expectedOutput, consoleOutput.GetOutput());
        }
    }

    // Prueba para verificar que se notifica correctamente por mensaje de texto
    [Fact]
    public void NotificarPorSMS_Test()
    {
        // Arrange
        string mensaje = "Prueba de notificación por mensaje de texto";
        string expectedOutput = "Notificación por mensaje de texto: " + mensaje;
        
        // Act
        using (var consoleOutput = new ConsoleOutput())
        {
            GestorEventosCalendario.NotificarPorSMS(mensaje);

            // Assert
            Assert.Equal(expectedOutput, consoleOutput.GetOutput());
        }
    }

    // Prueba para verificar que se notifica correctamente a través de la aplicación
    [Fact]
    public void NotificarEnApp_Test()
    {
        // Arrange
        string mensaje = "Prueba de notificación en la aplicación";
        string expectedOutput = "Notificación en la aplicación: " + mensaje;
        
        // Act
        using (var consoleOutput = new ConsoleOutput())
        {
            GestorEventosCalendario.NotificarEnApp(mensaje);

            // Assert
            Assert.Equal(expectedOutput, consoleOutput.GetOutput());
        }
    }
}
