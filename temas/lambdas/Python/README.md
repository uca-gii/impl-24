## Compilación y ejecución
> python lambda.py

## Explicación

En Python nos encontramos con distintos tipos de funciones anónimas. En ésta práctica me centraré en explicar el uso de lambdas, generators y comprehesions.

### Lambdas
En python las lambdas tienen que escribirse en una sola línea y no podemos escribir en su interior varios *statement*, así como los que se pueden usar están restringidos en cierta medida. Ésta es su sintaxis:

 ```python
 resultado = lambda argument: expresion
 ```
 Cómo podemos ver en el código, en éstas lambdas se puede llamar a funciones y pueden ser pasadas como parámetros.

### Generators

Los generators se parecen mucho a una función cualquiera de python, en lo único en que se diferencian, en aparencia, es que en vez de tener *return* tienen *yield*, y pueden ser más de uno. Su funcionamiento es el siguiente:

>Una función generator devuelve un objeto de tipo generator y es iterable. Al iterar sobre ésta usando la función *next()* o un bucle vamos a ir obteniendo los siguientes *yield* respectivamente, uno a uno.

```python
def generator():
    yield 1
    yield 2
```

En el anterior ejemplo si llamamos una vez a la función *next(generator)* obtendremos un 1, si llamamos una segunda vez, obtendremos un 2.

### Comprehesions

Existen varios tipos de comprehesions, en éste ejercicio muestro cómo se utiliza en listas. Es una herramienta útil a la hora de generar listas que tienen alguna condición rápidamente. Su sintaxis es la siguiente:

>resultante = [a_almacenar for var in lista_Inicial if (condición)]


