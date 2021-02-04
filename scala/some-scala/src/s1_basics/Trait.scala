package s1_basics

object Trait {
  def main(args: Array[String]): Unit = {
    val defaultGreeter = new DefaultGreeter
    defaultGreeter.greet("Scala developer")

    val customizableGreeter = new CustomizableGreeter("How are you, ", "?")
    customizableGreeter.greet("Scala developer")
  }
}

//===================================================================================
//p009 特质: 特质是包含某些字段和方法的类型。可以组合多个特质。
//ps：感觉有点像java8里面的接口？
trait TGreeter {
  // 定义未实现的方法
  def greet(name: String)

  // 带默认实现的方法
  def defaultGreet(name: String) = println("hello," + name + "!")
}

class DefaultGreeter extends TGreeter {
  override def greet(name: String): Unit = defaultGreet(name)
}

class CustomizableGreeter(prefix: String, suffix: String) extends TGreeter {
  override def greet(name: String): Unit = println(prefix + name + suffix)
}
