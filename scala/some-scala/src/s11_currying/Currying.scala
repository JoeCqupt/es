package s11_currying

object Currying {

  def main(args: Array[String]): Unit = {
    //p019 currying柯里化： 方法可以定义多个参数列表，当使用较少的参数列表调用多参数列表的方法时，会产生一个新的函数，该函数接收剩余的参数列表作为其参数。这被称为柯里化。
    val nums = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    var result = nums.foldLeft(0)((x: Int, y: Int) => x + y)
    result = nums.foldLeft(0)((m, n) => m + n) // 这种写法和上面的效果是一样的
    println(result)

    // 单一的函数参数
    result = nums.foldLeft(0) { (m, n) => m + n }
    println(result)
    result = nums.foldLeft(0)(_ + _)
    println(result)

    //给定多参数列表的一部分参数列表来形成一个新的函数，以达到复用的目的
    val numberFunc = nums.foldLeft(List[Int]()) _
    val squares = numberFunc((list, v) => list :+ v * v)
    println(squares)
    val cubes = numberFunc((list, v) => list :+ v * v * v)
    println(cubes)

    // 隐式参数 todo @jiangyuan  后面的章节会介绍
    // 如果要指定参数列表中的某些参数为隐式（implicit），应该使用多参数列表。

  }


}
