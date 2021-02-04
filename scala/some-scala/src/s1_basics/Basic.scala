package s1_basics

object Basic {
  def main(args: Array[String]): Unit = {
    //p001常量 values
    val x = 1 + 1;
    // 常量不能被重新赋值
    // x = 2; // compile error

    // scala 是带有类型推断的，但是也可以显式指定常量类型
    val y: Int = 3;

    //====================================================================================//
    //p002变量 variables
    var a = 1 + 1;
    a = 2;
    var b: Int = 2;

    //====================================================================================//
    //p003代码块 Blocks: 代码块最后的表达式的结果，也就是代码块的结果
    var m = {
      var n = 1 + 1;
      n + 3
    }
    println(m == 5);

    //====================================================================================//
    //p004函数 functions: 函数是带有参数的表达式。
    var fun1 = (x: Int) => x + 22;
    println(fun1(22))

    var fun2 = (x: Int, y: Int) => {
      var z = x + y;
      z;
    }
    // 函数不能 声明返回类型，否则 compile error
    //    val fun3 = (x: Int):Int => x + 3
    println(fun2(1, 2))
  }

  //====================================================================================//
  //p005方法 methods: 方法的表现和行为和函数非常类似，但是它们之间有一些关键的差别
  // 方法由def关键字定义。def后面跟着一个名字、参数列表、返回类型和方法体
  def add(x: Int, y: Int): Int = {
    x + y;
  }

  // 如果方法体只有一个表达式，可以省略{}
  def add2(x: Int, y: Int): Int = x + y;

  // 方法可以接受多个参数列表
  def addThenMultiply(x: Int, y: Int)(multiplier: Int) = (x + y) * multiplier

  // 没有参数列表： () 可以省略
  def name: String = System.getProperty("user.name")

  // 返回类型为 Unit（它有点像Java和C语言中的void）: 返回类型声明就可以省略
  def doNothing = println("do nothing")

}