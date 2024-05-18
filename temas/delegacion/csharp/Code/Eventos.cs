using System;

// Definición de un delegate para manejar las notificaciones de eventos
delegate void ManejadorNotificacion(string mensaje);

// Clase para gestionar eventos del calendario
public class GestorEventosCalendario
{
    // Método para notificar eventos por correo electrónico
    public static void NotificarPorCorreo(string mensaje)
    {
        Console.WriteLine("Notificación por correo electrónico: " + mensaje);
    }

    // Método para notificar eventos por mensaje de texto
    public static void NotificarPorSMS(string mensaje)
    {
        Console.WriteLine("Notificación por mensaje de texto: " + mensaje);
    }

    // Método para notificar eventos a través de la aplicación
    public static void NotificarEnApp(string mensaje)
    {
        Console.WriteLine("Notificación en la aplicación: " + mensaje);
    }
}
