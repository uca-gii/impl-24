using System;
using Xunit;

public class SensorTests
{
    [Fact]
    public void Sensor_Id_estaAsignado()
    {
        var sensor = new Sensor();
        Assert.NotEqual(0, sensor.Id);
    }

    [Fact]
    public void Sensor_DatosRegistro_fechaAsignada()
    {
        var registro = new Sensor.datosRegistro();
        Assert.Equal(DateTime.Today, registro.Fecha.Date);
    }
}
