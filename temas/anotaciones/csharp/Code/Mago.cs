public abstract class Mago{
    protected string? nombre;
    protected int experiencia;

    public void GanarExperiencia(int exp)
    {
        experiencia += exp;
    }

    public int getExperiencia()
    {
        return experiencia;
    }
    public string getNombre(){
        if(nombre == null) return "Sin nombre";
        return nombre;
    }
}
