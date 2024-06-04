# Lambdas en Scala

Este directorio contiene ejemplos prácticos sobre cómo usar funciones lambda en Scala para mejorar la eficiencia y la expresividad del código.

## Estructura del Directorio

- [`src/main/scala/example`](src/main/scala/example): Contiene código de ejemplo utilizando funciones lambda en Scala y la aplicación de terminal.
- [`src/test/scala/example`](src/test/scala/example): Contiene los test para el código de ejemplo en Scala.
- [`build.sbt`](build.sbt): Archivo de configuración de SBT que define las dependencias y configuraciones del proyecto.
- [`project/build.properties`](project/build.properties): Archivo que especifica la versión de SBT utilizada por el proyecto.

## Explicación teórica

Las funciones lambda, o funciones anónimas, son bloques de código que pueden ser tratados como valores, permitiendo ser pasados y devueltos como argumentos de otras funciones. En Scala, las lambdas son fundamentales para la programación funcional, ofreciendo una sintaxis concisa para operaciones que requieren expresiones de función.

### Sintaxis básica

La sintaxis de una función lambda en Scala se compone del cuerpo de la función precedido por una lista de parámetros y una flecha `=>`.

```scala
val suma = (x: Int, y: Int) => x + y
```

### Tipos de funciones lambda

- **Con parámetros**: Como en el ejemplo anterior, donde se especifican los tipos de los parámetros.
- **Sin parámetros**: Puede ejecutarse sin necesidad de argumentos de entrada.

```scala
val saludo = () => "Hola Mundo"
```

- **Con múltiples líneas**: Si la lógica es más compleja, se pueden incluir varias instrucciones dentro de llaves.

```scala
val ajuste = (precio: Double) => {
  val impuesto = 1.21
  precio * impuesto
}
```

### Características principales

- **Inmutabilidad**: Scala fomenta el uso de datos inmutables, y las lambdas ayudan a mantener este enfoque al desalentar los cambios de estado.
- **Funciones de alto orden**: Las funciones que toman funciones como argumentos o devuelven funciones como resultado se conocen como funciones de alto orden, y son una pieza central en Scala para operaciones como mapeo y filtrado.

### Ejemplo detallado: Uso de Lambdas en operaciones de colección

```scala
val numeros = List(1, 2, 3, 4, 5)
val cuadrados = numeros.map(n => n * n) // Lambda para elevar al cuadrado
val pares = numeros.filter(n => n % 2 == 0) // Lambda para filtrar números pares
val sumaTotal = numeros.reduce((a, b) => a + b) // Lambda para sumar elementos
```

## Contenido

Se ha desarrollado una pequeña aplicación de terminal que sirve para llevar a cabo un registro de estudiantes y notas usando funciones anónimas. También se han creado test con ScalaTest.

### Código ejemplos

#### [`SistemaEstudiantes`](src/main/scala/example/SistemaEstudiantes.scala)

```scala
object SistemaEstudiantes {
    case class Estudiante(nombre: String, id: String, var calificaciones: List[Double])

    val estudiantes = mutable.ListBuffer(
        Estudiante("Juan", "A1", List(8.0, 7.5, 9.0)),
        Estudiante("Ana", "A2", List(6.5, 7.0, 8.0)),
        Estudiante("Luis", "A3", List(4.0, 5.5, 6.0))
    )

    def agregarNota(id: String, nota: Double): Unit = {
        estudiantes.find(_.id == id) match {
            case Some(estudiante) =>
                estudiante.calificaciones = estudiante.calificaciones :+ nota
                println(s"Nota agregada al estudiante ${estudiante.nombre}.")
            case None =>
                println("Estudiante no encontrado. ¿Deseas añadir un nuevo estudiante? (s/n)")
                if (readLine().toLowerCase == "s") {
                    println("Introduce el nombre del estudiante:")
                    val nombre = readLine()
                    estudiantes += Estudiante(nombre, id, List(nota))
                    println(s"Nuevo estudiante añadido: $nombre con ID $id y nota $nota.")
                }
        }
    }

    def mostrarReportes(): Unit = {
        estudiantes.foreach { est =>
            val promedio = est.calificaciones.sum / est.calificaciones.length
            val estatus = promedio match {
                case x if x < 5 => "Insuficiente"
                case x if x < 7 => "Suficiente"
                case x if x < 9 => "Notable"
                case _ => "Sobresaliente"
            }
            println(s"Estudiante: ${est.nombre}, Promedio: $promedio, Estado: $estatus")
        }
    }

    def notaMediaCurso(): Double = {
        estudiantes.flatMap(_.calificaciones).sum / estudiantes.flatMap(_.calificaciones).size
    }

    def estudiantesConTutoria(): Unit = {
        estudiantes.filter(est => est.calificaciones.sum / est.calificaciones.length < 5).foreach { est =>
            println(s"Estudiante: ${est.nombre}, ID: ${est.id}, necesita tutoría.")
        }
    }

    def limpiarPantalla(): Unit = {
        val os = System.getProperty("os.name").toLowerCase()
        if (os.contains("windows")) "cls".! else "clear".!
    }

    def main(args: Array[String]): Unit = {
        var continuar = true
        limpiarPantalla()
        while (continuar) {
            println("\nOpciones:")
            println("1. Mostrar reportes de estudiantes")
            println("2. Agregar nota a un estudiante")
            println("3. Nota media del curso")
            println("4. Estudiantes que necesitan tutoría")
            println("5. Salir")
            println("Elige: ")
            val in = readLine()
            limpiarPantalla()
            in match {
                case "1" => mostrarReportes()
                case "2" => {
                    println("Introduce el ID del estudiante:")
                    val id = readLine()
                    println("Introduce la nueva nota:")
                    val nota = readLine().toDouble
                    agregarNota(id, nota)
                }
                case "3" => println(f"La nota media del curso es: ${notaMediaCurso()}%.2f")
                case "4" => estudiantesConTutoria()
                case "5" => continuar = false
                case _ => println("Opción no válida")
            }
        }
    }
}
```

1. **Búsqueda de un estudiante específico**:
   ```scala
   estudiantes.find(_.id == id)
   ```
   Esta función anónima evalúa cada `Estudiante` en la lista para encontrar uno que coincida con el `id` especificado.

2. **Filtrado de estudiantes para tutoría**:
   ```scala
   estudiantes.filter(est => est.calificaciones.sum / est.calificaciones.length < 5)
   ```
   Aquí, la función anónima calcula el promedio de las calificaciones de cada estudiante y devuelve aquellos cuyo promedio es menor que 5, indicando que necesitan tutoría.

3. **Iteración para mostrar reportes**:
   ```scala
   estudiantes.foreach { est =>
       ...
   }
   ```
   Aunque más estructurada, esta es esencialmente una función anónima que se aplica a cada `Estudiante` en la lista para calcular su promedio y determinar su estatus académico.

Estas funciones permiten realizar operaciones directamente sobre la colección `estudiantes`, facilitando la lectura y mantenimiento del código al encapsular operaciones comunes sin necesidad de nombrar explícitamente cada función.


### Código tests

```scala
class SistemaEstudiantesTest extends AnyFlatSpec with Matchers {

  "agregarNota" should "add a new grade to an existing student" in {
    val estudiantes = ListBuffer(
      SistemaEstudiantes.Estudiante("Juan", "A1", List(8.0, 7.5, 9.0))
    )
    SistemaEstudiantes.estudiantes.clear()  // Limpiar el estado compartido antes del test
    SistemaEstudiantes.estudiantes ++= estudiantes
    SistemaEstudiantes.agregarNota("A1", 10.0)
    val calificaciones = SistemaEstudiantes.estudiantes.find(_.id == "A1").get.calificaciones
    calificaciones should contain (10.0)
    calificaciones.length should be (4)
  }

  "mostrarReportes" should "print the correct reports" in {
    val estudiantes = ListBuffer(
      SistemaEstudiantes.Estudiante("Juan", "A1", List(8.0, 7.5, 9.0))
    )
    SistemaEstudiantes.estudiantes.clear()  // Limpiar el estado compartido antes del test
    SistemaEstudiantes.estudiantes ++= estudiantes
    val output = new java.io.ByteArrayOutputStream()
    Console.withOut(output) {
      SistemaEstudiantes.mostrarReportes()
    }
    output.toString should include ("Juan")
    output.toString should include ("Promedio: 8.166666666666666")
  }

  "notaMediaCurso" should "calculate the correct course average" in {
    SistemaEstudiantes.estudiantes.clear()  // Limpiar el estado compartido antes del test
    SistemaEstudiantes.estudiantes ++= ListBuffer(
      SistemaEstudiantes.Estudiante("Juan", "A1", List(8.0, 7.5, 9.0)),
      SistemaEstudiantes.Estudiante("Ana", "A2", List(6.5, 7.0, 8.0)),
      SistemaEstudiantes.Estudiante("Luis", "A3", List(4.0, 5.5, 6.0))
    )
    val average = SistemaEstudiantes.notaMediaCurso()
    average should be (6.83333333333333333 +- 0.1)
  }

  "estudiantesConTutoria" should "identify students who need tutoring" in {
    SistemaEstudiantes.estudiantes.clear()  // Limpiar el estado compartido antes del test
    SistemaEstudiantes.estudiantes ++= ListBuffer(
      SistemaEstudiantes.Estudiante("Luis", "A3", List(1.0, 5.5, 6.0))
    )
    val output = new java.io.ByteArrayOutputStream()
    Console.withOut(output) {
      SistemaEstudiantes.estudiantesConTutoria()
    }
    output.toString should include ("Luis")
  }
}

```

## Cómo ejecutar los test

### Requisitos

- JDK 18
- SBT
- Scala 2.13 o superior

### En la terminal

1. Navegar al directorio de trabajo:

   ```bash
   cd temas/lambdas/scala
   ```

2. Ejecutar los tests con SBT:

   ```bash
   sbt test
   ```

## Ejecución de ejemplos aplicación de terminal

1. Navegar al directorio de trabajo:

   ```bash
   cd temas/lambdas/scala
   ```

2. Compilar y ejecutar con SBT:

   ```bash
   sbt run
   ```

3. La aplicación de terminal mostrará las transformaciones y el uso de las funciones lambda dentro del contexto del código Scala.