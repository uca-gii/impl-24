package scala.example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

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
