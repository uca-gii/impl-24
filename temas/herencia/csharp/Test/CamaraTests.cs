using Xunit;

public class CamaraTests
{
    [Fact]
    public void Camara_CapturarImagen_SalidaCorrecta()
    {
        var camara = new MockCamara();
        Assert.Equal("¡Capturando foto!", camara.CapturarImagen());
    }

    [Fact]
    public void Camara_GrabarVideo_SalidaCorrecta()
    {
        var camara = new Camara();
        Assert.Equal("¡Grabando video!", camara.GrabarVideo());
    }

}
