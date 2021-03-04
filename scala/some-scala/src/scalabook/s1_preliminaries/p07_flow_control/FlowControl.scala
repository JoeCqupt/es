package scalabook.s1_preliminaries.p07_flow_control

import scala.io.StdIn.readInt

object FlowControl {
  def main(args: Array[String]): Unit = {

    // for 循环
    val people = List(
      "Bill",
      "Candy",
      "Karen",
      "Leo",
      "Regina"
    )

    people.foreach(v => println(v))
    for (v <- people) println(v)

    // for循环生成器
    val nums = Seq(1, 2, 3)
    val nums2 = for (v <- nums) yield v * 2
    println(nums2)

    // match 类似于 java中的switch
    println("please input month:")
    val i = readInt()
    val monthName = i match {
      case 1 => "January"
      case 2 => "February"
      case 3 => "March"
      case 4 => "April"
      case 5 => "May"
      case 6 => "June"
      case 7 => "July"
      case 8 => "August"
      case 9 => "September"
      case 10 => "October"
      case 11 => "November"
      case 12 => "December"
      case _ => "Invalid month"
    }
    println("it is:" + monthName)

    // match的其他用法简介
    def convertBooleanToStringMessage(boolean: Boolean): String = {
      boolean match {
        case true => "true"
        case false => "false"
      }
    }

    println(convertBooleanToStringMessage(true))

    i match {
      case a if 0 to 9 contains a => println("0-9 range: " + a)
      case b if 10 to 19 contains b => println("10-19 range: " + b)
      case c if 20 to 29 contains c => println("20-29 range: " + c)
      case _ => println("Hmmm...")
    }
  }
}
