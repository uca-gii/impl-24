public class Inmobiliaria
{
    public static void Main()
    {
        Casa casa = new Casa();
        casa.AgregarHabitacion(new CuartoDeBaño("Baño pequeño", 10));
        casa.AgregarHabitacion(new Salon("Sala", 20));
        casa.AgregarHabitacion(new CuartoDeBaño("Baño grande", 20));

        casa.MostrarHabitaciones();

        casa.ProbarHabitaciones();
    }
}   