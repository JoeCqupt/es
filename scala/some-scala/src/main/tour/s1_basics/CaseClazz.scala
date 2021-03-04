package main.tour.s1_basics

object CaseClazz {
  def main(args: Array[String]) = {
    // 注意看 这里没有使用new 来实例化
    var red = Color("red");
    var green = Color("green");
    var blue = Color("blue");

    // 可以直接进行比较
    println(red == green) // false
    println(Color("red") == red) // true
  }
}

//===================================================================================
//p007样例类 case class: 一种特殊的类; 默认情况下，样例类一般用于不可变对象，并且可作值比较。
//ps：我理解为就是 java里面的枚举类型

case class Color(name: String)