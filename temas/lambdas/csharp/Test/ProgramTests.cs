using System;
using Xunit;

namespace CalculadoraLambda.Tests
{
    public class CalculadoraTests
    {
        [Fact]
        public void Cuadrado_DebeCalcularCorrectamente()
        {
            // Arrange
            Calculadora calculadora = new Calculadora();

            // Act
            double resultado = calculadora.Cuadrado(5);

            // Assert
            Assert.Equal(25, resultado);
        }

        [Fact]
        public void TestForEquality_DebeDevolverTrue_CuandoNumerosSonIguales()
        {
            // Arrange
            Calculadora calculadora = new Calculadora();

            // Act
            bool resultado = calculadora.TestForEquality(5, 5);

            // Assert
            Assert.True(resultado);
        }

        [Fact]
        public void TestForEquality_DebeDevolverFalse_CuandoNumerosNoSonIguales()
        {
            // Arrange
            Calculadora calculadora = new Calculadora();

            // Act
            bool resultado = calculadora.TestForEquality(5, 10);

            // Assert
            Assert.False(resultado);
        }

        [Fact]
        public void Sumar_DebeSumarCorrectamente()
        {
            // Arrange
            Calculadora calculadora = new Calculadora();

            // Act
            int resultado = calculadora.Sumar(3, 7);

            // Assert
            Assert.Equal(10, resultado);
        }

        [Fact]
        public void Dividir_DebeDividirCorrectamente()
        {
            // Arrange
            Calculadora calculadora = new Calculadora();

            // Act
            double resultado = calculadora.Dividir(10, 2);

            // Assert
            Assert.Equal(5, resultado);
        }

        [Fact]
        public void Saludar_DebeSaludarCorrectamente_ConNombrePorDefecto()
        {
            // Arrange
            Calculadora calculadora = new Calculadora();

            // Act
            calculadora.Saludar();
        }

        [Fact]
        public void Multiplicar_DebeMultiplicarCorrectamente()
        {
            // Arrange
            Calculadora calculadora = new Calculadora();

            // Act
            int resultado = calculadora.Multiplicar(4, 6);

            // Assert
            Assert.Equal(24, resultado);
        }

        [Fact]
        public void MostrarMensaje_DebeMostrarCorrectamente()
        {
            // Arrange
            Calculadora calculadora = new Calculadora();

            // Act
            calculadora.MostrarMensaje(3);
        }

        [Fact]
        public void OperacionesConTuplas_DebeCalcularSumaYProductoCorrectamente()
        {
            // Arrange
            Calculadora calculadora = new Calculadora();
            var tupla = (5, 6);

            // Act
            var resultadoTupla = calculadora.OperacionesConTuplas(tupla);

            // Assert
            Assert.Equal(11, resultadoTupla.suma);
            Assert.Equal(30, resultadoTupla.producto);
        }

        [Fact]
        public async void CalcularAsincrono_DebeCalcularCorrectamenteAsincrono()
        {
            // Arrange
            Calculadora calculadora = new Calculadora();

            // Act
            await calculadora.CalcularAsincrono(10, 3);
        }
    }
}
