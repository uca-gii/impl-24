using System;
using System.Threading.Tasks;

namespace CalculadoraLambda
{
    public class Calculadora
    {
        // Método con lambda que utiliza cero parámetros
        public void Bienvenida() => Console.WriteLine("Hola! Bienvenido a la calculadora!");

        // Método con lambda que utiliza un solo parámetro
        public double Cuadrado(double x) => x * x;

        // Método con lambda que utiliza dos o más parámetros
        public bool TestForEquality(int x, int y) => x == y;

        // Método con lambda que utiliza tipos de parámetros explícitos
        public int Sumar(int a, int b) => a + b;

        // Método con lambda que utiliza tipos de parámetros implícitos
        public double Dividir(double a, double b) => a / b;

        // Método con lambda que utiliza un valor predeterminado para un parámetro
        public void Saludar(string nombre = "Usuario") => Console.WriteLine($"Hola, {nombre}!");

        // Método con lambda que especifica el tipo de valor devuelto explícitamente
        public int Multiplicar(int a, int b) => checked(a * b); // checked para evitar desbordamientos

        // Método con lambda que muestra el ámbito de las variables externas
        public void MostrarMensaje(int x)
        {
            int y = 10;
            Func<int, int> sumar = z => z + x + y;
            Console.WriteLine($"El resultado es: {sumar(5)}");
        }

        // Método que utiliza expresiones lambda y tuplas
        public (int suma, int producto) OperacionesConTuplas((int a, int b) tupla)
        {
            Func<int, int, int> sumar = (x, y) => x + y;
            Func<int, int, int> multiplicar = (x, y) => x * y;

            int resultadoSuma = sumar(tupla.a, tupla.b);
            int resultadoProducto = multiplicar(tupla.a, tupla.b);

            return (resultadoSuma, resultadoProducto);
        }

        // Método que utiliza una lambda asíncrona
        public async Task<int> CalcularAsincrono(int a, int b)
        {
            return await Task.Run(() => a * b);
        }
    }
}
