## Compilación y ejecución

En este caso vamos a usar spring de nuevo como en la práctica de inyección, así que será igual, manteniendo los archivos dispuestos de la misma maner que están subidos en el repositorio, en el directorio raíz ejecutaremos:

> .\gradlew.bat bootRun

## Explicación

### Spring
Las *beans* de spring ya las he explicado en la práctica de inyección, así que voy a pasar a explicar la parte exclusiva de Spring AOP.

### Spring AOP

#### Set Up
Antes de empezar tenemos que añadir unas dependencias al proyecto, esto lo haremos en el archivo *build.gradle* situado en el directorio raíz del mismo. Las dependencias son las siguientes y nos permitirán trabajar con aspectos:

> implementation 'org.aspectj:aspectjweaver:1.9.7'
>
> implementation 'org.springframework:spring-aop:5.3.10'

#### Archivo de configuración
En el archivo de configuración *applicationContext.xml* especificaremos la siguiente linea:

> <aop:aspectj-autoproxy />

Gracias a ella podremos usar tanto el archivo de configuración como las anotaciones en el código. Tras ello crearemos un *bean* de *MoveTracking* para que spring tenga referencia del aspecto y así poder aplicarlo a la aplicación. El resto del archivo xml es para la inyección de objetos que he aprovechado para realizar los tests.

#### Anotaciones
Todas las anotaciones se encuentran en la clase *MoveTracking*. La primera será **@Aspect** para indicar que dicha clase es un aspecto, la siguiente, encima del método *after* tenemos la anotación:

>  @After("execution(* com.iiss.Line.set*(..)) || execution(* com.iiss.Point.set*(..))")

Con esta anoación indicamos que el método *after* será un advice, de tipo *After*. Esto quiere decir que será lanzado depués de que se llegue a un JoinPoint de los definidos en el Pointcut de dentro del paréntesis, es decir, después de la ejecución de un método **set** de cualesquieras esas dos clases, ya sea *Line*, ya sea *Point*.

### MoveTracking

En ésta clase, a parte de las ya mecionadas anotaciones, se ha modificado el método *after*. Ahora la función recibe un JoinPoint y extraeremos todos los objetos del mismo, entonces, sólo de aquellos que sean un FigureElement serán añadidos al set, tal y cómo en la función originalmetne proporcionada. 

### Test

En *FiguresApplication* tenemos las inyecciones de un objeto *Line* y otro *Point* que se modificarán varias veces para que sea obvio el uso de los aspectos, en el resto de clases se han añadidos varias líneas para imprimir por pantallas mensajes con el mismo objetivo. En el resultado final vemos como se intercalan las llamadas a los métodos set y el método after.