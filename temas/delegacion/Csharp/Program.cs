﻿// See https://aka.ms/new-console-template for more information
using System;

// Definición de la interfaz INotifier
public interface INotifier
{
    void SendNotification(string message);
}

// Implementación de notificación por Email
public class EmailNotifier : INotifier
{
    public void SendNotification(string message)
    {
        Console.WriteLine($"Enviando Email: {message}");
    }
}

// Implementación de notificación por SMS
public class SmsNotifier : INotifier
{
    public void SendNotification(string message)
    {
        Console.WriteLine($"Enviando SMS: {message}");
    }
}

// Clase NotificationManager que delega el envío de notificaciones
public class NotificationManager
{
    private INotifier notifier;

    public NotificationManager(INotifier notifier)
    {
        this.notifier = notifier;
    }

    public void Notify(string message)
    {
        Console.WriteLine("Preparando para enviar notificación...");
        notifier.SendNotification(message);
    }
}

// Programa principal
public class Program
{
    public static void Main()
    {
        INotifier emailNotifier = new EmailNotifier();
        NotificationManager manager = new NotificationManager(emailNotifier);
        manager.Notify("Hola! Este es un mensaje de prueba.");

        // Cambiar la estrategia de notificación en tiempo de ejecución
        INotifier smsNotifier = new SmsNotifier();
        manager = new NotificationManager(smsNotifier);
        manager.Notify("Otro mensaje, ahora por SMS.");
    }
}