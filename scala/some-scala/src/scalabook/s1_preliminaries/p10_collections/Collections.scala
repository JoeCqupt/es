package scalabook.s1_preliminaries.p10_collections

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

    val list5 = 1 :: 2 :: Nil
    println(list5)
  }
}
