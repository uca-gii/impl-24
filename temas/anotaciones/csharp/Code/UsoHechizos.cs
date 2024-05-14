public class UsoHechizos{
    public static void Main(){
        MagoDeLuz magoLuz = new MagoDeLuz("Wander");
        MagoOscuro magoOscuro = new MagoOscuro("Dormin");
        
        magoLuz.HechizoFuego();
        CalculaEXP.CalcularEXP(magoLuz.HechizoFuego, magoLuz);

        magoLuz.HechizoHielo();
        CalculaEXP.CalcularEXP(magoLuz.HechizoHielo, magoLuz);

        magoLuz.HechizoLuz();
        CalculaEXP.CalcularEXP(magoLuz.HechizoLuz, magoLuz);
        
        magoOscuro.HechizoVeneno();
        CalculaEXP.CalcularEXP(magoOscuro.HechizoVeneno, magoOscuro);

        magoOscuro.HechizoMaldicion();
        CalculaEXP.CalcularEXP(magoOscuro.HechizoMaldicion, magoOscuro);

        magoOscuro.HechizoOscuridad();
        CalculaEXP.CalcularEXP(magoOscuro.HechizoOscuridad, magoOscuro);
    }
}