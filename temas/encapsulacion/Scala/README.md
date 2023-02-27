## Compilación
Una vez tenemos instalado el compilador de scala:
>scalac Lista.scala

## Ejecución
>scala Lista

## Explicación
### Conceptos previos
Scala, al igual que java, es un lenguaje de programación orientado a objetos pero éste no sólo cuenta con las clases sino que también tiene un añadido llamado "companion objects".

>Los **Companion Objects** se definen mediante la palabra reservada *object* y suelen ser *acompañantes* de una clase con el mismo nombre pero, a diferencia de las clases, éstos no cuentan con parámetros de entrada en su constructor, a su vez, pueden extender clases y traits así como ser miembros de clases o traits.

Éstos objetos acompañantes tienen múltiples usos, de los cuáles ahora nos va a ser útil uno en especial, para agrupar miembros static.

> Scala no cuenta con la palabra reservada *static*, en cambio, los miembros de un companion object son tratados como tal.