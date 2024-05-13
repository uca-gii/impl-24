using System;

public class Personne
{
    // Propriétés en lecture seule
    public string Nom { get; }
    public int Age { get; }

    // Constructeur pour initialiser les propriétés
    public Personne(string nom, int age)
    {
        Nom = nom;
        Age = age;
    }

    // Méthode pour afficher les détails de la personne
    public void AfficherDetails()
    {
        Console.WriteLine($"Nom: {Nom}, Age: {Age}");
    }
}

class Program
{
    static void Main(string[] args)
    {
        // Création d'une instance de Personne
        Personne personne = new Personne("Jean", 30);

        // Accès aux propriétés en lecture seule
        Console.WriteLine($"Nom: {personne.Nom}, Age: {personne.Age}");

        // Utilisation de la méthode pour afficher les détails
        personne.AfficherDetails();
    }
}
