package s2_unified_types

object UnifiedTypes {
  //===================================================================================
  //p010 统一类型:
  //
  //                                                       Any
  //                                                        ^
  //                                                        |
  //                                                  ------------
  //                                                 |            \
  //                                             AnyVal        AnyRef(java.lang.object)
  //                                                ^              ^
  //                                                |              |
  //    -----------------------------------------------        ------------
  //   /       |      |   |   |     |    |    |       |       /      |     \
  //  Double Float Long Int Short Byte Unit Boolean  Char    List  Option  YourClass
  //   ^       ^     ^   ^    ^     ^    ^    ^       ^       ^      ^      ^
  //   |       |     |   |    |     |    |    |       |       |      |      |
  //   |       |     |   |    |     |    |    |       |       --------------
  //   |       |     |   |    |     |    |    |       |             Null
  //   |       |     |   |    |     |    |    |       |              ^
  //   |       |     |   |    |     |    |    |       |              |
  //   --------------------------------------------------------------
  //                              Nothing
  //
  // draw by @joecqupt
  //

  def main(args: Array[String]): Unit = {
    // Any是所有类型的超类型，也称为顶级类型。它定义了一些通用的方法如equals、hashCode和toString。Any有两个直接子类：AnyVal和AnyRef。
    // AnyVal代表值类型; AnyRef代表引用类型;
    val list: List[Any] = List(
      "a string",
      732, // an integer
      'c', // a character
      true, // a boolean value
      () => "an anonymous function returning a string"
    )
    list.foreach(v => println(v))

    // 类型转换
    // Byte->Short->Int->Long->Float->Double
    //               ^
    //               |
    //             Char
    val i : Int = 'a'
    val j  : Float = i
    // val k : Short = i //compile error； 类型转换是单向的，逆向会编译错误

    // Nothing和Null
    // Nothing是所有类型的子类型，也称为底部类型。没有一个值是Nothing类型的。
    // 它的用途之一是给出非正常终止的信号，如抛出异常、程序退出或者一个无限循环（可以理解为它是一个不对值进行定义的表达式的类型，或者是一个不能正常返回的方法）。

    // Null是所有引用类型的子类型（即AnyRef的任意子类型）。它有一个单例值由关键字null所定义。
    // Null主要是使得Scala满足和其他JVM语言的互操作性，但是几乎不应该在Scala代码中使用。我们将在后面的章节中介绍null的替代方案。
  }

}
