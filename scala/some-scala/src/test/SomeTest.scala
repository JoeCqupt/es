import scala.collection.mutable

object SomeTest {
  def main(args: Array[String]): Unit = {
    val map: mutable.Map[Int, String] = mutable.Map();
    map += (1 -> "test")
    println(map)

    // 有个学名叫： 偏函数
    map.foreach {
      case (k, v) => println(s"key: $k ,value: $v") //这一行可以理解为带match的匿名函数？？
    }

  }
}
