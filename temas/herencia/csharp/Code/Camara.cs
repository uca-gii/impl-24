using System;

// Clase derivada de "Sensor" llamada "Camara"
public abstract class Camara : Sensor {
    // Propiedad protegida en lugar de pública
    public string fabricanteCamara;

    // Método virtual que podrá ser invalidado/sobreescrito por las clases derivadas
    public virtual void capturarImagen() {
        Console.WriteLine("¡Capturando foto!");
    }

    // Método que NO podrá ser invalidado/sobreescrito por las clases derivadas
    public void GrabarVideo() {
        Console.WriteLine("¡Grabando video!");
    }

}