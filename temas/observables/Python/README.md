## Compilación y ejecución
Primero vamos a descargar el módulo de ractiveX:
> pip3 install reactivex
Después ejecutaremos cada fichero como cualquier programa de python:
> python nombreFichero.py

## Explicación
En los siguientes archivos se van a explicar varias funcionalidades que ofrece *reactiveX* en python. Comenzaremos con la creación de un método observable y otro suscriptor.
### Observable - Suscriptor
En *Observable_Suscriptor.py* vamos a crear un observable a partir de un método que recibe un observador y lo vamos a aprovechar **on_next** para emitir los distintos valores y **on_completed** para indicar que ha finalizado.

>- **on_next** se va a ejecutar siempre que el observable emita nuevos valores. 
>
>- La función **on_completed** se ejecuta cuando el Observable ha finalizado y muestra un mensaje de finalización.
>
>- La función **on_error** se ejecuta si se produce un error durante la emisión de valores y muestra un mensaje de error.

Crearemos entonces el observador de éste método mediante **create** para luego posteriormente suscribirlo y redefinir los anteriores métodos.

### Pipe
En *Pipe.py* encontramos otra manera de crear un observable. El método **interval** que nos ofrece *reactiveX* creará un observable que emitirá un número cada intervalo de tiempo que se le especifique, en este caso, cada segundo. Todos los valores que emita este observable van a pasar a través de una tubería, pipe.

> El método **pipe** permite transformar todos los valores emitidos por un observable, encadenando una serie de operaciones, y devolverá un nuevo observable que representa la secuencia transformada.

En este ejemplo el observador estará suscrito a lo que devuelva pipe, imprimiendo todos los resultados ya que a suscribe se le pasa el método print. Las operaciones que se realizan en la tubería son sencillas. La primera, *take_until*, detendrá la ejecución tras los segundos especificados. Justo después tenemos **filter**, ésta función descartará todos los valores que no cumplan la condición especificada, así pues no se tratarán en este caso los múltiplos de 3. Por último usamos la función **map** que es la que se encarga de editar los valores recibidos, simplemente haremos una multiplicación por 2 y la correspondiente cadena para indicar el valor. El resultado serán los valores no múltiplos de 3 multiplicados por 2.

El programa no esperará la a que termine la suscripción termine así que esperaremos unos segundos para esperar toda la ejecución.

### Más operaciones
En el archivo *MasOperacione.py* podemos ver algunas maneras m´´as de crear observables que nos permite la librería y operaciones para tratar con ellos. 

Con **from_iterable** crearemos un observable a partir de un elemento iterable, que emitira los valores de dicho elemento. En elejemplo luego aprovecharemos el método **zip** para combinar dos observables y devolver otro con el resultado al que nos suscribimos

En la segunda parte del archivo creamos un observable que emite un [elemento en particular](https://reactivex.io/documentation/operators/timer.html) después del tiempo que le hemos especificado y entonces el suscriptor imprimirá por pantalla un mensaje cuando el elemento sea emitido.