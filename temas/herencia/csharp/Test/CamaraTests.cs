using System;
using Xunit;
using Herencia;
using System.IO;

namespace Herencia.Tests
{
    // Clase derivada concreta de Camara para propósitos de prueba
    public class CamaraConcreta : Camara
    {
        public override void capturarImagen()
        {
            base.capturarImagen();
            Console.WriteLine("¡Capturando foto con la cámara concreta!");
        }
    }

    public class CamaraTests
    {
        [Fact]
        public void CamaraConcreta_Constructor_InitializesProperties()
        {
            // Arrange
            var camara = new CamaraConcreta();

            // Act & Assert
            Assert.Equal(0, camara.Megapixeles);
            Assert.Equal(0, camara.Resolucion);
            Assert.Null(camara.fabricanteCamara);
        }

        [Fact]
        public void Camara_GrabarVideo_WritesCorrectMessage()
        {
            // Arrange
            var camara = new CamaraConcreta();
            var originalOut = Console.Out;

            using (var sw = new StringWriter())
            {
                Console.SetOut(sw);

                // Act
                camara.GrabarVideo();

                // Assert
                var expected = "¡Grabando video!" + Environment.NewLine;
                var result = sw.ToString();
                Assert.Equal(expected, result);
            }

            Console.SetOut(originalOut);  // Restore original console output
        }
    }
}
