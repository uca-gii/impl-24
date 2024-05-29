# Ténicas para el tratamiento de errores en C#
C# ofrece una variedad de funcionalidades y mecanismos para el tratamiento de errores, permitiéndos a los desarrolladores manejar excepciones y errores de manera eficiente.


# Excepciones

## Instrucciones básicas para el manejo de excepciones

-   **try-catch**: Se usa un bloque try para separar el código que podría verse afectado por una excepción y un bloque catch asociado para controlar las excepciones resultantes.

-   **try-finally**: Un bloque finally contiene código que se ejecuta independientemente de si se produce una excepción en el bloque try

-   **throw**: Instrucción utilizada para lanzar una excepción, ya sea nueva o la que se está manejando.

## Jerarquía de Excepciones

-   Las excepciones en C# heredan de la clase base System.Exception.

-   Existen múltiples excepciones específicas como ArgumentNullException, InvalidOperationException IndexOutOfRangeException, entre otras, que permiten manejar diferentes tipos de errores de manera más precisa.

`CuentaBancaria.cs`
```
public CuentaBancaria(string numeroCuenta, decimal saldoInicial)
{
    if (string.IsNullOrWhiteSpace(numeroCuenta))
    {
        // Lanza una excepción si el número de cuenta es nulo o vacío
        throw new ArgumentNullException(nameof(numeroCuenta), "El número de cuenta no puede ser nulo o vacío.");
    }

    NumeroCuenta = numeroCuenta;
    Saldo = saldoInicial;
}
```

## Excepciones Personalizadas

Podemos crear nuestras propias excepciones heredando de la clase Exception o de alguna subclase de esta.

`Excepcion.cs`
```
// Excepción personalizada para saldo insuficiente
public class SaldoInsuficienteException : Exception
{
    public SaldoInsuficienteException(string mensaje) : base(mensaje) { }
}
```

`CuentaBancaria.cs`
```
try
{
    // Verifica si el monto a retirar es mayor al saldo
    if (monto > Saldo)
    {
        // Lanza una excepción personalizada si el saldo es insuficiente
        throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro.");
    }

    // Realiza la transacción
    Saldo -= monto;
    Console.WriteLine($"Retiro exitoso de {monto:C}. Saldo actual: {Saldo:C}");
}
catch (SaldoInsuficienteException ex) when (LoguearExcepcion(ex)) 
{
    // Loguea la excepción y relanza para que los métodos superiores la puedan manejar si es necesario
    Console.WriteLine($"ERROR: {ex.Message}");
    throw;
}
```

## Filtros de Excepciones

Permiten especificar condiciones adicionales para cuando un bloque catch debe manejar una excepción.
`CuentaBancaria.cs`: 
```
catch (SaldoInsuficienteException ex) when (LoguearExcepcion(ex)) 
```
```
private bool LoguearExcepcion(Exception ex)
{
    // Simulación de registro de excepción (p. ej., a un archivo o base de datos)
    Console.WriteLine($"Excepción registrada: {ex.Message}");
    return true; // Siempre retorna true para ejecutar el bloque catch
}
```

# Ejemplo de Excepciones en C#

`Excepcion.cs`:
```
// Excepción personalizada para saldo insuficiente
public class SaldoInsuficienteException : Exception
{
    public SaldoInsuficienteException(string mensaje) : base(mensaje) { }
}
```

`CuentaBancaria.cs`
```
public class CuentaBancaria
{
    public string NumeroCuenta { get; private set; }
    public decimal Saldo { get; private set; }

    public CuentaBancaria(string numeroCuenta, decimal saldoInicial)
    {
        if (string.IsNullOrWhiteSpace(numeroCuenta))
        {
            // Lanza una excepción si el número de cuenta es nulo o vacío
            throw new ArgumentNullException(nameof(numeroCuenta), "El número de cuenta no puede ser nulo o vacío.");
        }

        NumeroCuenta = numeroCuenta;
        Saldo = saldoInicial;
    }

    public void Retirar(decimal monto)
    {
        // Bloque try-catch para manejar excepciones
        try
        {
            // Verifica si el monto a retirar es mayor al saldo
            if (monto > Saldo)
            {
                // Lanza una excepción personalizada si el saldo es insuficiente
                throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro.");
            }

            // Realiza la transacción
            Saldo -= monto;
            Console.WriteLine($"Retiro exitoso de {monto:C}. Saldo actual: {Saldo:C}");
        }
        catch (SaldoInsuficienteException ex) when (LoguearExcepcion(ex)) // Filtra la excepción personalizada
        {
            // Loguea la excepción y relanza para que los métodos superiores la puedan manejar si es necesario
            Console.WriteLine($"ERROR: {ex.Message}");
            throw;
        }
        finally
        {
            // El bloque finally se ejecuta siempre
            Console.WriteLine("Operación de retiro finalizada.");
        }
    }

    private bool LoguearExcepcion(Exception ex)
    {
        // Simulación de registro de excepción (p. ej., a un archivo o base de datos)
        Console.WriteLine($"Excepción registrada: {ex.Message}");
        return true; // Siempre retorna true para ejecutar el bloque catch
    }
}
```

`Program.cs`:
```
public class Program
{
    public static void Main(string[] args)
    {   
        // Creamos una cuenta bancaria válida
        CuentaBancaria cuenta = new CuentaBancaria("123456789", 500.00m);

        // Intentamos realizar varias operaciones de retiro
        cuenta.Retirar(100.00m);  // Operación exitosa
        cuenta.Retirar(600.00m);  // Fallará por saldo insuficiente

        // Intentamos crear una cuenta bancaria con número de cuenta nulo
        CuentaBancaria cuentaInvalida = new CuentaBancaria(null, 500.00m); // Fallará por número de cuenta nulo
    }
}
```

## Contexto del ejemplo
Este ejemplo simula el funcionamiento básico de una cuenta bancaria en un sistema de transacciones financieras. La clase CuentaBancaria representa una cuenta bancaria con un número de cuenta y un saldo. Permite realizar transacciones como retirar dinero, y maneja excepciones cuando se intenta retirar más dinero del saldo disponible o ingresar datos incorrectos.

## Objetivo del ejemplo
El objetivo de este ejemplo es ilustrar cómo manejar excepciones en C# utilizando bloques try-catch y try-catch-finally, así como también cómo implementar excepciones personalizadas y filtros de excepción. En particular, se muestra cómo capturar y manejar excepciones específicas, como ArgumentNullException y una excepción personalizada SaldoInsuficienteException. Además, se demuestra el uso del bloque finally para garantizar la ejecución de código importante, como la limpieza de recursos, independientemente de si se produce una excepción o no.

## Ejecución del ejemplo
Para comprobar como funcionan las lambdas en este ejemplo, basta con compilar y ejecutar el archivo `Program.cs`.