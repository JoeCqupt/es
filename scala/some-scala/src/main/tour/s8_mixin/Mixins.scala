package main.tour.s8_mixin

//p016 通过混入（MIXIN）来组合类: 当某个特质被用于组合类时，被称为混入。
abstract class A {
  val message: String
}

class B extends A {
  val message = "I'm an instance of class B"
}

trait C extends A {
  def loudMessage = message.toUpperCase;
}

// 类D有一个父类B和一个混入C。一个类只能有一个父类但是可以有多个混入（分别使用关键字extends和with
// ps: 感觉有点像java里面的单继承，多接口实现
class D extends B with C


// another example:
abstract class AbsIterator {
  type T

  def hasNext: Boolean

  def next: T
}

class StringIterator(str: String) extends AbsIterator {
  override type T = Char
  private var index = 0;

  override def hasNext: Boolean = index < str.length

  override def next: Char = {
    val c = str.charAt(index)
    index += 1;
    c
  }
}

trait RichIterator extends AbsIterator {
  def forEach(f: T => Unit)
}

class StringRichIterator(str: String) extends StringIterator(str) with RichIterator {
  override def forEach(f: Char => Unit): Unit = {
    while (hasNext) {
      f(next)
    }
  }
}

object Mixins {
  def main(args: Array[String]): Unit = {
    // test1
    val d = new D
    println(d.message)
    println(d.loudMessage)


    // test2
    var srt = new StringRichIterator("Hello Scala")
    srt.forEach(v => println(v))


    // ps:特殊写法 好像是能推断出调用哪一个方法
    srt = new StringRichIterator("Hello Scala")
    srt.forEach(println)
  }
}
