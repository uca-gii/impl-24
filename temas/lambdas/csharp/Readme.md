# Lambdas en POO

En el paradigma de programación orientada a objetos, una lambda es una función anónima que se puede tratar como un objeto. En lenguajes de programación como C# las lambdas pueden ser utilizadas para representar comportamientos específicos o algoritmos que se pueden pasar como argumentos a métodos, almacenarse en variables y, en general, tratarse como objetos de primera clase.

# Características de la lambda en C#

Toda expresión lambda se puede convertir en un tipo delegate. 
El tipo delegado al que se puede convertir una expresión lambda se define según los tipos de sus parámetros y el valor devuelto. Si una expresión lambda no devuelve un valor, se puede convertir en uno de los tipos delegados Action; de lo contrario, se puede convertir en uno de los tipos delegados Func. Por ejemplo, una expresión lambda que tiene dos parámetros y no devuelve ningún valor corresponde a un delegado Action<T1,T2>. Una expresión lambda que tiene un parámetro y devuelve un valor se puede convertir en un delegado Func<T,TResult>.

## Formas de las lambdas en C#

**Lambda de expresión**:
Una expresión lambda con una expresión en el lado derecho del operador => se denomina lambda de expresión. Una expresión lambda devuelve el resultado de evaluar la condición.
```
(input-parameters) => expression
```
**Lambda de instrucción**:
Una lambda de instrucción es similar a un lambda de expresión, salvo que las instrucciones se encierran entre llaves.
```
(input-parameters) => { <sequence-of-statements> }
```

## Parámetros de una expresión lambda

-   Los parámetros de entrada se encierran entre paréntesis. Para especificar cero parámetros, se utilizan paréntesis vacíos.

```
 public void Bienvenida() => Console.WriteLine("Hola! Bienvenido a la calculadora!");
```

-   Si solo hay un parámetro, los paréntesis son opcionales.

```
public double Cuadrado(double x) => x * x;
```

-   Para dos o más parámetros, se separan mediante comas.
```
public bool TestForEquality(int x, int y) => x == y;
```

-   Los tipos de parámetros deben ser todos explícitos o implícitos para evitar errores.
```
public int Sumar(int a, int b) => a + b;
```

-   Desde C# 12, se pueden definir valores predeterminados para los parámetros.
```
public void Saludar(string nombre = "Usuario") => Console.WriteLine($"Hola, {nombre}!");
```

-   En ocasiones, el tipo de valor devuelto no es inferido automáticamente. Desde C# 10, se puede especificar antes de los parámetros.

-   A partir de C# 10, se pueden agregar atributos tanto a los parámetros como al valor devuelto.
```
public int Multiplicar(int a, int b) => checked(a * b);
``` 

## Lambdas asincrónicas

Se pueden crear fácilmente expresiones e instrucciones lambda que incorporen el procesamiento asincrónico mediante las palabras clave async y await.

```
public async Task<int> CalcularAsincrono(int a, int b)
{
    return await Task.Run(() => a * b);
}
```

## Expresiones lambda y tuplas

Se puede proporcionar una tupla como argumento a una expresión lambda, mientras que la expresión lambda también puede devolver una tupla. Para definir una tupla, se incluye entre paréntesis una lista de los componentes delimitada por comas.

```
public (int suma, int producto) OperacionesConTuplas((int a, int b) tupla)
{
    Func<int, int, int> sumar = (x, y) => x + y;
    Func<int, int, int> multiplicar = (x, y) => x * y;

    int resultadoSuma = sumar(tupla.a, tupla.b);
    int resultadoProducto = multiplicar(tupla.a, tupla.b);

    return (resultadoSuma, resultadoProducto);
}
```

## Captura de variables externas y el ámbito de las variables en las expresiones lambda

Las operaciones lambda pueden hacer referencia a variables externas. Estas variables externas son las variables que están en el ámbito del método que define la expresión lambda o en el ámbito del tipo que contiene la expresión lambda. Las variables que se capturan de esta manera se almacenan para su uso en la expresión lambda, cuando de otro modo quedarían fuera de ámbito y serían eliminadas por la recolección de elementos no utilizados. Para poder utilizar una variable externa en una expresión lambda, debe estar previamente asignada.

```
public void MostrarMensaje(int x)
{
    int y = 10;
    Func<int, int> sumar = z => z + x + y;
    Console.WriteLine($"El resultado es: {sumar(5)}");
}
```

# Ejemplo de Lambdas en C#

`Calculadora.cs`:
```
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
```

`Program.cs`:
```
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
```

## Contexto del ejemplo
El ejemplo se sitúa en el desarrollo de una aplicación de calculadora en C#. Se utiliza la programación funcional para definir diversas operaciones matemáticas utilizando expresiones lambda.

## Objetivo del ejemplo
El objetivo es demostrar cómo usar lambdas en C# para simplificar la definición de funciones pequeñas y expresivas que pueden ser utilizadas en diferentes contextos, como cálculos matemáticos en una calculadora.

## Ejecución del ejemplo
Para comprobar como funcionan las lambdas en este ejemplo, basta con compilar y ejecutar el archivo `Program.cs`.