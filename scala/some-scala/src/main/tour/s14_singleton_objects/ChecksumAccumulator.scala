package main.tour.s14_singleton_objects

class ChecksumAccumulator {
  private var sum = 0

  def add(b: Byte) {
    sum += b
  }

  def checksum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  private var cache = Map[String, Int]()

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator //在伴生对象中实例化了伴生类
      for (c <- s) acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}

object Summer {
  def main(args: Array[String]) {
    //通过伴生对象直接访问了一个关于处理伴生类的方法
    println(ChecksumAccumulator.calculate("Every value is an object."))
  }
}
