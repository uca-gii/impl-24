using System;

// Definición de la clase base (padre)
class Animal
{
    public virtual void Comer()
    {
        Console.WriteLine("El animal está comiendo comida.");
    }
}

// Definición de la clase derivada (hijo) que hereda de la clase base Animal
class Perro : Animal
{
    // Se sobrescribe el método Comer para los perros
    public override void Comer()
    {
        Console.WriteLine("El perro está comiendo carne.");
    }

    // Nuevo método específico para perros
    public void Ladrar()
    {
        Console.WriteLine("¡El perro está ladrando!");
    }
}

// Definición de la clase derivada (hijo) que hereda de la clase base Animal
class Gato : Animal
{
    // Se sobrescribe el método Comer para los gatos
    public override void Comer()
    {
        Console.WriteLine("El gato está comiendo pescado.");
    }

    // Nuevo método específico para gatos
    public void Ronronear()
    {
        Console.WriteLine("¡El gato está ronroneando!");
    }
}

class Program
{
    static void Main()
    {
        // Creación de objetos de tipo Perro y Gato
        Perro miPerro = new Perro();
        Gato miGato = new Gato();

        // Llamada a métodos propios de cada objeto
        miPerro.Comer();    // Utiliza el método sobrescrito en Perro
        miPerro.Ladrar();   // Utiliza el método específico de Perro

        miGato.Comer();     // Utiliza el método sobrescrito en Gato
        miGato.Ronronear(); // Utiliza el método específico de Gato

        // Uso de polimorfismo con un arreglo de objetos Animal
        Animal[] misAnimales = new Animal[] { miPerro, miGato };

        // Iterar sobre el arreglo y llamar al método Comer de cada objeto
        foreach (Animal animal in misAnimales)
        {
            animal.Comer(); // Llama al método Comer apropiado según el tipo de objeto
        }
    }
}