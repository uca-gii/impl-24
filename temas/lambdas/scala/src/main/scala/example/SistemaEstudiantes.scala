package scala.example

import scala.io.StdIn.readLine
import scala.collection.mutable
import sys.process._

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
