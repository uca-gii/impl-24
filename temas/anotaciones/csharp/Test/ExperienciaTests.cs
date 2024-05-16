using Xunit;

public class CalculaEXPTests
{
    [Fact]
    public void CalcularEXP_ConAumento()
    {
        
        var mago = new MagoOscuro("Mago Tenebroso");
        var accion = new Action(mago.HechizoMaldicion);

        
        CalculaEXP.CalcularEXP(accion, mago);

        
        Assert.Equal(30, mago.getExperiencia()); // Verifica que la experiencia del mago se haya incrementado correctamente
    }

    [Fact]
    public void CalcularEXP_SinAumento()
    {
        
        var mago = new MagoOscuro("Mago Tenebroso");
        var accion = new Action(mago.HechizoVeneno);

        
        CalculaEXP.CalcularEXP(accion, mago);

       
        Assert.Equal(0, mago.getExperiencia()); // Verifica que la experiencia del mago no haya cambiado
    }

    [Fact]
    public void CalcularEXP_MagoNulo()
    {
       
        Mago? mago = null;
        var accion = new Action(() => { });

        CalculaEXP.CalcularEXP(accion, mago);
    }
}