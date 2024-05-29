using System;
using Xunit;
using Herencia;

namespace Herencia.Tests
{
    public class SensorTests
    {
        [Fact]
        public void Sensor_Constructor_AssignsId()
        {
            // Arrange
            var sensor = new Sensor();

            // Act
            var id = sensor.GetType().GetProperty("Id", System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance).GetValue(sensor);

            // Assert
            Assert.InRange((int)id, 1, 1000);
        }

        [Fact]
        public void Sensor_Constructor_InitializesMegapixelesAndResolucion()
        {
            // Arrange
            var sensor = new Sensor();

            // Act & Assert
            Assert.Equal(0, sensor.Megapixeles);
            Assert.Equal(0, sensor.Resolucion);
        }

        [Fact]
        public void datosRegistro_Constructor_SetsFechaToNow()
        {
            // Arrange
            var registro = new Sensor.datosRegistro();

            // Act
            var now = DateTime.Now;
            var registroFecha = registro.Fecha;

            // Assert
            Assert.Equal(now.Date, registroFecha.Date);
        }
    }
}
