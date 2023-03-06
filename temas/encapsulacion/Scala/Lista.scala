import scala.collection.immutable._

trait ListaInterfaz[T] {

    def addFirst(value: T): Unit
    def removeFirst(): Unit
    def addLast(value: T): Unit
    def removeLast(): Unit
    def first(): T
    def last(): T
    def isEmpty(): Boolean
    def length(): Int
    // def clone()

    //Al crear una clase que hereda de la interfaz no puedo poner como parámetro otro tipo,
    //Pues estaríamos comparando tipos distintos
    //def isEqualTo(other: ListaInterfaz[T]): Boolean //def equal(other: any)

    //Lo hacemos al estilo de Scala dónde el método se llama equals y recibe cualquier tipo
    def equals(arg0: Any): Boolean

    def iterator(): Iterator[T]
  }

trait Iterator [E] {
    def hasNext(): Boolean
    def next(): E
    def remove(): Unit
}

  class MiLista[T] extends ListaInterfaz[T]{
    //variables
    protected var l: Vector[T] = Vector.empty

    //Métodos
    override def addFirst(value: T): Unit = {l = value +: l}
    override def removeFirst(): Unit = {l = l.tail}
    override def addLast(value: T): Unit = {l = l :+ value}
    override def removeLast(): Unit = {l = l.init}
    override def first(): T = {l.head}
    override def last(): T = {l.last}
    override def isEmpty(): Boolean = {l.isEmpty}
    override def length(): Int = {l.size}
    // def clone(): MiLista[T] 
    //override def isEqualTo(other: MiLista[T]): Boolean = {other.l == l}

    override def equals(arg0: Any): Boolean = {
      //Utilizamos la comparación del tipo vector, si no utilizaramos esta
      //tendíamos que hacer un match para ver primero cuál es el tipo que estamos recibiendo
      arg0 == l;
    }

    override def iterator(): Iterator[T] = new MyIterator[T](l)

    //Método de conversión a cadena
    override def toString() = {l.toString()}
  }

    class MyIterator[E](elements: Vector[E]) extends Iterator[E] {
        private var currentIndex = 0

        override def hasNext(): Boolean = currentIndex < elements.size

        override def next(): E = {
            var element = elements(currentIndex)
            // if(hasNext){
            //     val element = elements(currentIndex)
            //     currentIndex += 1
            //     element
            // }else{
            //     val element = new E();
            // }
            element
        }
        
        override def remove(): Unit = {
            if (currentIndex > 0) {
            
            //elements = elements.patch(currentIndex, Nil, 1)
            currentIndex -= 1
            }
        }
    }

object Lista {
        def main(args: Array[String]) ={
            println("Creamos la lista de Int...")
            var l1: MiLista[Int] = new MiLista[Int]();
            println("Añadimos el numero 1 y mostramos...")
            l1.addFirst(1);
            println(l1);

            println("\n Creamos una segunda lista de Int...")
            var l2: MiLista[Int] = new MiLista[Int]();
            println("Añadimos el numero 1, comparamos y mostramos el resultado...")
            l2.addFirst(1);
            var comparition = l1.equals(l2);
            println(comparition);
        }
}

  