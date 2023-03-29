## Compilación y ejecución

No hay que hacer nada especial para ejecutar el programa, simplemente tener instalada la jdk de java y en el directorio del programa ejecutar:
> javac BankAccountTest.java
> java BankAccountTest

## Explicación

Los ficheros *BankAccountComparatorByCreationDate.java* y *BankAccountComparatorByID.java* son los proporcionados sin ningún cambio, el resto se explican a continuación:

### Uso de anotaciones
En java el uso de las anotaciones es bastante sencillo, simplemente hay que poner el nombre de la anotación con un *@* delante de lo que queramos anotar:

```java
    @MiAnotacion
    int atributo;
```

### BankAccount
>En el fichero BankAccounto proporcionado ya hacía uso de la anotación *@override* que proporciona java, en cambio, para la realización de la práctica he anotado el atributo *comparator*, *creationDate* y el método *setComparator* con las distintas anotaciones personalizadas que he creado. 

### Creación de anotaciones
Para la implementación de este ejemplo he hecho uso de tres anotaciones, *@LocalDateNow*, *@CompareById* y *@CompareByDate*.

Si miramos de cerca *@LocalDateNow* podemos ver la linea:

>@Retention(RetentionPolicy.RUNTIME)

Con ella indicamos a java que mantenga el código en tiempo de ejecución para conseguir que otro código en ejecución pueda leer la anotación y usarla mientras el programa está ejecutándose.

>@Target(ElementType.FIELD)

Con ésta línea sencillamente estámos indicando que la anotación sólo va a poder usarse en atributos de la clase, es por ello que no la vamos a usar en el método *setCreationDate*, tendríamos un error. Si miramos las otras dos anotaciónes nos podemos dar cuenta que en este campo indicamos también el valor *ElementType.METHOD*, indicando que podamos, ésta vez si, utilizarla sobre métodos. Podríamos usar más opciones como que se puedan usar en clases pero se escapan del objetivo de éste ejemplo.

La anotación no tiene nada más, de nuevo, podríamos ponerle atributos (básicos) pero son funcionalidades que no necesitamos, el comportamiento de las anotaciones las definimos a continuación.

### Inyección mediante anotaciones
Para ello hemos creado la clase *DependencyInjector* con dos métodos que le darán uso a las anotaciones. El primer método, *injectField*, al igual que el segundo, hará uso de la reflexión de java.

>La reflexión de java es una API que nos va a permitir examinir y modificar el comportamiento de las clases y sus métodos y atributos.

Siguiendo con *injectField* vemos que se queda con la clase del objeto que recibe y tras ello hace uso de la reflexión para iterar por todos sus atributos y comprobará si tiene alguna de las anotaciones que hemos definido. En este caso, si algún atributo tuviera alguna, inyectaremos un objeto de la clase deseada, no sin antes hacer dicho método accesible, porque, al menos en este caso, los atributos que tendrán ésta anotación serán privados. Con ésto último tenemos que tener cuidado pues rompe con la encapsulación proporcionada por java pero que en este caso, en la inyección de dependencias, nos es útil.

El siguiente método, *injectMethod*, tiene un comportamiento muy parecido sólo que itera por los métodos y no comprobamos si tiene la anotación *@LocalDateNow* pues sabemos que sólo es para atributos. Una vez encuentra una anotación invoca al método con los parámetros necesarios (un nuevo objeto comparador).