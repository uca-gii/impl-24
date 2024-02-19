## Compilación y ejecución
>python Threads_Example.py
>
>python Threads_Example_Join.py
>
>python Pool_Example.py
>
>python Daemon_Example.py
>
>python Lock_Example.py
>
>python Asyncio_Example.py


## Expliación
En ésta práctica voy a explicar varias herramientas que propone python para la programación asíncrona a través de distintos archivos y ejemplos. Antes de empezar voy a explicar una herramienta común a todos los ejemplos.

### Logging
*Logging* proporciona una serie de herramientas que nos ayuda a visualizar de manera fácil el flujo de operaciones de nuestro programa. Nosotros usaremos **logging.info** en lugar del clásico *print* para poder asegurarnos de que lo que se imprime por pantalla lo hace cuando debe.

### Threads
Python nos permite crear y ejecutar distintas hebras para dividir nuestro flujo de trabajo. El problema que nos podemos encontrar frente a esto es que en python las distintas hebras se van a ejecutar una a una, aunque cada una de ellas se ejecute en un procesador o núcleo distinto. Para poder conseguirlo necesitaríamos una implementación del lenguaje fuera del estándar o usar *multiprocessing*. En ésta práctica veremos todo según el estándar atual.

Para explicar el uso básico de las hebras voy a usar los ejemplos *Threads_Example* y *Threads_Example_Join*. 

> En python podemos crear hebras a partir de funciones usando *threading.Thread*, éstas hebras, al igual que ocurre en Java las podemos almacenar en variables para poder tratarlas.

En ambos ficheros podemos ver como la clase *raceOperations* nos proporciona unas condiciones *"de carrera"*. Crearemos dos hebras, una por cada operación de la clase. Una de ellas tiene un bucle en la que la variable, compartida por ambas hebras, *value* va aumentando el valor de uno en uno hasta que se hayan completado 1000 iteraciones, con el caso de que cuando lleve la mitad completada la hebra se dormirá durante 2 segundos. La otra hebra doblará el valor de la variable compartida.

*Threads_Example* no es determinista. Nos vamos a encontrar con distintos casos de ejecución, el más común es que la hebra 2 se ejecutará en el momento en el que la primera se duerme, dándo como resultado 1500. Si usamos la operación **join** sobre la hebra *x*, la primera, conseguiremos que la ejecución principal del programa espere a la finalización de la hebra antes de continuar, eso es, en este caso, antes de lanzar la segunda, consiguiendo siempre el resultado 2000.

### ThreadPoolExecutor
Al igual que otros lenguajes como java ésta herramienta nos permite tratar con la llamada de múltiples hebras sin la necesidad de hacerlo con bucles de manera más *"rústica"*. Usando el bloque **with** podemos crear un contexto de ejecución y gracias a esto se produce un *join* al final del bloque para cada hebra lanzada, de ésta manera nunca olvidaremos hacer los *join*. El ejemplo lo podemos ver en el fichero *Pool_Example.py*.

### Daemon
En Python un *Daemon* será aquella hebra que tengamos ejecutando en otro flujo de trabajo (o *"de fondo"*) pero, a diferencia de las hebras que vimos antes, a éstas no las va a esperar la ejecución principal del programa. En nuestro ejemplo *Daemon_Example.py* se traduce a que  si el main acaba antes que la hebra, terminará el programa, sin importar en que punto se haya quedado el daemon de la ejecución. Esto lo podemos solucionar fácilmente usando *join* sobre la hebra antes de finalizar.

### Lock
Es una de las herramientas que proporciona Python para el tratamiento de zonas conflictivas. Lock se basa en la exclusión mutua y tiene un uso sencillo dentro del lenguaje. Como vemos en *Lock_Example.py* la ejecución de las hebras es más intercambiada pues cuando llega la multiplicación, en el momento en el que la primera hebra está dormida, no puede coger el cerrojo aún, entonces vuelve la ejecución al main, después termina la primera hebra y por último la multiplicación, obteniendo el valor 2000 sin el uso de join y tener que haberlas "dirigido" manualmente.

### Asyncio
Si queremos conseguir una división del flujo de trabajo, es decir, utilizar programación asíncrona y/o concurrente pero sin la creación de varias hebras podemos utilizar el módulo *asyncio*. En *Asyncio_Example.py* encontraremos el mismo ejemplo que con las hebras pero utilizando dicho módulo. Ésta vez no todas las funciones pueden ejecutarse de forma asíncrona sino que deben especificarlo en la cabecera con la palabra reservada *async*. Mediante la línea *loop.run_until_complete(ro.start())* esperamos a que toda la ejecución asíncrona se complete pues, a su vez, la función start de la clase llama y espera a que terminen ambas ejecuciones.

Gracias a que hemos sustituido *time.sleep* por *await asyncio.wait([f1, f2])* las ejecuciones de las funciones se interpolan. Al no ser sleep del módulo asyncio la ejecución del segundo flujo no empezaría hasta que el primero termine, por eso usamos await.

