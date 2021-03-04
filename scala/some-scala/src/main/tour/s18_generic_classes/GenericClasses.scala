package main.tour.s18_generic_classes

object GenericClasses {
  //p026:范型类
  // 泛型类指可以接受类型参数的类。泛型类在集合类中被广泛使用。

  class Stack[A]{
    private var elements:List[A] = Nil

  }

  def main(args: Array[String]): Unit = {
  }
}
