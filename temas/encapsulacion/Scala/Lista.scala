import scala.collection.immutable._

trait Lista[T] {
    protected var l: Vector[T]
    def addFirst(value: T): Unit
    def removeFirst(): Unit
    def addLast(value: T): Unit
    def removeLast(): Unit
    def first(): T
    def last(): T
    def isEmpty(): Boolean
    def length(): Int
    // def clone()
    //def isEqualTo(other: Lista[T]): Boolean
    def isEqualTo(other: Lista[T]): Boolean = {other.l == l}
    def iterator(): Iterator[T]
  }

trait Iterator [E] {
    def hasNext(): Boolean
    def next(): E
    def remove(): Unit
}

  class MiLista[T] extends Lista[T]{
    //variables
    protected var l: Vector[T] = Vector.empty

    //Métodos
    def addFirst(value: T): Unit = {l = value +: l}
    def removeFirst(): Unit = {l = l.tail}
    def addLast(value: T): Unit = {l = l :+ value}
    def removeLast(): Unit = {l = l.init}
    def first(): T = {l.head}
    def last(): T = {l.last}
    def isEmpty(): Boolean = {l.isEmpty}
    def length(): Int = {l.size}
    // def clone(): MiLista[T] 
    // def isEqualTo(other: MiLista[T]): Boolean = {other.l == l}
    def iterator(): Iterator[T] = new MyIterator[T](l)
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
            var l1 = new MiLista();
        }
}

  