using Xunit;

public class CalculaEXPTests
{
    [Fact]
    public void CalcularEXP_WithAnotacionExpAttribute_ShouldIncreaseExperience()
    {
        // Arrange
        var mago = new MagoOscuro("Mago Tenebroso");
        var accion = new Action(mago.HechizoMaldicion);

        // Act
        CalculaEXP.CalcularEXP(accion, mago);

        // Assert
        Assert.Equal(30, mago.getExperiencia()); // Verifica que la experiencia del mago se haya incrementado correctamente
    }

    [Fact]
    public void CalcularEXP_WithoutAnotacionExpAttribute_ShouldNotIncreaseExperience()
    {
        // Arrange
        var mago = new MagoOscuro("Mago Tenebroso");
        var accion = new Action(mago.HechizoVeneno);

        // Act
        CalculaEXP.CalcularEXP(accion, mago);

        // Assert
        Assert.Equal(0, mago.getExperiencia()); // Verifica que la experiencia del mago no haya cambiado
    }

    [Fact]
    public void CalcularEXP_WithNullMago_ShouldNotIncreaseExperience()
    {
        // Arrange
        Mago? mago = null;
        var accion = new Action(() => { });

        // Act
        CalculaEXP.CalcularEXP(accion, mago);

        // Assert
        // No hay necesidad de verificar la experiencia del mago ya que se supone que es nulo, solo queremos asegurarnos de que no se produzca una excepción
    }
}