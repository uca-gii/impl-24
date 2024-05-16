using System;


namespace Transaccion
{
    // Excepción personalizada para saldo insuficiente
    public class SaldoInsuficienteException : Exception
    {
        public SaldoInsuficienteException(string mensaje) : base(mensaje) { }
    }
}
