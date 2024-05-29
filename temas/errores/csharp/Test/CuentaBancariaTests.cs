using System;
using Xunit;

namespace Transaccion.Tests
{
    public class CuentaBancariaTests
    {
        [Fact]
        public void CrearCuentaConSaldoInicial()
        {
            // Arrange
            string numeroCuenta = "123456789";
            decimal saldoInicial = 500.00m;

            // Act
            CuentaBancaria cuenta = new CuentaBancaria(numeroCuenta, saldoInicial);

            // Assert
            Assert.Equal(numeroCuenta, cuenta.NumeroCuenta);
            Assert.Equal(saldoInicial, cuenta.Saldo);
        }

        [Fact]
        public void RetirarMontoExitoso()
        {
            // Arrange
            CuentaBancaria cuenta = new CuentaBancaria("123456789", 500.00m);
            decimal monto = 100.00m;
            decimal saldoEsperado = 400.00m;

            // Act
            cuenta.Retirar(monto);

            // Assert
            Assert.Equal(saldoEsperado, cuenta.Saldo);
        }

        [Fact]
        public void RetirarMontoConSaldoInsuficiente()
        {
            // Arrange
            CuentaBancaria cuenta = new CuentaBancaria("123456789", 100.00m);
            decimal monto = 200.00m;

            // Act y Assert
            Assert.Throws<SaldoInsuficienteException>(() => cuenta.Retirar(monto));
        }

        [Fact]
        public void CrearCuentaConNumeroCuentaNulo()
        {
            // Arrange y Act y Assert
            Assert.Throws<ArgumentNullException>(() => new CuentaBancaria(null, 500.00m));
        }
    }
}
