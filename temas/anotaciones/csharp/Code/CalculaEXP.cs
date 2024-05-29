using System.ComponentModel.DataAnnotations;
public class CalculaEXP{
   public static void CalcularEXP(Action accion, Mago mago)
    {
        var atributo = (AnotacionExpAttribute?)accion.Method.GetCustomAttributes(typeof(AnotacionExpAttribute), false).FirstOrDefault();

        if (atributo != null)
        {
            Console.WriteLine(mago.getNombre() + ", has ganado " + atributo.ExpGanada + " puntos de experiencia!");
            mago.GanarExperiencia(atributo.ExpGanada);
            Console.WriteLine("Tu experiencia actual es: " + mago.getExperiencia()+ "\n\n");
        }
        else
        {
            Console.WriteLine("No has ganado experiencia.\n\n");
        }
    }
}