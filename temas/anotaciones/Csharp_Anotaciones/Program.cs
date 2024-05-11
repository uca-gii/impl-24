using System;
using System.Text.Json;
using System.Text.Json.Serialization;

// Definición del atributo personalizado
[AttributeUsage(AttributeTargets.Property, AllowMultiple = false)]
public class RangoEdadAttribute : Attribute
{
    public int Min { get; } // Valor mínimo permitido para la edad
    public int Max { get; } // Valor máximo permitido para la edad

    // Constructor del atributo personalizado
    public RangoEdadAttribute(int min, int max)
    {
        Min = min;
        Max = max;
    }
}

// Clase Persona para usar el atributo personalizado
public class Persona
{
    [RangoEdad(0, 130)] // Aplicación del atributo personalizado a la propiedad Edad
    public int Edad { get; set; } // Propiedad para almacenar la edad de la persona
    public string Nombre { get; set; } // Propiedad para almacenar el nombre de la persona

    // Método para validar la edad de la persona según el atributo personalizado
    public void Validar()
    {
        var properties = GetType().GetProperties(); // Obtiene todas las propiedades de la clase
        foreach (var property in properties)
        {
            var rangoEdadAttr = Attribute.GetCustomAttribute(property, typeof(RangoEdadAttribute)) as RangoEdadAttribute; // Obtiene el atributo personalizado de la propiedad
            if (rangoEdadAttr != null) // Si la propiedad tiene el atributo personalizado
            {
                int valor = (int)property.GetValue(this); // Obtiene el valor de la propiedad Edad
                if (valor < rangoEdadAttr.Min || valor > rangoEdadAttr.Max) // Comprueba si el valor está dentro del rango permitido
                {
                    throw new ArgumentOutOfRangeException(property.Name, $"El valor de {property.Name} debe estar entre {rangoEdadAttr.Min} y {rangoEdadAttr.Max}."); // Lanza una excepción si el valor está fuera del rango
                }
            }
        }
    }
}

// Clase Producto para demostrar el control de serialización
public class Producto
{
    [JsonPropertyName("id_producto")] // Personaliza el nombre de la propiedad en el JSON resultante
    public int Id { get; set; } // Propiedad para el ID del producto

    [JsonIgnore] // Ignora esta propiedad durante la serialización JSON
    public string Proveedor { get; set; } // Propiedad para el proveedor del producto

    [JsonPropertyName("nombre")] // Personaliza el nombre de la propiedad en el JSON resultante
    public string Nombre { get; set; } // Propiedad para el nombre del producto

    [JsonPropertyName("precio")] // Personaliza el nombre de la propiedad en el JSON resultante
    public decimal Precio { get; set; } // Propiedad para el precio del producto
}

// Programa principal
class Program
{
    static void Main(string[] args)
    {
        // Demostración de validación
        var persona = new Persona { Nombre = "Juan", Edad = 31 }; // Crea una instancia de Persona
        try
        {
            persona.Validar(); // Intenta validar la instancia de Persona
            Console.WriteLine("Validacion exitosa."); // Imprime un mensaje si la validación es exitosa
        }
        catch (ArgumentOutOfRangeException ex)
        {
            Console.WriteLine(ex.Message); // Imprime el mensaje de excepción si la validación falla
        }

        // Demostración de serialización
        var producto = new Producto
        {
            Id = 1,
            Proveedor = "Proveedor ABC",
            Nombre = "Teclado Mecanico",
            Precio = 99.99m
        };

        string json = JsonSerializer.Serialize(producto); // Serializa el objeto Producto a formato JSON
        Console.WriteLine(json); // Imprime el JSON resultante
    }
}
