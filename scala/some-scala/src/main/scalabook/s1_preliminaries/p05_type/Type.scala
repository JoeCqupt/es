package main.scalabook.s1_preliminaries.p05_type

object Type {
  def main(args: Array[String]): Unit = {
    //在Scala中创建新变量时，可以显式声明其类型,也可以省略类型。
    val i = 1;
    val str: String = "str"

    // 内置类型：
    val b: Byte = 1
    val x: Int = 1
    val l: Long = 1L
    val s: Short = 1
    val d: Double = 2.0
    val f: Float = 3.0f

    // 默认的类型推断
    val m = 123 // defaults to Int
    val n = 1.0 // defaults to Double

    // 大数表示
    val num1 = BigInt(1234567890413243214L)
    val num2 = BigInt(1341235435432543654L)
    println(num1 * num2)

    val num3 = BigDecimal("1234567890413243214")
    val num4 = BigDecimal("1234567890413243214")
    println(num3 * num4)

    // String & Char
    val str1 = "this is a String"
    val c = "c"

    // some String feature
    // feature1:
    val firstName = "John"
    val mi = 'C'
    val lastName = "Doe"

    val name = firstName + " " + mi + " " + lastName
    // 第二种方式
    val name2 = s"$firstName $mi $lastName"
    println(name2)
    // 第三方式
    val name3 = s"${firstName} ${mi}  ${lastName}"
    println(name3)
    // 可使用表达式
    println(s"1+1 = ${1 + 1}")

    //feature2: 多行字符
    val speech =
      """long long ago.
        i love you ，but now
        i still love you
        """
    println(speech) //输出是有问题的，发现除了第一行其他都有偏移量

    val speech2 =
      """this is a mutli line
        |txt
        |   thinks. i am fine!
        |""".stripMargin // 可以使用stripMargin来跳过偏移量

    println(speech2)
  }
}
