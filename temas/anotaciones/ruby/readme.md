# Anotaciones en Java
Las anotaciones en Java permiten que los metadatos se escriban directamente en el código fuente. Estos metadatos 
proporcionan información sobre los elementos del código. 

Estas anotaciones necesitan de un programa que las recupere y las utilice para así proporcionar alguna
utilidad adicional a nuestro programa.

En Java, una anotación se implementa como una interfaz especial, utilizando la siguiente nomenclatura:
```java
public @interface Anotacion{}
```
Para que Java entienda cómo y dónde utilizar esta anotación, es necesario especificar 
ciertas directivas obligatorias:

- `@Retention`. especifica cuánto tiempo debe conservarse la anotación. Si queremos
  que la anotación esté disponible en tiempo de ejecución, se debe utilizar
  `RetentionPolicy.RUNTIME`.
- `@Target`. Esta anotación especifica sobre qué elementos del código se puede aplicar la anotación.

Por ejemplo, si queremos que nuestra anotación esté disponible en tiempo de ejecución y 
solo pueda ser aplicada a atributos, debemos definir nuestra anotación de la siguiente manera:

```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Anotacion{}
```
Una vez definida la anotación, podemos incluir métodos y propiedades 
dentro de ella para completar su funcionalidad.

## Ejemplo: BankAccount

Para ilustrar cómo utilizar anotaciones en Java, presentamos el ejemplo de `BankAccount`. 
En este caso, la anotación `@CompareAnnotation` se utiliza para realizar una inyección 
de dependencias desde la clase `BankAccountComparatorById` hacia la clase `BankAccount`, 
instanciando el método `comparator`.

1. [`BankAccount.java`](temas/anotaciones/ruby/BankAccount/src/main/java/uca/iiss/BankAccount.java). Esta clase representa una cuenta bancaria e incluye la anotación `@CompareAnnotation` que
   especifica cómo comparar instancias de esta clase.
    
3. [`BankAccountComparatorById.java`](temas/anotaciones/ruby/BankAccount/src/main/java/uca/iiss/BankAccountComparatorById.java). Esta clase implementa un comparador para ordenar instancias de `BankAccount`
   por su identificador.
     
4. [`CompareAnnotation.java`](temas/anotaciones/ruby/BankAccount/src/main/java/uca/iiss/CompareAnnotation.java). Define la anotación `@CompareAnnotation`.
     ```java
      @Retention(RetentionPolicy.RUNTIME) // tiempo que está presente en la compilacion
      @Target(ElementType.TYPE) // elementos a los que se aplica
      public @interface CompareAnnotation {
          Class<? extends Comparator<BankAccount>> compare();
      }
    ```
5. [`BankAccountSort.java`](temas/anotaciones/ruby/BankAccount/src/main/java/uca/iiss/BankAccountSort.java). Finalmente, el método `sort()` de esta clase se deberá ordenar siguiendo el `id`
dada la anotación anterior
