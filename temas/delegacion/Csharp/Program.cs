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

public class Operations
{
    // Declaración de un delegado que apunta a cualquier método que reciba un int y devuelva un int
    public delegate int Operation(int number);

    public static int Double(int x)
    {
        return x * 2;
    }

    public static int Triple(int x)
    {
        return x * 3;
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

        // Instanciando el delegado con un método específico
        Operations.Operation op = Operations.Double;
        Console.WriteLine("El doble de 5 es: " + op(5));

        // Cambiando la referencia del delegado a otro método
        op = Operations.Triple;
        Console.WriteLine("El triple de 5 es: " + op(5));
    }
}
