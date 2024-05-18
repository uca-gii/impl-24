using System;

namespace Transaccion
{
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
}
