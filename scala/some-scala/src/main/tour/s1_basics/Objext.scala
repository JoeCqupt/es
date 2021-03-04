package main.tour.s1_basics

object Objext {
  def main(args: Array[String]): Unit = {

    // 通过引用它的名字来访问一个对象: IdFactory
    var id1 = IdFactory.create;

    var id2 = IdFactory.create;
    println(id2)
  }
}

//===================================================================================
//p008对象 objects: 对象是它们自己定义的单实例，你可以把它看作它自己的类的单例。
object IdFactory {
  private var counter = 0;

  def create: Int = {
    // !!ps: scala 是没有 变量++ 这个语法的， scala的++另有用处
    // counter++ // compile error
    counter += 1
    counter
  }
}