package tour.s17_for_comprehensions

object ForComprehensions {

  case class User(name: String, age: Int)

  def main(args: Array[String]): Unit = {
    // p025 for循环推导式:
    // Scala 提供一个轻量级的标记方式用来表示 序列推导。
    // 推导使用形式为 for (enumerators) yield e 的 for 表达式，此处 enumerators 指一组以分号分隔的枚举器。
    // 一个 enumerator 要么是一个产生新变量的生成器，要么是一个过滤器。
    // for 表达式在枚举器产生的每一次绑定中都会计算 e 值，并在循环结束后返回这些值组成的序列。
    val userList = List(
      User("Travis", 28),
      User("Kelly", 33),
      User("Jennifer", 44),
      User("Dennis", 23),
    )

    val someUsers = for (user <- userList if (user.age >= 20 && user.age < 30)) yield user.name
    println(someUsers)

    // 更复杂的例子：
    val res = foo(10, 10)
    println(res)

    // 你可以在使用 for 表达式时省略 yield 语句。此时会返回 Unit。
    // 当你想要执行一些副作用的时候这很有用。下面的例子输出和上面相同的结果，但是没有使用 yield
    foo2(10, 10)
  }

  def foo(n: Int, v: Int) = {
    for (i <- 0 until n; j <- i until n if (i + j == v))
      yield (i, j)
  }

  def foo2(n: Int, v: Int) = {
    for (i <- 0 until n; j <- i until n if (i + j == v))
      println(s"($i,$j)") // 没有使用yield
  }
}
