package main.tour.s7_tuples

object Tuples {
  def main(args: Array[String]): Unit = {
    //p015 元组(Tuple): 在 Scala 中，元组是一个可以容纳不同类型元素的类。 元组是不可变的。
    // 声明
    val info: Tuple2[String, Int] = ("joe", 25)
    // 访问
    println(info._1)
    println(info._2)

    // 解析
    val (name, age) = info
    println(name)
    println(age)

    // 元祖可用于模式匹配
    val list: List[Tuple2[String, Any]] = List(
      ("joe", 26),
      ("ysss", 25),
      ("ggll", "26a") // ps注意这里的类型, 表示可以设置不同的类型，类型推断应该是Any
    )
    list.foreach(
      v => {
        v match {
          case v if (v._2 == 26) => println("26 years old")
          case _ => println("young")
        }
      }
    )
    //用户有时可能在元组和 case 类之间难以选择。 通常，如果元素具有更多含义，则首选 case 类。

    // 元祖用于for循环
    for ((name, age) <- list) {
      println("name:" + name + " age:" + age)
    }

  }
}
