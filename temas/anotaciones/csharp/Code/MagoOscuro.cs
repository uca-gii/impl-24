using System;
using System.ComponentModel.DataAnnotations;

public class MagoOscuro: Mago
{
    public MagoOscuro(string nom)
    {
        nombre = nom;
        experiencia = 0;
    }
    public void HechizoVeneno()
    {
        Console.WriteLine("Lanzando hechizo de veneno");
    }

    [AnotacionExp(30)]
    public void HechizoMaldicion()
    {
        Console.WriteLine("Lanzando hechizo de maldicion");
    
    }

    [AnotacionExp(110)]
    public void HechizoOscuridad()
    {
        Console.WriteLine("Lanzando hechizo de oscuridad");
    }   
}