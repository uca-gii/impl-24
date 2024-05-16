namespace Transaccion
{
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

}

