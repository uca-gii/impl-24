## Compilación y ejecución

> python MobileTester.py

## Explicación

### None en Python

El tipo nulo en este caso es *None* y es una instancia de la clase *NoneType* y representará una variable que tiene un objeto de ningún valor. El tratamiento de este tipo es bastante sencillo y puede llegar a parecer que está bastante metido en el estilo de programación que propone Python, por ejemplo el siguiente código:

```python
 var = None
 if var
    print("No es none")
 else
    print("Es none")
```
Podriamos llegar a pensar que var es de tipo *Bool* si venimos de otro lenguaje. Obviamente se da la opción a  comparar de manera más directa.

### Parámetros en Python

Cómo ya sabréis, Python es un lenguaje de programación dinámicamente tipado, Esto significa que las variables no tienen que ser declaradas con un tipo específico antes de su uso, y su tipo puede cambiar en tiempo de ejecución.

Sin embargo, desde la versión 3.5 de Python, se introdujo la sintaxis de anotación de tipos, que permite especificar el tipo de una variable. Estas anotaciones no afectan la forma en que se ejecuta el código, pero son útiles para mejorar la legibilidad del código y permitir que las herramientas de análisis de código y los IDEs realicen verificaciones de tipos.

En ésta práctica aprovecharemos dicha sintaxis para tener un código más parecido al original y en el que pueda tener sentido el sentido el uso de optionals.

Ambas declaraciones son correctas:

```python
def function(self, var1, var2):
    pass

def function(self, var1: int, var2: str):
    pass
```

### Optionals en Python

En este lenguaje no existe la clase *Optional* como tal, entonces, a diferencia de java, no tendrá métodos propios que podamos usar. En Python, el tipo *Optional* es una notación abreviada para *Union[..., None]*, lo que indica al comprobador de tipos que se requiere un objeto del tipo específico o *None*, así que sólo lo utilizaremos para especificar el tipo de los parámetros. La forma en la que se usa *Optional* y *Union[..., None]* es la misma.

Ésto nos plantea un problema a la hora de implementar el ejemplo, no tenemos métodos específicos para el tratamiento de optionals, y seguiremos teniendo la incertidumbre de si un parámetro es *None* o no, así que, en el caso de *MobileService*, lo trataremos con excepciones, lo que se traduce en que si algún elemento es *None*, y lance una excepción, entonces se devolverá 0.

Tal y cómo estaréis pensando, este uso de optional, aunque entre otros usos seguramente, principalmente sirve para indicar al usuario que es seguro que un parámetro sea *None*, puesto que en python es común incluso que se permita pasar a las funciones tipos que no son los deseados y se vayan dando lugar a errores que pueden ser evitados con un poco de orden cómo es el de indicar el tipo del parámetro.

El que no exista la clase Optional nos lleva a que en los test del archivo *MobileTester* no llamemos a los métodos de las clases con un Optional del tipo que toque sino con el elemento directamente, o el *None* en el segundo *Mobile* que creamos. Por sacar un punto positivo, es cierto que facilitan en cierta medida la creación y lectura de los test en el momento en el que vemos de manera más directa el objeto que estámos pasando. 

### Conclusión

Así pues concluimos con la idea de que, en Python, el tratamiento de *None* tiene que hacerse de manera más "manual" y sin herramientas específicas. No tiene porqué ser malo en todos los casos, como hemos visto, las herramientas más generales como las excepciones o los condicionales ya permiten tratar de manera sencilla estos valores nulos. Obviamente, a medida que los *None* tengan más presencia en un programa su tratamiento va a convertirse en uno más complejo pero, como hemos visto en teoría, el uso abusivo de este tipo no es correcto.