package main.scalabook.s1_preliminaries.p10_collections

import scala.collection.mutable.ArrayBuffer

object Collections {
  def main(args: Array[String]): Unit = {

    // ArrayBuffer
    val array = ArrayBuffer[Int](1, 2, 3)
    array += 4 // 添加一个元素
    println(array)

    array += 5 += 6
    println(array)

    array ++= ArrayBuffer(7, 8)
    println(array)

    array -= 7 -= 8
    array --= ArrayBuffer(5, 6)
    println(array)

    // List
    val list1 = List(1, 2, 3)
    println(list1)
    val list2 = 0 +: list1
    println(list2)
    val list3 = List(-1, -2) ++: list2
    println(list3)

    val list4 = list3 :+ 4
    println(list4)
    // ps1:  //它所说的prepend方案其实是::操作。 +:/:+操作都是o(n)
    // List is a singly-linked list, you should really only prepend elements to it;
    // tips:If you want to prepend and append elements to an immutable sequence, use Vector instead.
    // ps2:
    // List is a linked-list class, you shouldn’t try to access the elements of large lists by their index value.
    // For instance, if you have a List with one million elements in it, accessing an element like myList(999999)
    // will take a long time. If you want to access elements like this, use a Vector or ArrayBuffer instead.


    // Nil 表示一个空的List
    val list5 = 1 :: 2 :: Nil
    println(list5)


    val v1 = Vector(1, 2, 3)
    val v2 = v1 :+ 4
    println(v2)
    val v3 = 0 +: v2
    println(v3)

    // map
    val map1 = Map(
      "k1" -> "v1",
      "k2" -> "v2"
    )
    println(map1)
    // 可变的map
    val map2: collection.mutable.Map[String, String] = collection.mutable.Map()
    map2 += ("k1" -> "k2")
    println(map2)

    // set
    val s1 = Set(1, 2, 3)
    println(s1)

    val s2: collection.mutable.Set[Int] = collection.mutable.Set()
    s2 += 1
    println(s2)


    // 匿名函数
    val doubleList1 = list1.map(_ * 2)
    println(doubleList1)

    val doubleList2 = list1.map((v: Int) => v * 2)
    println(doubleList2)

    val doubleList3 = list1.map(v => v * 2)
    println(doubleList3)
    // 以上三种写法都是一样的效果

    // 集合常见方法介绍
    println(list1.head) // 打印列表的第一个元素
    println(list1.tail) //打印列表中head元素之后的每个元素
    //    println(List().head) // head，tail在调用空集合时会抛出异常

    println(list1.take(1))
    println(list1.take(2)) // 可以理解为subList
    println(list1.takeWhile(v => v < 5)) //过滤

    println(list1.drop(1))
    println(list1.drop(2))
    println(list1.dropWhile(_ < 3))

    // reduce
    println(list1.reduce(_+_)) // reduce-顾名思义-它就是通过传递的函数 减少集合元素到一个单一值

    // map 🇭相关操作
    val states = scala.collection.mutable.Map(
      "AL" -> "Alabama",
      "AK" -> "Alaska"
    )
    println(states.filterInPlace((k,v) => k == "AK"))
  }
}
