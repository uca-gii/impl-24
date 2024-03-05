# Prácticas de Implementación 2024

Las prácticas de implementación consisten en construir y realizar un ejemplo de cada tema estudiado en la teoría de la asigatura, tanto para la parte de **implementación** como la de prácticas de **DevOps**.

La implementación se realizará en un **lenguaje a elegir** por los estudiantes. No es obligatorio elegir un mismo lenguaje para los ejemplos de todos los temas, pudiendo variar el lenguaje elegido de un tema a otro. 

El lenguaje elegido solo podrá ser Java o C++ para los temas del [bloque B](#bloque-b-dependencias). Para los bloques [A](#bloque-a-objetos) y [C](#bloque-c-streams) se deberán elegir cualquier lenguaje de los propuestos que no sea Java o C++.

Los ejemplos a construir serán similares a los estudiados en teoría, u otros alternativos propuestos por cada estudiante. La elección del ejemplo de un tema no excluye utilizar elementos de otros temas, aunque se intentará centrar cada ejemplo, sobre todo, en elementos de construcción propios del tema elegido. Por ejemplo, en el ejemplo para el tema de _herencia_ se pueden usar elementos de _encapsulación_, pero, en todo caso, el ejemplo se deberá centrar en ilustrar el buen uso de la _herencia_ en el lenguaje elegido.

Cada práctica puede hacerse en **equipos de 2 personas**. Se valorará el trabajo colaborativo de los miembros de cada equipo y el seguimiento de buenas prácticas de DevOps, CI/CD e IaC estudiadas en clase de teoría y puestas en práctica en las prácticas anteriores de DevOps. También se valorará el trabajo de cada uno de los miembros del grupo de forma individual, en función de sus contribuciones al repositorio compartido para desarrollar cada uno de los ejemplos.

## Procedimiento

Para realizar la práctica se deberán completar los siguientes pasos:

### 1. **Preparación**

   En primer lugar, se debe hacer un **_fork_** del repositorio donde se publica este enunciado (que, a partir de entonces, actuará como _origin_). Todos los miembros del equipo trabajarán colaborativamente sobre dicho fork.

   A continuación, se notificará al profesor los nombres de los miembros del equipo y el/los lenguajes ejegido(s). Para ello se debe hacer una [solicitud de extracción](https://docs.github.com/es/github/collaborating-with-issues-and-pull-requests/about-pull-requests) o [pull request](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/about-pull-requests) (PR) sobre el repositorio _origin_, que contenga los cambios efectuados en el forkeado.

   El PR de notificación **solo** debe añadir o modificar contenido del fichero [authors](authors.md) situado en el repo original. En dicho fichero se deben especificar los nombres de los autores y el lenguaje de implementación elegido para cada tema, usando el formato ilustrado en el fichero.

   El fichero [authors](authors.md) contiene una tabla en markdown con los nombres de los estudiantes propuestos para cada presentación. No debe modificarse la estructura de este fichero más allá de añadir una línea describiendo la elección de los miembros del equipo.

   A modo de ejemplo, el PR incluirá líneas adicionales al fichero [authors](authors.md) como la siguiente:

| Curso | AUTORES  | Encapsulación | Herencia | Delegación  | Inyección  | Anotaciones | Aspectos | Errores | Lambdas |
|---|:---|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| 2023-24 <br/> <br/>| [Español Español, Juan](https://github.com/juanespanol) <br/> [Española Española, María](https://github.com/mariaespanola) |  [TypeScript](temas/encapsulacion/typescript/)  | [TypeScript](temas/herencia/typescript/)  | [Python](temas/delegacion/typescript/) | [Scala](temas/inyeccion/scala/) | [...](temas/anotaciones/lenguaje) | [](temas/aspectos/lenguaje) | [](temas/errores/lenguaje) | [](temas/lambdas/lenguaje) |

   El PR inicial de propuesta solo debe modificar el fichero [authors](authors.md) y ningún otro fichero del repositorio.

   Se primará que haya diversidad en los lenguajes de implementación elegidos por distintos equipos. En caso de que varios equipos hagan una misma elección de lenguaje para los ejemplos propuestos, el profesor decidirá aceptar cada PR en función del orden en que lleguen los mismos y rechazar los demás proponiendo cambios a la elección (_change requests_).

   Podrá suponer el rechazo del PR por parte del profesor si dicho PR contiene:

   - Cualquier contenido no válido del fichero [authors](authors.md).
   - Que fichero [authors](authors.md) con las modificaciones propuestas no esté situado en su carpeta correcta dentro del repositorio.
   - Que se intente modificar cualquier otro contenido del repositorio distinto del fichero [authors](authors.md).
   - Cualquier otra modificación que altere la estructura del repositorio y de sus carpetas.

   En caso de rechazo del PR, los autores tendrán que emitir otro PR para notificar su elección. El nuevo PR se situará por detrás de todos los PRs que hayan llegado hasta entonces.

   Recordar hacer una petición de `git pull` para sincronizar el repositorio local antes de hacer cada nuevo PR.

   Los miembros de un mismo equipo deben proponer un único PR para modificar el fichero [authors](authors.md).

### 2. **Propuesta de ejemplos de cada tema**

   Inicialmente se propondrá un conjunto de ejemplos a implementar con el/los lenguaje(s) de implementación elegido(s).

   Los ejemplos serán similares a los estudiados en teoría, o bien originales a propuesta de los estudiantes. Si a lo largo de la práctica se desea cambiar el lenguaje ejegido para algún ejemplo, deberá proponerse con un nuevo PR repitiendo el paso 1.

### 3. **Organización de carpetas**

   Una vez se haya aceptado el PR inicial de elección de temas, el equipo podrá proceder con la implementación y construcción de los ejemplos elegidos.

   Los ejemplos a entregar se ubicarán, en todos los casos, bajo la carpeta [temas](temas/) del repositorio forkeado.

   Los nombres permitidos para las carpetas a situar bajo `temas/` son:
     - `encapsulacion`
     - `herencia`
     - `delegacion`
     - `inyeccion`
     - `anotaciones`
     - `aspectos`
     - `errores`
     - `lambdas`

   Dentro de cada una de estas carpetas, cada equipo ubicará sus ejemplos en una subcarpeta con el nombre del lenguaje elegido para ese tema. Se deberá colocar el código y los ficheros necesarios de los ejemplos implementados en una subcarpeta con unos de estos nombres _canónicos_ (o de cualquier otro lenguaje propuesto y aceptado en el PR inicial):
     - `csharp`
     - `javascript`
     - `kotlin`
     - `lua`
     - `python`
     - `ruby`
     - `rust`
     - `scala`
     - `swift`
     - `typescript`

   Por ejemplo, si un equipo desea usar C# para implementar un ejemplo de  _encapsulación_ y _Kotlin_ para implementar un ejemplo de _herencia_, sus entregas deberán estar ubicadas en la siguiente estructura de carpetas:

   `temas/encapsulacion/csharp/`
   `temas/herencia/kotlin/`

   Así con el resto de temas y lenguajes elegidos.

### 4. **Contenido de cada ejemplo**

   Cada ejemplo deberá usar un lenguaje de implementación elegido de entre los siguientes:

   - [C#](https://docs.microsoft.com/en-us/dotnet/csharp/)
   - [Javascript](https://developer.mozilla.org/en-US/docs/Web/javascript)
   - [Kotlin](https://kotlinlang.org/)
   - [Lua](https://www.lua.org/)
   - [Python](https://www.python.org/)
   - [Ruby](https://www.ruby-lang.org/)
   - [Rust](https://www.rust-lang.org/es)
   - [Scala](https://www.scala-lang.org/)
   - [Swift](https://www.swift.org/)
   - [TypeScript](https://www.typescriptlang.org/)
   - Cualquier otro lenguaje que tenga un mecanismo útil de implementación para el tema en cuestión y el ejemplo propuesto y que se haya aceptado en el PR inicial.

   Se deberá implementar cada ejemplo empleando los mecanismos específicos del lenguaje elegido. Cada ejemplo deberá construirse usando las herramientas de construcción y gestión de dependencias y bibliotecas, propias del lenguaje. 
   
   Por ejemplo, al igual que en Java se usa _maven_ o _gradle_, en Python se debe usar _pip_, _pybuilder_, etc; en Javascript se debe usar _npm_ o _yarn_, etc.

   - El repositorio principal debe incluir un `README.md` que enlace a cada uno de los ejemplos/temas implementados
   - Un fichero `README.md` como punto de partida de una explicación escrita en [markdown](https://en.wikipedia.org/wiki/Markdown) y las instrucciones sobre cómo construir, compilar y ejecutar el ejemplo en el lenguaje elegido.
   - El fichero `README.md` incluirá enlaces a:
     - el código implementado
     - las pruebas construidas
     - los ficheros de configuración propios de la herramienta de construcción utilizada necesarios para compilar y probar el ejemplo. Por ejemplo: `pom.xml` en Java+Maven, `requirements.txt` en Python, etc.
   - Cada ejemplo debe contener el código de, al menos, un programa principal de demostración del ejercicio, junto con las explicaciones correspondientes para construirlo y ejecutarlo.
   - Ubicar todos los ficheros entregados en la subcarpeta `tema/lenguaje_elegido` situada bajo la carpeta `temas` (Por ejemplo: `temas/encapsulacion/csharp/`).
  
   Cada PR final para la entrega, total o parcial, de la práctica no deberá escribir fuera de esas carpetas.

### 5. **Construcción aplicando DevOps**

   La implementación y construcción se realizará colaborativamente entre todos los miembros del equipo y reflejando todos los **cambios** en el repositorio propio, convenientemente forkeado al principio.

   Al finalizar el trabajo, o cuando se decida que hay ejemplos ya completos y se desee revisarlos, hay que hacer un PR para su **integración** en el repositorio _origin_.

   En caso de **colisiones** en el PR final (por ejemplo, en los nombres de las carpetas que contienen los ejemplos), se rechazará el PR. Entonces se deberá hacer un nuevo PR que resuelva los conflictos añadiendo un sufijo numérico en el nombre de cada carpeta final que contiene todo lo entregado.

   Por ejemplo, si hay tres equipos que usan _kotlin_ para implementar su ejemplo de _herencia_, los dos equipos que hagan el PR final más tarde tendrán que retocar la estructura de carpetas:

   `temas/herencia/kotlin/` (donde entregó el primer equipo)
   `temas/herencia/kotlin-01/` (donde entrega el segundo equipo)
   `temas/herencia/kotlin-02/` (donde entrega el tercer equipo)

   Se valorará:

   - El uso de **ramas** para estructurar el trabajo en el repositorio forkeado, siguiendo el workflow más adecuado para cada caso.
   - La estructura y contenido del repositorio para cada ejemplo, acorde con las normas básicas descritas y con las buenas prácticas del lenguaje y la herramienta de construcción elegida.
   - La satisfacción de las **peticiones de cambio** (_change requests_) que el profesor haga para la corrección de los PR que lo requieran.
   - Minimizar el **número de PRs** de entrega en respuesta a correcciones solicitadas por el profesor, sin necesidad de excesivas re-entregas.
   - La redacción y organización de las **instrucciones** en los documentos markdown del repositorio, incluyendo títulos de apartados, explicaciones, alcanzabilidad desde el README.md de cualquier fichero entregado.
   - El respeto a los **formatos** empleados para la entrega (markdown, código, imágenes, tablas, etc.)
   - La **legibilidad** y estética de la documentación markdown entregada (capturas de pantallas, tamaño de imágenes, listados de código, etc.)
   - Explicación de las instrucciones de instalación y **despliegue** de los ejemplos, siguiendo las buenas prácticas de CI/CD y el empleo de herramientas de IaC.
   - La definición de **pipelines** de CI/CD (y puesta en práctica de las herramientas de IaC) para automatizar la construcción y prueba de los ejemplos entregados.
   - La correcta **compilación** y **ejecución** de los ejemplos implementados.

### 6. **Entrega en el Campus Virtual**

   La entrega final oficial de cara a plazos establecidos para la práctica se hará en el campus virtual. La entrega será la realizada a través de la actividad correspondiente en el campus virtual, indicando en la entrega la URL de vuestro repositorio.

   Antes de la entrega final, se deberá hacer completado el PR final del paso 5 para integrar en el repositorio _origin_ todos los cambios hechos en el repositorio forkeado.

   Se valorará:

   - El respeto del **protocolo** definido, basado en sucesivos PR, para elegir los componentes del equipo y los lenguajes de implementación.
   - El seguimiento de las **normas** de entrega final y para proponer cualquier corrección a lo entregado utilizando PRs adicionales.
   - La **entrega final** con PR en el repositorio _origin_ de lo realizado por el equipo en el repositorio forkeado.
   - La actividad en el repositorio forkeado que refleje la colaboración entre los miembros de cada equipo, a través de **issues** y **commits** en los que hayan participado todos los miembros.

### 7. **Presentación oral**

   Finalmente, se hará una presentación de los ejemplos entregados para una selección de temas. Solo habrá que elegir _un tema de cada bloque (A, B y C)_, es decir, cada equipo presentará oralmente solo _3 temas_.

   La presentación se hará en clase tras pedir fecha y hora al profesor a través de la actividad correspondiente del campus. En casos excepcionales, se podrá grabar un video explicativo de menos de 8 minutos con la presentación y entregarlo a través del campus virtual. No obstante, en esta segunda opción no se podrá valorar la defensa de lo presentado, lo que podrá ser tenido en cuenta en la evaluación.

   Se valorará:

   - El material diseñado para la presentación oral
   - La presentación oral realizada
   - La inclusión de una demo funcional de los ejemplos presentados
   - La defensa que se haga de lo presentado

## Temas

### Bloque A. Objetos

#### A.1. Encapsulación

Implementar un ejemplo equivalente al ejemplo final de [Recorrido de listas](http://dodero.github.io/iiss/iiss-oop-1/#implementacion-alternativa-lista-v04) usando los mecanismos del lenguaje para definición de tipos de datos, ocultación de la implementación, aplicación del principio de acceso uniforme y especificación de la inmutabilidad del estado de un objeto. Por ejemplo:

- En Ruby, se podrían usar `:symbols`, `module`, `@variables` de instancia, `attr_accessor`, `attr_reader`, `attr_writer`, etc.
- En Scala, se podrían usar modificadores de visibilidad (`private`, `protected`), `var`, `val`, `type`, `abstract`, `sealed`, etc.
- En C#, se podrían usar modificadores de visibilidad y _properties_ `get`,`set` e `init`, etc.

#### A.2. Herencia

Implementar un ejemplo equivalente al de [Aventura](http://dodero.github.io/iiss/iiss-oop-1/#ejemplo-aventura-v01) usando los mecanismos de herencia y polimorfismo de inclusión que proporcione el lenguaje. Por ejemplo:

- En Scala, podría usarse el mecanismo básico de herencia (`extends`), mixins (`traits`), `with`, etc.
- En C#, se podrían usar el mecanismo básico de herencia, `interface`, `base`, `override`, `virtual`, `new`, etc.

#### A.3. Delegación

Implementar un ejemplo equivalente al ejemplo final de [Orquesta](http://dodero.github.io/iiss/iiss-oop-2/#implementacion-alternativa-orquesta-v06) usando los mecanismos del lenguaje para la delegación/composición. Intentará evitarse el uso de _lambdas_, que están destinadas a otro bloque. Por ejemplo:

- En C# podrían usarse `delegates`.
- En Scala, podrían usarse _first-class functions_.
- En Ruby, podrían usarse bloques, `proc`, `module` y `delegate`.

### Bloque B. Dependencias

#### B.1. Inyección

 Implementar un ejemplo equivalente al de [BankAccount](http://dodero.github.io/iiss/iiss-oop-3/#ejercicio-identificador-de-bankaccount-con-inyeccion-de-dependencias) y que se puedan definir diversos atributos para comparar cuentas, usando los mecanismos del lenguage para inyectar como dependencia el criterio de comparación. Por ejemplo:

- En Java, puede usarse el framework [Guice](https://github.com/google/guice/wiki/) o [Weld CDI](http://weld.cdi-spec.org/)
- En Scala, puede usarse el framework [Play](https://www.playframework.com/) que implementa la inyección de dependencias [en tiempo de compilación](https://www.playframework.com/documentation/2.8.x/ScalaCompileTimeDependencyInjection).

#### B.2. Anotaciones

Implementar un ejemplo equivalente al de [BankAccount](http://dodero.github.io/iiss/iiss-oop-3/#ejercicio-identificador-de-bankaccount-con-inyeccion-de-dependencias) con diversos atributos comparables, usando anotaciones a medida para inyectar como dependencia el comparador a usar. Por ejemplo:

- En Java, podrían definirse anotaciones a medida para inyección de dependencias en _runtime_, según el [JSR 330](http://javax-inject.github.io/javax-inject/). Ejemplo: [Creating a Custom Annotation in Java](http://baeldung.com/java-custom-annotation) de Baeldung
- En TypeScript, podrían usarse [_decorators_](https://www.typescriptlang.org/docs/handbook/decorators.html).
- En Scala, puede usarse el framework Play que implementa el [JSR 330](http://javax-inject.github.io/javax-inject/).

#### B.3. Aspectos

Implementar usando aspectos el ejemplo del caso [Editor de Figuras](http://dodero.github.io/iiss/iiss-aop/#caso-5-editor-de-figuras) (o un ejemplo equivalente). Por ejemplo:

- En Java, usar intercepción de métodos con [Guice](https://github.com/google/guice/wiki/AOP)
- En Python, usar [Spring Python](https://docs.spring.io/spring-python/1.2.x/sphinx/html/aop.html#aspect-oriented-programming)

### Bloque C. Streams

#### C.1. Errores

Implementar un ejemplo equivalente al de _MobileTester_ del apartado [Optionals](http://dodero.github.io/iiss/iiss-err/#optionals) usando los mecanismos del lenguaje para resolver el problema de los valores no definidos (_undefined_) y el mal uso de `null` en el procesamiento de streams. Por ejemplo:

- En Scala, podrían usarse los mecanismos de la biblioteca del lenguaje como `Option`, `Some`, `None`, `Either`, `Left`, `Right`, etc.
- En TypeScript o Javascript, podrán usarse `undefined`.

#### C.2. Lambdas

Implementar ejemplos del uso de funciones anónimas (expresiones _lambda_) para el procesamiento de streams empleando los mecanismos disponibles en el lenguaje elegido. Por ejemplo:

- En Scala, usar [funciones anónimas](https://docs.scala-lang.org/scala3/book/fun-anonymous-functions.html) de Scala 3
- En Ruby, usar `lambda`, `proc` y blocks.
