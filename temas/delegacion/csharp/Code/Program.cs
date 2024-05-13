
class Program
{
    static void Main(string[] args)
    {
        // Instanciar un delegate pasando el método al constructor
        ManejadorNotificacion delegateCorreo = new ManejadorNotificacion(GestorEventosCalendario.NotificarPorCorreo);

        // Establecer el delegate directamente a través del nombre del método
        ManejadorNotificacion delegateSMS = GestorEventosCalendario.NotificarPorSMS;

        // Usar un método anónimo como delegate
        ManejadorNotificacion delegateApp = delegate (string mensaje)
        {
            Console.WriteLine("Notificación anónima en la aplicación: " + mensaje);
        };

        // Utilizar expresiones lambda como delegate
        ManejadorNotificacion delegateLambda = (mensaje) =>
        {
            Console.WriteLine("Notificación lambda en la aplicación: " + mensaje);
        };

        // Encadenamiento de delegates
        ManejadorNotificacion cadenaDelegates = delegateCorreo + delegateSMS + delegateApp + delegateLambda;

        // Notificar eventos a través de todos los métodos de notificación
        cadenaDelegates("Tienes una reunión importante mañana a las 10:00 AM");

        // Remover un delegate de la cadena
        cadenaDelegates -= delegateSMS;

        // Notificar eventos después de remover un método de notificación
        cadenaDelegates("Se ha cancelado la reunión");

        Console.ReadKey();
    }
}
