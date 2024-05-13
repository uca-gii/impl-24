using Xunit;

public class SmartphoneTests
{
    [Fact]
    public void Smartphone_CapturarImagen_SalidaCorrecta()
    {
        var smartphone = new Smartphone("Sony", 12, 1080, "iOS");
        Assert.Equal("¡Capturando foto con el smartphone!", smartphone.CapturarImagen());
    }

    [Fact]
    public void Smartphone_GrabarVideo_SalidaCorrecta()
    {
        var smartphone = new Smartphone("Sony", 12, 1080, "iOS");
        Assert.Equal("¡Grabando video!", smartphone.GrabarVideo());
    }
}
