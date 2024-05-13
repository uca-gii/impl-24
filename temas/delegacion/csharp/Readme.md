# Delegación en POO

Un delegate es un tipo que representa referencias a métodos con una lista de parámetros determinada y un tipo de valor devuelto. Es la versión de .NET de los punteros a función de C++ pero con seguridad de tipos (type-safe), es decir, se comprueban los tipos de retorno y de los parámetros del mismo. La clase de delegate no sólo contiene una referencia a un método, también puede mantener referencias a varios métodos mientras cumplan con la firma definida.
Los delegates se utilizan para pasar métodos como argumentos a otros métodos. Indicar que los manejadores de eventos no son más que métodos que se invocan a través de delegates.

# Características de la delegación en C#

-   **Permiten pasar métodos como parámetros**: Esto permite que los métodos sean tratados como datos, lo que facilita la implementación de patrones como el Observer o el Command.

-   **Definición de métodos callback**: Los delegates son ideales para definir métodos callback, es decir, métodos que serán llamados en respuesta a algún evento o acción específica.

-   **Encadenamiento de delegates**: Se pueden encadenar múltiples métodos a un solo evento, lo que proporciona una forma conveniente de ejecutar una serie de acciones en respuesta a un solo evento.

-   **Flexibilidad en la firma del método**: No es estrictamente necesario que los métodos coincidan exactamente con la firma del delegate. Esto permite una mayor flexibilidad en el uso de delegates.

-   **Los tipos de delegates son sealed**: Esto significa que los tipos de delegates no pueden ser derivados o heredados, lo que garantiza la integridad y la seguridad del tipo.


## Formas de instanciar un delegate en C#

-   **Pasando el método al constructor del delegate**: Esto implica crear una instancia del delegate y pasarle como argumento el método que cumple con la firma requerida.
```
ManejadorNotificacion delegateCorreo = new ManejadorNotificacion(GestorEventosCalendario.NotificarPorCorreo);
```


-   **Estableciendo directamente a través del nombre del método**: Se puede asignar un método al delegate directamente, siempre y cuando el método coincida con la firma del delegate.

```
ManejadorNotificacion delegateSMS = GestorEventosCalendario.NotificarPorSMS;
```

-   **Utilizando métodos anónimos (Anonymous Methods)**: Estos son bloques de código sin nombre que se pueden pasar como parámetros de delegate, proporcionando una forma concisa de definir y utilizar métodos ad-hoc.

```
    ManejadorNotificacion delegateApp = delegate (string mensaje)
    {
        Console.WriteLine("Notificación anónima en la aplicación: " + mensaje);
    };
```

-   **Empleando expresiones lambda**: Las expresiones lambda permiten definir funciones en línea de forma concisa. Son especialmente útiles al trabajar con delegates, ya que permiten crear y pasar funciones de forma más compacta y legible.

```
    ManejadorNotificacion delegateLambda = (mensaje) =>
    {
        Console.WriteLine("Notificación lambda en la aplicación: " + mensaje);
    };
```


# Ejemplo de Delegación en C#

`Eventos.cs`:
```
using System;

// Definición de un delegate para manejar las notificaciones de eventos
delegate void ManejadorNotificacion(string mensaje);

// Clase para gestionar eventos del calendario
class GestorEventosCalendario
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
```

`Program.cs`:
```

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
```

## Contexto del ejemplo
En este ejemplo, se muestra cómo utilizar la delegación en C# a través de una clase de gestión de eventos para una aplicación de calendario.

## Objetivo del ejemplo
El objetivo principal es demostrar las diferentes características de la delegación en C#, incluyendo la instanciación de delegates mediante varios métodos, el uso de métodos anónimos y expresiones lambda, el encadenamiento de delegates y la eliminación de delegates de una cadena de delegates.

## Ejecución del ejemplo
Para comprobar como funciona la delegación en este ejemplo, basta con compilar y ejecutar el archivo `Program.cs`