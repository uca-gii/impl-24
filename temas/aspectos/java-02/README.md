# Aspectos en Java

Este directorio contiene ejemplos de cómo usar aspectos en Java.

## Estructura del Directorio

- [`app/`](app/): Contiene el frontend y el backend implementado en JavaScript.
- [`src/main/java`](src/main/java): Contiene el código de ejemplo en Java.
- [`src/test/java`](src/test/java): Contiene los tests para el código de ejemplo en Java.
- [`pom.xml`](pom.xml): Define la configuración del proyecto, incluidos los plugins de Maven y las configuraciones de build específicas necesarias para compilar, testear y ejecutar el código de Java.

## Explicación teórica

Los aspectos en Java son una herramienta poderosa para la programación orientada a aspectos (AOP), que permite separar las preocupaciones transversales del código principal de la aplicación. Esto mejora la modularidad y facilita el mantenimiento y la evolución del código. 

A continuación, se ofrece una explicación detallada de los componentes principales asociados con los aspectos en Java.

### `@Aspect`

Un aspecto en Java se define utilizando la anotación **@Aspect** de la biblioteca AspectJ. Un aspecto encapsula comportamientos que afectan múltiples clases en un módulo separado.

```java
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
    // definiciones de pointcuts y advices
}
```

En este ejemplo, **LoggingAspect** es un aspecto que contendrá la lógica para los pointcuts y advices.

### `@Pointcut`

La anotación **@Pointcut** se utiliza para definir expresiones que seleccionan uno o más métodos donde se aplicará el consejo. Estas expresiones definen los puntos de ejecución en la aplicación donde se quiere agregar comportamiento adicional.

```java
import org.aspectj.lang.annotation.Pointcut;

@Pointcut("execution(* example.*.*(..))")
public void allMethodsInExample() {}
```

Aquí, **allMethodsInExample** es un pointcut que selecciona todos los métodos en el paquete `example`.

### `@Before`, `@After`, `@Around`, `@AfterReturning`, `@AfterThrowing`

Estas anotaciones definen los diferentes tipos de consejos que se pueden aplicar en los pointcuts.

#### `@Before`

El consejo **@Before** se ejecuta antes del método seleccionado por el pointcut.

```java
import org.aspectj.lang.annotation.Before;

@Before("allMethodsInExample()")
public void logBefore() {
    System.out.println("Method execution started.");
}
```

#### `@After`

El consejo **@After** se ejecuta después del método seleccionado por el pointcut.

```java
import org.aspectj.lang.annotation.After;

@After("allMethodsInExample()")
public void logAfter() {
    System.out.println("Method execution finished.");
}
```

#### `@Around`

El consejo **@Around** envuelve la ejecución del método seleccionado, permitiendo ejecutar lógica antes y después del método.

```java
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

@Around("allMethodsInExample()")
public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Method execution started.");
    Object result = joinPoint.proceed();
    System.out.println("Method execution finished.");
    return result;
}
```

#### `@AfterReturning`

El consejo **@AfterReturning** se ejecuta después de que el método seleccionado complete su ejecución de manera exitosa.

```java
import org.aspectj.lang.annotation.AfterReturning;

@AfterReturning(pointcut = "allMethodsInExample()", returning = "result")
public void logAfterReturning(Object result) {
    System.out.println("Method returned: " + result);
}
```

#### `@AfterThrowing`

El consejo **@AfterThrowing** se ejecuta si el método seleccionado lanza una excepción.

```java
import org.aspectj.lang.annotation.AfterThrowing;

@AfterThrowing(pointcut = "allMethodsInExample()", throwing = "error")
public void logAfterThrowing(Throwable error) {
    System.out.println("Method threw: " + error);
}
```

## Contenido

### Código de ejemplos

Entre los códigos de ejemplo se encuentra la aplicación de terminal que se usó en el tema errores en Scala, pero esta vez traducida a java (véase [`tema/errores/scala`](../../errores/scala/)).

#### [`LogAspect.java`](src/main/java/example/LogAspect.java)

En este .java se encuentra el aspecto que se encarga de crear los logs de la aplicación.

```java

@Aspect
public class LogAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // Pointcut para agregar vuelo
    @Pointcut("execution(* example.SistemaReservaVuelos.agregarVuelo(String, int)) && args(codigo, asientos)")
    public void addFlight(String codigo, int asientos) {}

    // AfterReturning advice para agregar vuelo
    @AfterReturning(pointcut = "addFlight(codigo, asientos)", returning = "result")
    public void afterAddFlight(String codigo, int asientos, String result) {
        if (result.startsWith("Vuelo ")) {
            logger.info("El Admin ha añadido el vuelo {} con {} asientos", codigo, asientos);
        } else {
            logger.warn("Intento fallido de agregar vuelo {}: {}", codigo, result);
        }
    }

    // Pointcut para reservar vuelo
    @Pointcut("execution(* example.SistemaReservaVuelos.reservarVuelo(String, String)) && args(numeroVuelo, nombrePasajero)")
    public void reserveFlight(String numeroVuelo, String nombrePasajero) {}

    // AfterReturning advice para reservar vuelo
    @AfterReturning(pointcut = "reserveFlight(numeroVuelo, nombrePasajero)", returning = "result")
    public void afterReserveFlight(String numeroVuelo, String nombrePasajero, String result) {
        if (result.equals("Reserva realizada exitosamente.")) {
            logger.info("El pasajero {} ha reservado el vuelo {}", nombrePasajero, numeroVuelo);
        } else {
            logger.warn("Intento fallido de {} de reservar vuelo: {}", nombrePasajero, result);
        }
    }

    // Pointcut para cancelar reserva
    @Pointcut("execution(* example.SistemaReservaVuelos.cancelarReserva(example.Reserva)) && args(reserva)")
    public void cancelReservation(Reserva reserva) {}

    // AfterReturning advice para cancelar reserva
    @AfterReturning(pointcut = "cancelReservation(reserva)", returning = "result")
    public void afterCancelReservation(Reserva reserva, String result) {
        if (result.equals("Reserva cancelada exitosamente.")) {
            logger.info("La reserva del pasajero {} para el vuelo {} ha sido cancelada", reserva.getNombrePasajero(), reserva.getNumeroVuelo());
        } else {
            logger.warn("Intento fallido de de cancelar reserva: {}", result);
        }
    }

    // Pointcut para eliminar vuelo
    @Pointcut("execution(* example.SistemaReservaVuelos.eliminarVuelo(String)) && args(numeroVuelo)")
    public void deleteFlight(String numeroVuelo) {}

    // AfterReturning advice para eliminar vuelo
    @AfterReturning(pointcut = "deleteFlight(numeroVuelo)", returning = "result")
    public void afterDeleteFlight(String numeroVuelo, String result) {
        if (result.equals("Vuelo " + numeroVuelo + " eliminado exitosamente.")) {
            logger.info("El vuelo {} ha sido eliminado", numeroVuelo);
        } else {
            logger.warn("Intento fallido de eliminar vuelo: {}", result);
        }
    }

    // Pointcut para login de administrador
    @Pointcut("execution(* example.Menus.menuAdministrador())")
    public void loginAdmin() {}

    @Before("loginAdmin()")
    public void beforeloginAdmin() {
        logger.info("El Admin ha iniciado sesión");
    }

    @After("loginAdmin()")
    public void afterloginAdmin() {
        logger.info("El Admin ha cerrado sesión");
    }

    // Pointcut para login de cliente
    @Pointcut("execution(* example.Menus.menuCliente())")
    public void loginClient() {}

    @Before("loginClient()")
    public void beforeloginClient() {
        logger.info("El Cliente ha iniciado sesión");
    }

    @After("loginClient()")
    public void afterloginClient() {
        logger.info("El Cliente ha cerrado sesión");
    }
}
```

#### [`logback.xml`](src/main/resources/logback.xml)

En este .xml se configura logback para la creación de logs durante la ejecución de la aplicación. Se define además una política de rotación para que los logs solo duren 30 días en el dispositivo.

```xml
<configuration>
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>logs/app.log</file> 
        <append>true</append>
        <encoder>
            <pattern>%date{yyyy-MM-dd HH:mm:ss} - %msg%n</pattern>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>logs/app.%d{yyyy-MM-dd}.log</fileNamePattern> 
            <maxHistory>30</maxHistory>
        </rollingPolicy>
    </appender>

    <root level="INFO">
        <appender-ref ref="FILE" />
    </root>
</configuration>

```

### Código Tests

Para los tests, se usan test unitarios para la aplicación.

#### [`SistemaReservaVuelosTest.java`](src/test/java/example/SistemaReservaVuelosTest.java)

```java
public class SistemaReservaVuelosTest {

    @Before
    public void setup() {
        SistemaReservaVuelos.reset();
    }

    @Test
    public void testAgregarVueloExitosamente() {
        String resultado = SistemaReservaVuelos.agregarVuelo("AV123", 100);
        assertEquals("Vuelo AV123 agregado exitosamente con 100 asientos.", resultado);
    }

    @Test
    public void testAgregarVueloExistente() {
        SistemaReservaVuelos.agregarVuelo("AV123", 100);
        String resultado = SistemaReservaVuelos.agregarVuelo("AV123", 100);
        assertEquals("El vuelo ya existe.", resultado);
    }

    @Test
    public void testAgregarVueloInvalido() {
        String resultado1 = SistemaReservaVuelos.agregarVuelo("", 100);
        assertEquals("Detalles del vuelo inválidos.", resultado1);

        String resultado2 = SistemaReservaVuelos.agregarVuelo("AV124", -5);
        assertEquals("Detalles del vuelo inválidos.", resultado2);
    }

    @Test
    public void testReservarVueloExitosamente() {
        SistemaReservaVuelos.agregarVuelo("AV123", 100);
        String resultado = SistemaReservaVuelos.reservarVuelo("AV123", "Juan Perez");
        assertEquals("Reserva realizada exitosamente.", resultado);
    }

    @Test
    public void testReservarVueloNoExistente() {
        String resultado = SistemaReservaVuelos.reservarVuelo("AV999", "Juan Perez");
        assertEquals("Vuelo AV999 no encontrado.", resultado);
    }

    @Test
    public void testReservarVueloSinAsientosDisponibles() {
        SistemaReservaVuelos.agregarVuelo("AV123", 1);
        SistemaReservaVuelos.reservarVuelo("AV123", "Juan Perez");
        String resultado = SistemaReservaVuelos.reservarVuelo("AV123", "Maria Lopez");
        assertEquals("No hay asientos disponibles en el vuelo AV123.", resultado);
    }

    @Test
    public void testCancelarReservaExitosamente() {
        SistemaReservaVuelos.agregarVuelo("AV123", 100);
        SistemaReservaVuelos.reservarVuelo("AV123", "Juan Perez");
        Reserva reserva = new Reserva("AV123", "Juan Perez");
        String resultado = SistemaReservaVuelos.cancelarReserva(reserva);
        assertEquals("Reserva cancelada exitosamente.", resultado);
    }

    @Test
    public void testCancelarReservaInexistente() {
        SistemaReservaVuelos.agregarVuelo("AV123", 100);
        Reserva reserva = new Reserva("AV123", "Juan Perez");
        String resultado = SistemaReservaVuelos.cancelarReserva(reserva);
        assertEquals("No existe tal reserva.", resultado);
    }

    @Test
    public void testCancelarReservaVueloNoExistente() {
        Reserva reserva = new Reserva("AV999", "Juan Perez");
        String resultado = SistemaReservaVuelos.cancelarReserva(reserva);
        assertEquals("Vuelo no encontrado.", resultado);
    }

    @Test
    public void testEliminarVueloExitosamente() {
        SistemaReservaVuelos.agregarVuelo("AV123", 100);
        String resultado = SistemaReservaVuelos.eliminarVuelo("AV123");
        assertEquals("Vuelo AV123 eliminado exitosamente.", resultado);
    }

    @Test
    public void testEliminarVueloConReservas() {
        SistemaReservaVuelos.agregarVuelo("AV123", 100);
        SistemaReservaVuelos.reservarVuelo("AV123", "Juan Perez");
        String resultado = SistemaReservaVuelos.eliminarVuelo("AV123");
        assertEquals("No se puede eliminar el vuelo con reservas activas.", resultado);
    }

    @Test
    public void testEliminarVueloNoExistente() {
        String resultado = SistemaReservaVuelos.eliminarVuelo("AV999");
        assertEquals("Vuelo no encontrado.", resultado);
    }
}

```

#### [`logback-test.xml`](src/test/resources/logback-test.xml)

Este .xml contiene la configuración necesaria para los logs durante la ejecución de test. Solo se añadirán logs si hay algún error durante los tests.

```xml
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="ERROR">
        <appender-ref ref="STDOUT" />
    </root>
</configuration>

```

### Cómo ejecutar los tests

### Requisitos

- JDK 18
- Maven

### Ejecución simple desde terminal

1. Nos movemos al directorio de trabajo en caso de no estar ya en él:

    ```bash
    cd temas/aspectos/java-02
    ```

2. Ejecutamos los tests con Maven:

    ```bash
    mvn clean test 
    ```

Tras seguir los pasos anteriores, podrás visualizar en la terminal los resultados de los tests.

## Ejecución de ejemplos con aplicación de consola

1. Compila y ejecuta la aplicación de consola:

    ```bash
    cd temas/aspectos/java-02
    mvn compile
    mvn exec:java
    ```

2. Observa como se crea la carpeta logs.

3. Interactúa con la aplicación para ver los aspectos en acción. Observa como se van añadiendo logs en `logs/app.log`
