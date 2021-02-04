package s5_named_args

object NameArgs {
  def main(args: Array[String]): Unit = {
    printName("John", "Smith")
    printName(last = "Smith", first = "John")
    printName("John", last = "smith")
    //    printName(last = "smith", "John") //compile error
  }

  //p013 当调用方法时，实际参数可以通过其对应的形式参数的名称来标记
  def printName(first: String, last: String) = {
    println(first + " " + last)
  }
}