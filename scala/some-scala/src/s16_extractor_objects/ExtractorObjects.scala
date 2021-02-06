package s16_extractor_objects

import scala.util.Random

object ExtractorObjects {
  def main(args: Array[String]): Unit = {
    val customerID = CustomerID("joe")

    customerID match {
      case CustomerID(name) => println(name) // 这里其实就是在调用unapply方法
      case _ => println("Could not extract a CustomerID")
    }

    val CustomerID(name) = customerID; // 这里其实就是在调用unapply方法
    println(name)
    // 上面的调用类似于
    val name2 = CustomerID.unapply(customerID).get
    println(name2)

    val CustomerID(name3) = "--asdfasdfasdf";
    println(name3)

    val CustomerID(name4) = "-asdfasdfasdf" // 如果没有匹配的值，会抛出 scala.MatchError
    println(name4)


  }
}

// p024 提取器对象：提取器对象是一个包含有 unapply 方法的单例对象。
// apply 方法就像一个构造器，接受参数然后创建一个实例对象，
// 反之 unapply 方法接受一个实例对象然后返回最初创建它所用的参数。
// 提取器常用在模式匹配和偏函数中。

object CustomerID {

  def apply(name: String) = s"$name--${Random.nextLong}"

  def unapply(customerID: String): Option[String] = {
    val stringArray: Array[String] = customerID.split("--")
    if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
  }
}

//unapply 方法的返回值应当符合下面的某一条：
//
//如果只是用来判断真假，可以返回一个 Boolean 类型的值。例如 case even()。
//如果只是用来提取单个 T 类型的值，可以返回 Option[T]。
//如果你想要提取多个值，类型分别为 T1,...,Tn，可以把它们放在一个可选的元组中 Option[(T1,...,Tn)]。

//有时，要提取的值的数量不是固定的，因此我们想根据输入来返回随机数量的值。
// 这种情况下，你可以用 unapplySeq 方法来定义提取器，此方法返回 Option[Seq[T]]。
// 常见的例子有，用 case List(x, y, z) => 来解构一个列表 List，
// 以及用一个正则表达式 Regex 来分解一个字符串 String，例如 case r(name, remainingFields @ _*) =>。