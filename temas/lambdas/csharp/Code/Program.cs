using System;
using System.Threading.Tasks;

namespace CalculadoraLambda
{
    class Program
    {
        static async Task Main(string[] args)
        {
            Calculadora miCalculadora = new Calculadora();

            // Llamando a los métodos de la calculadora
            miCalculadora.Bienvenida();
            Console.WriteLine("El cuadrado de 5 es: " + miCalculadora.Cuadrado(5));
            Console.WriteLine("¿Es 5 igual a 5? " + miCalculadora.TestForEquality(5, 5));
            Console.WriteLine("La suma de 3 y 7 es: " + miCalculadora.Sumar(3, 7));
            Console.WriteLine("La división de 10 por 2 es: " + miCalculadora.Dividir(10, 2));
            miCalculadora.Saludar();
            Console.WriteLine("El producto de 4 y 6 es: " + miCalculadora.Multiplicar(4, 6));
            miCalculadora.MostrarMensaje(3);

            // Prueba de operaciones con tuplas
            var resultadoTupla = miCalculadora.OperacionesConTuplas((5, 6));
            Console.WriteLine($"La suma es: {resultadoTupla.suma}, y el producto es: {resultadoTupla.producto}");

            // Prueba de lambda asíncrona
            int resultadoAsincrono = await miCalculadora.CalcularAsincrono(10, 3);
            Console.WriteLine($"Resultado de la operación asíncrona: {resultadoAsincrono}");

            Console.ReadLine();
        }
    }
}


