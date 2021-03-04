package scalabook.s1_preliminaries.p11_misc

object Misc {
  def main(args: Array[String]): Unit = {
    val t1 = ("joe", 23)
    println(t1)
    println(t1._1)
    println(t1._2)
    // Scala 2.x元组不是集合类，它们只是一个方便的小容器。因为他们不是一个集合，他们没有方法，如map，filter等。


  }

  def doSomeThing(): String = ???
  // 跟python的pass一个效果，先定义一下方法的签名不提供具体实现，方便编译器编译
}
