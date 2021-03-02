package tour.s10_nested_functions

object NestedFunctions {
  def main(args: Array[String]): Unit = {
    println(factorial(2))
    println(factorial(3))
  }

  //p018 嵌套方法：在Scala中可以嵌套定义方法。
  def factorial(x: Int): Int = {
    def fact(i: Int, accumulator: Int): Int = {
      if (i <= 1) accumulator
      else fact(i - 1, i * accumulator)
    }

    fact(x, 1)
  }
}
