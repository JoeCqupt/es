import scala.collection.mutable

object Options {
  def main(args: Array[String]): Unit = {
    val str: String = "abcde"
    println(Option(str).orElse(Option("is null")))
  }

}
