# Delegación en Kotlin

Este directorio contiene ejemplos de cómo implementar el concepto de delegación utilizando Kotlin.

## Estructura del Directorio

- [`app/`](app/): Contiene el frontend y el backend implementado en JavaScript.
- [`src/main/kotlin/example`](src/main/kotlin/example): Contiene el código de ejemplo en kotlin.
- [`src/test/kotlin/example`](src/test/kotlin/example): Contiene los test para el código ejemplo en kotlin.
- [`pom.xml`](pom.xml): Para pasar los test, define la configuración del proyecto, incluidos los plugins de Maven y las configuraciones de build específicas necesarias para compilar, testear y ejecutar el código de Kotlin.
- [`Dockerfile`](Dockerfile): Configuración para Docker.
- [`APP.tf`](APP.tf): Configuración para Terraform.

¡Entiendo! Aquí está la documentación actualizada, incluyendo la sección sobre la delegación sin usar el `by` en Kotlin:

# Delegación en Kotlin

Este directorio contiene ejemplos de cómo implementar el concepto de delegación utilizando Kotlin.

## Estructura del Directorio

- [`app/`](app/): Contiene el frontend y el backend implementado en JavaScript.
- [`src/main/kotlin/example`](src/main/kotlin/example): Contiene el código de ejemplo en kotlin.
- [`src/test/kotlin/example`](src/test/kotlin/example): Contiene los test para el código ejemplo en kotlin.
- [`pom.xml`](pom.xml): Para pasar los test, define la configuración del proyecto, incluidos los plugins de Maven y las configuraciones de build específicas necesarias para compilar, testear y ejecutar el código de Kotlin.
- [`Dockerfile`](Dockerfile): Configuración para Docker.
- [`APP.tf`](APP.tf): Configuración para Terraform.

## Explicación teórica

Antes de entrar en detalle con el contenido del directorio, se va a realizar una breve explicación teórica de los conceptos básicos de delegación con Kotlin.

### `interface`

Una interfaz en Kotlin define un contrato que otras clases pueden implementar. Kotlin no soporta la herencia múltiple de clases, pero permite que una clase implemente múltiples interfaces. Al definir métodos en una interfaz, cualquier clase que implemente esa interfaz debe proporcionar una implementación concreta de esos métodos.

En el contexto de la delegación, una interfaz puede ser vista como una manera de delegar la responsabilidad de implementar sus métodos a las clases que la implementan. Es decir, la interfaz define lo que debe hacerse, y la clase que la implementa define cómo hacerlo.

```kotlin
interface Trabajador {
    val nombre: String
    fun preparar() {
        println("$nombre está preparándose para trabajar.")
    }
    fun trabajar()
}
```

### `uso de by`

El modificador `by` en Kotlin es útil en la implementación de la delegación. Permite delegar la implementación de una interfaz a un objeto diferente. Cuando una clase delega parte de su funcionalidad a otra, el compilador genera automáticamente los métodos definidos en la interfaz y los redirige al delegado.

```kotlin
class Escritor(override val nombre: String): Trabajador {
    override fun trabajar() {
        println("${nombre} está escribiendo un informe.")
    }
}

class Secretario(trabajador: Trabajador) : Trabajador by trabajador
```

En este ejemplo, `Secretario` no necesita implementar `trabajar` porque delega su implementación a la instancia de `Trabajador` proporcionada.

### Delegación por clase

La delegación por clase se refiere a la implementación manual de la delegación sin utilizar el modificador `by`. Esto implica que una clase puede contener instancias de otras clases y redirigir llamadas a sus métodos a estas instancias. Esto es útil cuando necesitas más control sobre cómo se redirigen los métodos o cuando necesitas combinar funcionalidades de varias clases.

```kotlin
class Escritor(override val nombre: String): Trabajador {
    override fun trabajar() {
        println("${nombre} está escribiendo un informe.")
    }
}

class AtencionAlCliente(override val nombre: String): Trabajador {
    override fun trabajar() {
        println("${nombre} está atendiendo a un cliente.")
    }
}

class Gerente(override val nombre: String): Trabajador {
    private val atencion = AtencionAlCliente(nombre)
    private val escritor = Escritor(nombre)

    override fun preparar() {
        println("${nombre} está preparándose como gerente.")
    }

    override fun trabajar() {
        escritor.trabajar()
        atencion.trabajar()
    }
}
```

En este ejemplo, `Gerente` delega manualmente la implementación de `trabajar` a las instancias de `Escritor` y `AtencionAlCliente`. Aquí, `Gerente` tiene control total sobre el orden y las condiciones bajo las cuales se llaman los métodos delegados.

Esta aproximación permite flexibilidad adicional y es útil cuando la simple delegación con `by` no es suficiente para las necesidades de la lógica de negocio.

## Contenido

### Código ejemplos

Para representar la delegación con Kotlin, se ha decidido representar diferentes miembros de una compañía de programación, incluyendo programadores, escritores, escritores preparados, atención al cliente, gerentes y desarrolladores completos.

[**ProgrammingCompany.kt**](src/main/kotlin/example/ProgrammingCompany.kt)

```kotlin
interface Trabajador {
    val nombre: String

    fun preparar() {
        println("$nombre está preparándose para trabajar.")
    }

    fun trabajar() {}
}

class Programador(override val nombre: String): Trabajador {
    override fun trabajar() {
        println("${nombre} está escribiendo código.")
    }
}

class Escritor(override val nombre: String): Trabajador {
    override fun trabajar() {
        println("${nombre} está escribiendo un informe.")
    }
}

class EscritorPreparado(override val nombre: String): Trabajador by Escritor(nombre) {
    override fun preparar() {
        println("${nombre} ya se preparó antes.")
    }
}

class AtencionAlCliente(override val nombre: String): Trabajador {
    override fun trabajar() {
        println("${nombre} está atendiendo a un cliente.")
    }
}

class Gerente(override val nombre: String): Trabajador {
    private val atencion = AtencionAlCliente(nombre)
    private val escritor = Escritor(nombre)

    override fun trabajar() {
        escritor.trabajar()
        atencion.trabajar()
    }
}

class DesarrolladorCompleto(override val nombre: String): Trabajador {
    private val programador = Programador(nombre)
    private val escritor = Escritor(nombre)
    private val atencion = AtencionAlCliente(nombre)

    override fun trabajar() {
        programador.trabajar()
        escritor.trabajar()
        atencion.trabajar()
    }
}

class Jefe {
    fun prepararTrabajadores(trabajadores: List<Trabajador>) {
        println("El jefe está preparando a los trabajadores.")
        println("--------------------------------------------")
        trabajadores.forEach {
            it.preparar()
        }
        println("--------------------------------------------")
        println("Todos los trabajadores están preparados.")
        println("============================================")
    }

    fun manejarTrabajadores(trabajadores: List<Trabajador>) {
        println("El jefe da la señal para que los trabajadores hagan sus tareas.")
        println("---------------------------------------------------------------------")
        trabajadores.forEach{
            it.trabajar()
        }
        println("---------------------------------------------------------------------")
        println("¡Todos los trabajadores han completado sus tareas!")
    }
}
```

### Descripción de las clases y métodos

#### `interface Trabajador`

- **Propósito**: Definir un contrato para las clases que representarán a los trabajadores de la empresa, incluyendo los métodos que deben implementar.
- **Propiedades**:
  - `val nombre: String`: El nombre del trabajador.
- **Métodos**:
  - `fun preparar()`: Método predeterminado que imprime un mensaje indicando que el trabajador se está preparando.
  - `fun trabajar()`: Método abstracto que debe ser implementado por las clases que heredan de `Trabajador`.

#### `class Programador`

- **Propósito**: Representar a un programador en la empresa.
- **Propiedades**:
  - `override val nombre: String`: El nombre del programador.
- **Métodos**:
  - `override fun trabajar()`: Imprime un mensaje indicando que el programador está escribiendo código.

#### `class Escritor`

- **Propósito**: Representar a un escritor en la empresa.
- **Propiedades**:
  - `override val nombre: String`: El nombre del escritor.
- **Métodos**:
  - `override fun trabajar()`: Imprime un mensaje indicando que el escritor está escribiendo un informe.

#### `class EscritorPreparado`

- **Propósito**: Representar a un escritor que ya se preparó previamente.
- **Propiedades**:
  - `override val nombre: String`: El nombre del escritor.
- **Delegación**: Utiliza la delegación para implementar `Trabajador` a través de `Escritor`.
- **Métodos**:
  - `override fun preparar()`: Sobrescribe el método `preparar` para indicar que el escritor ya se preparó antes.

#### `class AtencionAlCliente`

- **Propósito**: Representar a un trabajador de atención al cliente en la empresa.
- **Propiedades**:
  - `override val nombre: String`: El nombre del trabajador de atención al cliente.
- **Métodos**:
  - `override fun trabajar()`: Imprime un mensaje indicando que el trabajador está atendiendo a un cliente.

#### `class Gerente`

- **Propósito**: Representar a un gerente en la empresa, que combina responsabilidades de escritor y atención al cliente.
- **Propiedades**:
  - `override val nombre: String`: El nombre del gerente.
  - `private val atencion: AtencionAlCliente`: Instancia de `AtencionAlCliente` para delegar la atención al cliente.
  - `private val escritor: Escritor`: Instancia de `Escritor` para delegar la escritura de informes.
- **Métodos**:
  - `override fun trabajar()`: Llama a los métodos `trabajar` de `Escritor` y `AtencionAlCliente` para reflejar las responsabilidades del gerente.

#### `class DesarrolladorCompleto`

- **Propósito**: Representar a un desarrollador que tiene múltiples responsabilidades (programador, escritor y atención al cliente).
- **Propiedades**:
  - `override val nombre: String`: El nombre del desarrollador completo.
  - `private val programador: Programador`: Instancia de `Programador` para delegar la programación.
  - `private val escritor: Escritor`: Instancia de `Escritor` para delegar la escritura de informes.
  - `private val atencion: AtencionAlCliente`: Instancia de `AtencionAlCliente` para delegar la atención al cliente.
- **Métodos**:
  - `override fun trabajar()`: Llama a los métodos `trabajar` de `Programador`, `Escritor` y `AtencionAlCliente` para reflejar todas sus responsabilidades.

#### `class Jefe`

- **Propósito**: Representar al jefe que gestiona a los trabajadores, asegurando que se preparen y trabajen.
- **Propiedades**:
  - Ninguna propiedad específica.
- **Métodos**:
  - `fun prepararTrabajadores(trabajadores: List<Trabajador>)`: Llama al método `preparar` de cada trabajador en la lista proporcionada.
  - `fun manejarTrabajadores(trabajadores: List<Trabajador>)`: Llama al método `trabajar` de cada trabajador en la lista proporcionada.

## Código tests

Para los tests, se ha utilizado Maven y JUnit para gestionar las dependencias y ejecutar las pruebas de forma automatizada, permitiendo una verificación efectiva del comportamiento de cada clase dentro del contexto definido en el código de la aplicación musical.

[**ProgrammingCompanyTests.kt**](src/test/kotlin/example/ProgrammingCompanyTests.kt)

```kt

class ProgrammingCompanyTests {
    private fun captureOutput(work: () -> Unit): String {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        work()
        return outputStream.toString()
    }

    @Test
    fun `Programador trabaja correctamente`() {
        val programador = Programador("Juan")
        val output = captureOutput { programador.trabajar() }
        assertTrue(output.contains("Juan está escribiendo código."))
    }

    @Test
    fun `Escritor trabaja correctamente`() {
        val escritor = Escritor("Ana")
        val output = captureOutput { escritor.trabajar() }
        assertTrue(output.contains("Ana está escribiendo un informe."))
    }

    @Test
    fun `Gerente trabaja correctamente`() {
        val gerente = Gerente("Carlos")
        val output = captureOutput { gerente.trabajar() }
        assertTrue(output.contains("Carlos está escribiendo un informe.") && output.contains("Carlos está atendiendo a un cliente."))
    }

    @Test
    fun `EscritorPreparado se prepara correctamente`() {
        val escritorPreparado = EscritorPreparado("Sofia")
        val output = captureOutput { escritorPreparado.preparar() }
        assertTrue(output.contains("Sofia ya se preparó antes."))
    }

    @Test
    fun `DesarrolladorCompleto trabaja correctamente`() {
        val completo = DesarrolladorCompleto("Luis")
        val output = captureOutput {
            completo.trabajar()
        }
        assertTrue(
            output.contains("Luis está escribiendo código.") &&
            output.contains("Luis está escribiendo un informe.") &&
            output.contains("Luis está atendiendo a un cliente.")
        )
    }

    @Test
    fun `Jefe prepara y maneja trabajadores correctamente`() {
        val trabajadores = listOf(Programador("Juan"), Escritor("Ana"), AtencionAlCliente("Carlos"))
        val jefe = Jefe()
        val output = captureOutput {
            jefe.prepararTrabajadores(trabajadores)
            jefe.manejarTrabajadores(trabajadores)
        }
        assertTrue(output.contains("El jefe está preparando a los trabajadores.") && output.contains("¡Todos los trabajadores han completado sus tareas!"))
    }
}

```

Estos tests verifican que:

- Los métodos **trabajar** de `Programador`, `Escritor`, `Gerente` y `DesarrolladorCompleto` funcionan correctamente.
- El método **preparar** de `EscritorPreparado` se comporta como se espera.
- Los métodos **prepararTrabajadores** y **manejarTrabajadores** de `Jefe` preparan y manejan a los trabajadores correctamente, respectivamente.

## Código APP Web

Para la aplicación web se ha usado Node.js y React, los ficheros que conforman la aplicación son los siguientes:

[**package.json**](app/src/package.json)

Es un archivo de configuración esencial en proyectos que utilizan Node.js y React. Define el nombre, versión, punto de entrada principal del código, scripts para operaciones comunes como iniciar, construir, probar y desplegar la aplicación, así como las dependencias necesarias para el funcionamiento del servidor y la interfaz de usuario. 

[**backend.js**](app/src/backend.js)

Es un script del servidor creado con Node.js que utiliza el framework Express para manejar solicitudes HTTP. Define rutas API para leer y enviar código Kotlin y resultados de pruebas desde archivos específicos, respondiendo con los resultados de la ejecución.

[**App.js**](app/src/App.js)

Es un componente principal en React que gestiona la interfaz de usuario para visualizar y ejecutar código y pruebas de Kotlin mediante llamadas API. El usuario puede introducir nuevos miembros a la banda introduciendo su nombre y rol. Al seleccionar ejecutar se crea un archivo de Kotlin que contiene el main que será ejecutado y lo ejecutará, mostrando el resultado de la ejecución que es una actuación de la banda.

[**index.js**](app/src/index.js)

Es el punto de entrada para la aplicación React, donde se realiza la renderización del componente principal App en el DOM. Utiliza ReactDOM.render para inyectar el componente App dentro del elemento HTML con id root.

[**index.html**](app/public/index.html)

Este sirve como plantilla base para la aplicación React, definiendo el esqueleto HTML sobre el cual React construirá la interfaz de usuario. Contiene un div con id root, que es el punto de montaje para el componente React principal (App) renderizado por index.js.

## Cómo ejecutar los test

### Requisitos

- JDK mínimo: JDK 17
- Compilador de Kotlin para JVM: **`kotlinc-jvm`**
- Docker
- Terraform

### -EJECUCIÓN DE LOS TESTS DESDE TERMINAL-

1. Nos movemos al directorio de trabajo en caso de no estar ya en él:
    ```bash
    cd temas/delegacion/kotlin
    ```
2. Ejecutamos los test con maven:
    ```bash
    mvn clean test 
    ```
   
Tras seguir los dos pasos anteriores podrás visualizar en la terminal los resultados de los tests.

## Ejecución de ejemplos con app web

1. Construye y corre el contenedor Docker con Terraform:

   ```bash
   cd temas/delegacion/kotlin # Nos movemos al directorio de trabajo
   terraform init # Iniciamos terraform
   terraform apply # Lanzamos el docker
   ```
2. Accede desde tu navegador a la dirección localhost:3300

3. Introduce tantos trabajadores a la compañía como quieras seleccionando un nombre y un rol.

4. Para introducir más trabajadores pulse el botón "Añadir más"

5. Cuando haya terminado de añadir miembros, pulse "Ejecutar" y tras unos segundos verá el resultado del trabajo en la pantalla.

6. Cuando haya terminado para evitar gasto de recursos innecesarios no olvide ejecutar la siguiente orden en el directorio de trabajo desde terminal:

```bash
terraform destroy
```
Esto eliminará el docker que se levantó.