using System;
using Xunit;
using Herencia;

namespace Herencia.Tests
{
    public class SmartphoneTests
    {
        [Fact]
        public void Smartphone_Constructor_InitializesProperties()
        {
            // Arrange
            var fabricante = "TestFabricante";
            var megapixeles = 12;
            var resolucion = 1080;
            var sistemaOperativo = "Android";

            // Act
            var smartphone = new Smartphone(fabricante, megapixeles, resolucion, sistemaOperativo);

            // Assert
            Assert.Equal(fabricante, smartphone.fabricanteCamara);
            Assert.Equal(megapixeles, smartphone.Megapixeles);
            Assert.Equal(resolucion, smartphone.Resolucion);
            Assert.Equal(sistemaOperativo, smartphone.SistemaOperativo);
        }

        [Fact]
        public void capturarImagen_Method_WritesCorrectMessage()
        {
            // Arrange
            var fabricante = "TestFabricante";
            var megapixeles = 12;
            var resolucion = 1080;
            var sistemaOperativo = "Android";
            var smartphone = new Smartphone(fabricante, megapixeles, resolucion, sistemaOperativo);

            using (var sw = new System.IO.StringWriter())
            {
                Console.SetOut(sw);

                // Act
                smartphone.capturarImagen();

                // Assert
                var expected = "¡Capturando foto con el smartphone!" + Environment.NewLine;
                Assert.Equal(expected, sw.ToString());
            }
        }
    }
}
