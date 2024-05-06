public class Salon: Habitacion {
   
    public Salon(string nombre, double metrosCuadrados){
        this.nombre = nombre;
        this.metrosCuadrados = metrosCuadrados;
    }   
    public void VerTele(){
        Console.WriteLine("Viendo la tele...");
    }

    public void Sofa(){
        Console.WriteLine("Probando el sofá..");
    }

    public override void DetallesHabitacion(){
        Console.WriteLine("Salón de " + metrosCuadrados + " metros cuadrados.");
    }

    public override void ProbarHabitacion(){
        VerTele();
        Sofa();
    }
}