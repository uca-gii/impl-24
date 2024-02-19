import scala.collection.mutable.ArrayBuffer

trait Lista[T] {
  def addFirst(value: T): Unit
  def removeFirst(): Unit
  def addLast(value: T): Unit
  def removeLast(): Unit
  def first(): T
  def last(): T
  def isEmpty(): Boolean
  def length(): Int
  def copy(): MiLista[T]
  def equals(arg0: Any): Boolean
  def iterator(): Iterator[T]
}

trait Iterator[E] {
  def hasNext(): Boolean
  def get(): E
  def moveNext(): Unit
  def remove(): Unit
}

class MiLista[T] extends Lista[T] {
  protected var l = ArrayBuffer[T]()

  override def addFirst(value: T): Unit = l.prepend(value)
  override def removeFirst(): Unit = l.remove(0)
  override def addLast(value: T): Unit = l += value
  override def removeLast(): Unit = l.dropRightInPlace(1)
  override def first(): T = l.head
  override def last(): T = l.last
  override def isEmpty(): Boolean = l.isEmpty
  override def length(): Int = l.length
  override def copy(): MiLista[T] = {
    val newList = new MiLista[T]()
    newList.l ++= l
    newList
  }

  override def equals(arg0: Any): Boolean = arg0 == l

  override def iterator(): Iterator[T] = new Iterator[T] {
    private var currentIndex = 0

    override def hasNext(): Boolean = currentIndex < l.size

    override def get(): T = l(currentIndex)

    override def moveNext(): Unit = currentIndex += 1

    override def remove(): Unit = {
      l.remove(currentIndex)
      currentIndex -= 1
    }
  }

  override def toString(): String = l.mkString(", ")
}

object PruebasLista {
  def main(args: Array[String]): Unit = {
    println("Creamos la lista de Int...")
    val l1: MiLista[Int] = new MiLista[Int]()
    println("Añadimos el número 1 y mostramos...")
    l1.addFirst(1)
    println(l1)

    println("\nCopiamos la anterior a una segunda lista de Int...")
    val l2: MiLista[Int] = l1.copy()
    println("Comparamos las dos y mostramos el resultado...")
    val comparision = l1.equals(l2)
    println(comparision)

    println("Seguimos metiendo en la primera lista por el principio y final...")
    l1.addLast(2)
    l1.addLast(3)
    l1.addFirst(0)
    println(l1)
    println("Eliminamos ahora el último elemento")
    l1.removeLast()
    println(l1)

    println("\nPasamos a comprobar el uso de iteradores...")
    val it = l1.iterator()
    println("Mostramos el primer elemento y comprobamos si tiene siguiente...")
    println(it.get())
    println(it.hasNext)
    println("Vamos al siguiente y lo mostramos")
    it.moveNext()
    println(it.get())
    println("Eliminamos el elemento actual y mostramos en cuál nos quedamos")
    it.remove()
    println(it.get())
    println("Vamos al siguiente y lo mostramos...")
    it.moveNext()
    println(it.get())
    println("Y mostramos el estado actual de la lista...")
    println(l1)
  }
}
