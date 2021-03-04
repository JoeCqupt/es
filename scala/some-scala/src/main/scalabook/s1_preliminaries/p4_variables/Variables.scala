package main.scalabook.s1_preliminaries.p4_variables

object Variables {
  def main(args: Array[String]): Unit = {
    // two-types-variables
    /**
     * Scala具有两种类型的变量：
     *
     * val创建一个不可变的变量（例如final在Java中）
     * var创建一个可变变量
     *
     */

    var i = 1;
    var s = "str"

    /**
     * Scala编译器通常足够聪明，可以从符号"="右侧的代码推断出变量的数据类型
     */

    // val和var之间的区别是：
    // val使变量不变（就像Java中final一样）
    // var使变量可变。
    // 因为val字段不能改变，所以有些人将它们称为值而不是变量。

    // 如何选择使用val还是var？
    // 在Scala中，除非有充分的理由不使用，否则一般情况下应始终使用val，
    // 这个简单的规则使得：
    // 1. 使你的代码更像代数
    // 2. 帮助你开始进行函数式编程，函数式编程所有字段都是不可变的。



  }
}
