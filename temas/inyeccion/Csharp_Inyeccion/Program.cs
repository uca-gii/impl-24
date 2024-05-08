using Microsoft.Extensions.DependencyInjection;


// Interfaces
public interface INotifier
{
    void SendNotification(string message);
}

public interface IOrderProcessor
{
    void ProcessOrder(string orderId);
}

public interface ILogger
{
    void Log(string message);
}

// Implementaciones de Notificadores
public class EmailNotifier : INotifier
{
    public void SendNotification(string message)
    {
        Console.WriteLine($"Enviando Email: {message}");
    }
}

public class SmsNotifier : INotifier
{
    public void SendNotification(string message)
    {
        Console.WriteLine($"Enviando SMS: {message}");
    }
}

// Implementación de Logger
public class ConsoleLogger : ILogger
{
    public void Log(string message)
    {
        Console.WriteLine($"Log: {message}");
    }
}

// Servicio de procesamiento de pedidos
public class OrderProcessor : IOrderProcessor
{
    private readonly INotifier _notifier;
    private readonly ILogger _logger;

    public OrderProcessor(INotifier notifier, ILogger logger)
    {
        _notifier = notifier;
        _logger = logger;
    }

    public void ProcessOrder(string orderId)
    {
        _logger?.Log($"Inicio del procesamiento del pedido {orderId}.");
        Console.WriteLine($"Procesando el pedido {orderId}.");
        _notifier?.SendNotification($"Su pedido {orderId} ha sido procesado exitosamente.");
        _logger?.Log($"Pedido {orderId} procesado y notificado.");
    }
}

// Programa principal
public class Program
{
    public static void Main(string[] args)
    {
        var services = new ServiceCollection();
        ConfigureServices(services, args);
        var serviceProvider = services.BuildServiceProvider();

        var orderProcessor = serviceProvider.GetService<IOrderProcessor>();
        if (orderProcessor != null)
        {
            orderProcessor.ProcessOrder("123456");
        }
    }

    private static void ConfigureServices(IServiceCollection services, string[] args)
    {
        services.AddSingleton<ILogger, ConsoleLogger>();

        // Determinar dinámicamente qué notificador utilizar
        if (args.Length > 0 && args[0].ToLower() == "sms")
        {
            services.AddTransient<INotifier, SmsNotifier>();
        }
        else
        {
            services.AddTransient<INotifier, EmailNotifier>();
        }

        services.AddTransient<IOrderProcessor, OrderProcessor>();
    }
}
