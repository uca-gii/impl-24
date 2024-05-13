// Clase base "Sensor"
public class Sensor {

    // Propiedadad de la clase "Sensor" protegida
    protected int Id { get; set; }

    // Campos de la clase "Sensor" públicos
    public int Megapixeles;
    public int Resolucion;

    // Constructor de la clase "Sensor"
    public Sensor() {
        Id = new Random().Next(1, 1000);
    }

    // Clase anidada "Registro" marcada como sealed para evitar que sea heredada
    public sealed class datosRegistro { 
        public DateTime Fecha;
        public datosRegistro() {
            Fecha = DateTime.Now;
        }
    }
}