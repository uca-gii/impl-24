using System;
using System.Text.Json;
using System.Text.Json.Serialization;

// Definición del atributo personalizado
[AttributeUsage(AttributeTargets.Property, AllowMultiple = false)]
public class RangoEdadAttribute : Attribute
{
    public int Min { get; }
    public int Max { get; }

    public RangoEdadAttribute(int min, int max)
    {
        Min = min;
        Max = max;
    }
}

// Clase Persona para usar el atributo personalizado
public class Persona
{
    [RangoEdad(0, 130)]
    public int Edad { get; set; }
    public string Nombre { get; set; }

    public void Validar()
    {
        var properties = GetType().GetProperties();
        foreach (var property in properties)
        {
            var rangoEdadAttr = Attribute.GetCustomAttribute(property, typeof(RangoEdadAttribute)) as RangoEdadAttribute;
            if (rangoEdadAttr != null)
            {
                int valor = (int)property.GetValue(this);
                if (valor < rangoEdadAttr.Min || valor > rangoEdadAttr.Max)
                {
                    throw new ArgumentOutOfRangeException(property.Name, $"El valor de {property.Name} debe estar entre {rangoEdadAttr.Min} y {rangoEdadAttr.Max}.");
                }
            }
        }
    }
}

// Clase Producto para demostrar el control de serialización
public class Producto
{
    [JsonPropertyName("id_producto")]
    public int Id { get; set; }

    [JsonIgnore]
    public string Proveedor { get; set; }

    [JsonPropertyName("nombre")]
    public string Nombre { get; set; }

    [JsonPropertyName("precio")]
    public decimal Precio { get; set; }
}

// Programa principal
class Program
{
    static void Main(string[] args)
    {
        // Demostración de validación
        var persona = new Persona { Nombre = "Juan", Edad = 31 };
        try
        {
            persona.Validar();
            Console.WriteLine("Validacion exitosa.");
        }
        catch (ArgumentOutOfRangeException ex)
        {
            Console.WriteLine(ex.Message);
        }

        // Demostración de serialización
        var producto = new Producto
        {
            Id = 1,
            Proveedor = "Proveedor ABC",
            Nombre = "Teclado Mecanico",
            Precio = 99.99m
        };

        string json = JsonSerializer.Serialize(producto);
        Console.WriteLine(json);
    }
}
