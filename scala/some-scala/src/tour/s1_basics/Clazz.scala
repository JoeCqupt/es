package tour.s1_basics

object Clazz {
  def main(args: Array[String]) = {
    // 需要自己new 一个类的实例
    var greeter = new Greeter("Hello, ", "!");
    greeter.greet("Scala developer")
  }
}

//===================================================================================
//p006类 classes
class Greeter(prefix: String, subfix: String) {
  def greet(name: String) = println(prefix + name + subfix)
}
