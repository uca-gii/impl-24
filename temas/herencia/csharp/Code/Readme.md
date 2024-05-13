# Herencia en POO

La herencia es uno de los atributos fundamentales de la programación orientada a objetos. Permite definir una clase secundaria que reutiliza (hereda), amplía o modifica el comportamiento de una clase primaria. La clase cuyos miembros son heredados se conoce como clase base. La clase que hereda los miembros de la clase base se conoce como clase derivada.

# Características de la herencia en C#
En está explicación de las carácterísticas de la herencia en C# voy a relacionar continuamente dichas características con mis ejemplos.

## Herencia única
En C#, una clase puede heredar únicamente de una única clase base. Esto implica que no se admite la herencia múltiple directa, aunque se puede lograr mediante interfaces.

## Herencia transitiva
La herencia en C# es transitiva, es decir, permite definir una jerarquía de herencia para un conjunto de tipos. Lo que significa que si una clase C hereda de una clase B, que a su vez hereda de una clase A, entonces la clase C también tiene acceso a los miembros de la clase A a través de la clase B.

```
// Clase Base "Sensor"
public class Sensor {}

// Clase Derivada de "Sensor" llamada "Camara"
public abstract class Camara : Sensor {}

// Clase derivada de "Camara" llamada "Smartphone"
public class Smartphone : Camara {}
```

## Miembros y clases no heredados
Algunos elementos no se heredan en C#. Estos incluyen constructores estáticos, constructores de instancias, finalizadores y clases de tipos específicos como structs, delegates y enums.


## Visibilidad en clases derivadas

-   Los miembros privados de una clase base solo son visibles en las clases derivadas que están anidadas en dicha clase base. De lo contrario, no son visibles en las clases derivadas.

-   Los miembros protegidos de una clase base son accesibles en las clases derivadas.

-   Los miembros públicos son visibles en las clases derivadas y forman parte de la interfaz pública de dichas clases.
 
## Algunas funcionalidades específicas del lenguaje para la herencia


-   **abstract**: La palabra clave `abstract` se utiliza para definir clases abstractas en C#. Una clase abstracta no puede ser instanciada directamente, es decir, no se pueden crear instancias de ella. Sin embargo, las clases derivadas pueden implementar la funcionalidad requerida mediante la implementación de los miembros abstractos definidos en la clase base. Además, una clase abstracta puede contener implementaciones de métodos concretos junto con miembros abstractos. Esto permite definir una estructura común para un conjunto de clases relacionadas y garantizar que ciertos métodos sean implementados por las clases derivadas.

```
public abstract class Camara : Sensor {}
``` 

-   **override**: La palabra clave `override` se utiliza en C# para anular/sobreescribir un método, propiedad, indexador o evento que está marcado como virtual en la clase base. Permite a una clase derivada proporcionar su propia implementación del miembro heredado, reemplazando así la implementación de la clase base. Esto es esencial para el polimorfismo, ya que permite que los métodos de la clase base sean reemplazados por implementaciones específicas de las clases derivadas.

-   **virtual**: En C#, los miembros de una clase base pueden ser marcados como virtuales, lo que permite a las clases derivadas anular (override) estos miembros con su propia implementación. Para poder invalidar un miembro en una clase derivada, el miembro de la clase base debe estar marcado con la palabra clave `virtual`. De forma predeterminada, los miembros de clase base no están marcados como virtuales y no se pueden invalidar. Esto proporciona flexibilidad para modificar el comportamiento de los métodos en las clases derivadas según sea necesario.


```
public abstract class Camara : Sensor {

    // Método virtual que podrá ser invalidado/sobreescrito por las clases derivadas
    public virtual void capturarImagen() {
        Console.WriteLine("¡Capturando foto!");
    }

    // Método que NO podrá ser invalidado/sobreescrito por las clases derivadas
    public void GrabarVideo() {
        Console.WriteLine("¡Grabando video!");
    }

}


public class Smartphone : Camara {

    // Método invalidado/sobreescrito de la clase base "Camara"
    public override void capturarImagen() {
        Console.WriteLine("¡Capturando foto con el smartphone!");
    }

    // No se puede invalidar ya que el método en la clase base "Camara" no está marcado como virtual
    /*
    public override void GrabarVideo() {
        Console.WriteLine("¡Grabando video con el smartphone!");
    }
    */
}
```

-   **sealed**: En C#, la palabra clave `sealed` se utiliza para evitar que una clase se herede. Cuando se marca una clase con la palabra clave `sealed`, no se puede derivar ninguna clase de ella. Esto se utiliza cuando se quiere evitar la herencia de una clase específica para mantener su diseño y comportamiento intactos. Además, los métodos, propiedades o eventos individuales también pueden ser marcados como `sealed`, lo que impide que se anulen en las clases derivadas.

```
public class Sensor {

    // Clase anidada "Registro" marcada como sealed para evitar que sea heredada
    public sealed class datosRegistro { 
        public DateTime Fecha;
        public datosRegistro() {
            Fecha = DateTime.Now;
        }
    }
}

```

- **protected**: El modificador de acceso `protected` se utiliza para especificar que un miembro de una clase es accesible solo dentro de la clase y sus clases derivadas. Esto significa que el miembro no es visible para el código fuera de la clase, pero puede ser accedido por las clases derivadas, lo que facilita la implementación de la encapsulación y la ocultación de detalles de implementación.

```
public class Sensor {

    // Propiedadad de la clase "Sensor" protegida
    protected int Id { get; set; }
}

class Program {
    static void Main(string[] args) {
        var smartphone = new Smartphone("Sony", 12, 1080, "iOS");

        // No se puede acceder directamente a Id heredado porque es protegido
        // Console.WriteLine("Id del sensor de la cámara: " + smartphone.Id); 
    }
}

```

-   **new**: La palabra clave `new` se utiliza en C# para ocultar un miembro heredado de la clase base y proporcionar una nueva implementación en la clase derivada. Esto se conoce como ocultación de miembros y puede llevar a situaciones confusas si no se usa con cuidado. La ocultación de miembros se utiliza cuando se quiere proporcionar una implementación diferente para un miembro específico en la clase derivada sin anular el miembro de la clase base.



## Herencia Implícita
Todos los tipos del sistema heredan implícitamente de Object. Por tanto, cualquier clase podrá tener acceso a los siguientes métodos:

-   **Método público `ToString`**: por defecto convierte un objeto en su representación de cadena, es decir, devuelve el nombre de tipo completo.

-   **Métodos de prueba de igualdad de dos objetos**: el método de instancia pública `Equals(Object)`, el método público estático `Equals(Object, Object)` y el método público estático `ReferenceEquals(Object, Object)`.

-   **Método público `GetHashCode`**: que calcula un valor que permite que una instancia del tipo se use en colecciones con hash.

-   **Método público `GetType`**: que devuelve un objeto Type que representa el tipo.

-   **Método protegido `Finalize`**: que está diseñado para liberar recursos no administrados antes de que el recolector de elementos no utilizados reclame la memoria de un objeto.

-   **Método protegido `MemberwiseClone`**: que crea un clon superficial del objeto actual

# Ejemplo de Herencia en C#

## Contexto del ejemplo
El ejemplo trata sobre como una clase Smartphone hereda los componentes de una cámara y un sensor. Por un lado, tenemos a la clase **Sensor**, que tiene un Id (protegido), Megapixeles, Resolucion y una clase anidada datosRegistro marcada como sealed para evitar que sea heredada. Por otro lado, tenemos una clase **Camara** que hereda de Sensor con un atributo fabricanteCamara, y dos métodos capturarImagen y grabarVideo. Por último, tenemos la clase **Smartphone** que hereda los métodos de la clase Camara y que invalida/sobreescribe el método capturarImagen.

## Objetivo del ejemplo
Ilustrar y demostrar como se lleva a cabo la herencia en C# y cómo se utilizan las funcionalidades más frecuentes de la herencia en este lenguaje.

## Ejecución del ejemplo
Para comprobar como funciona la herencia en este ejemplo, basta con ejecutar el archivo `Program.cs`.