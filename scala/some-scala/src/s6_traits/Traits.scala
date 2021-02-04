package s6_traits

import scala.collection.mutable.ArrayBuffer

//p014 特质(Trait): 特质 (Traits) 用于在类 (Class)之间共享程序接口 (Interface)和字段 (Fields)。 它们类似于Java 8的接口。 类和对象 (Objects)可以扩展特质，但是特质不能被实例化，因此特质没有参数。
//ps:类似于Java8的接口

trait Iterator[A] {
  def haveNext: Boolean;

  def next: A;
}

class MyIterator(var x: Int) extends Iterator[Int] {
  override def haveNext: Boolean = true

  override def next: Int = {
    x = x + 1;
    x
  }
}

// 特质子类型
trait Pet {
  val name: String;
}

class Cat(val name:String) extends Pet

class Dog(val name:String) extends Pet



object Traits {
  def main(args: Array[String]): Unit = {
    val iter = new MyIterator(10)
    println(iter.next)

    //特质子类型
    val animals = ArrayBuffer.empty[Pet]
    animals.append(new Cat("tom"))
    animals.append(new Dog("hei"))
    animals.foreach(p=>println(p))
  }
}

