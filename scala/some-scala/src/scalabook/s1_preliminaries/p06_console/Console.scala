package scalabook.s1_preliminaries.p06_console

import scala.io.StdIn.readLine

object Console {
  def main(args: Array[String]): Unit = {
    System.err.println("error")

    // 读取控制台输入
    print("Enter your first name: ")
    val firstName = readLine()
    print("Enter your last name: ")
    val lastName = readLine();

    println(s"Your name is $firstName $lastName")
  }
}
