using System;
using System.ComponentModel.DataAnnotations;

public class MagoDeLuz: Mago
{
    public MagoDeLuz(string nom)
    {
        nombre = nom;
        experiencia = 0;
    }

    public void HechizoFuego()
    {
        Console.WriteLine("Lanzando hechizo de fuego");
    }

    [AnotacionExp(25)]
    public void HechizoHielo()
    {
        Console.WriteLine("Lanzando hechizo de hielo");
    }

    [AnotacionExp(100)]
    public void HechizoLuz()
    {
        Console.WriteLine("Lanzando hechizo de luz");
    }   
}