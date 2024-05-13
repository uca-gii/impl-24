using System;
using System.Collections.Generic;

// Classe abstraite représentant un employé
public abstract class Employe
{
    public string Nom { get; }
    public int Age { get; }
    public double Salaire { get; protected set; }

    // Constructeur
    protected Employe(string nom, int age, double salaire)
    {
        Nom = nom;
        Age = age;
        Salaire = salaire;
    }

    // Méthode abstraite pour calculer le salaire
    public abstract void CalculerSalaire();
}

// Classe dérivée représentant un employé permanent
public class EmployePermanent : Employe
{
    public EmployePermanent(string nom, int age, double salaireFixe)
        : base(nom, age, salaireFixe)
    {
    }

    // Implémentation de la méthode pour calculer le salaire
    public override void CalculerSalaire()
    {
        // Salaire mensuel fixe
        Salaire = Salaire * 12 / 52; // Salaire hebdomadaire
    }
}

// Classe dérivée représentant un employé temporaire
public class EmployeTemporaire : Employe
{
    public double TauxHoraire { get; }
    public int HeuresTravaillees { get; }

    public EmployeTemporaire(string nom, int age, double tauxHoraire, int heuresTravaillees)
        : base(nom, age, 0)
    {
        TauxHoraire = tauxHoraire;
        HeuresTravaillees = heuresTravaillees;
    }

    // Implémentation de la méthode pour calculer le salaire
    public override void CalculerSalaire()
    {
        // Salaire horaire
        Salaire = TauxHoraire * HeuresTravaillees;
    }
}

class Program
{
    static void Main(string[] args)
    {
        // Création d'une liste d'employés
        List<Employe> employes = new List<Employe>
        {
            new EmployePermanent("Alice", 35, 50000),
            new EmployeTemporaire("Bob", 25, 20, 40),
        };

        // Calcul des salaires pour chaque employé
        foreach (var employe in employes)
        {
            employe.CalculerSalaire();
        }

        // Affichage des détails de chaque employé
        foreach (var employe in employes)
        {
            Console.WriteLine($"Nom: {employe.Nom}, Age: {employe.Age}, Salaire: {employe.Salaire:C}");
        }
    }
}
