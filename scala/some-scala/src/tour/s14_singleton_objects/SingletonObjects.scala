package tour.s14_singleton_objects

// import语句要求被导入的标识具有一个“稳定路径”，一个单例对象由于全局唯一，所以具有稳定路径。

import tour.s14_singleton_objects.ChecksumAccumulator.calculate
import tour.s14_singleton_objects.Circle.calculateArea
import tour.s14_singleton_objects.Logger.info

import scala.math.{Pi, pow}
//注意：如果一个 object 没定义在顶层而是定义在另一个类或者单例对象中，那么这个单例对象和其他类普通成员一样是“路径相关的”。
// 这意味着有两种行为，class Milk 和 class OrangeJuice，一个类成员 object NutritionInfo “依赖”于包装它的实例，要么是牛奶要么是橙汁。 milk.NutritionInfo 则完全不同于oj.NutritionInfo。

object SingletonObjects {
  def main(args: Array[String]): Unit = {
    // 单例对象
    info("running")

    // 不再顶层定义的object 是路径相关的
    val milk = new Milk
    val orangeJuice = new OrangeJuice
    println(milk.NutritionInfo.info) // 注意看路径
    println(orangeJuice.NutritionInfo.info) // 注意看路径

    // 伴生对象
    val circle = new Circle(3.0)
    println(circle.area)

    // 伴生对象 with 工厂方法
    val emailOpt: Option[Email] = Email.genEmail("joe@gamil.com")
    emailOpt match {
      case Some(email) => println(s"email:${email.userName}@${email.domain}")
      case None => println("none")
    }

    // 伴生对象 是单例的
    calculate("test")

  }
}

//p022 单例对象：单例对象是一种特殊的类，有且只有一个实例。和惰性变量一样，单例对象是延迟创建的，当它第一次被使用时创建。
// ps 惰性变量？？？ todo @jiangyuan
// 当对象定义于顶层时(即没有包含在其他类中)，单例对象只有一个实例。 ps:参考Logger对象
// 当对象定义在一个类或方法中时，单例对象表现得和惰性变量一样。
object Box


// 伴生对象
// 当一个单例对象和某个类共享一个名称时，这个单例对象称为 伴生对象。
// 同理，这个类被称为是这个单例对象的伴生类。
// 类和它的伴生对象可以互相访问其私有成员。
// 使用伴生对象来定义那些在伴生类中不依赖于实例化对象而存在的成员变量或者方法。

// ps:类可以访问伴生对象中的所有成员，并且可以访问private的成员，
// 由于伴生对象的定义不在伴生类中，所以访问伴生对象中的成员，仍然需要对象名.成员

class Circle(radius: Double) {
  def area: Double = calculateArea(radius) // 可以访问伴生对象的私有方法
}

object Circle {
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
}

//伴生对象也可以包含工厂方法：
class Email(val userName: String, val domain: String)

object Email {
  def genEmail(address: String): Option[Email] = {
    address.split("@") match {
      case Array(a, b) => Some(new Email(a, b))
      case _ => None
    }
  }
}

// Java 程序员的注意事项
// 在 Java 中 static 成员对应于 Scala 中的伴生对象的普通成员。
// 在 Java 代码中调用伴生对象时，伴生对象的成员会被定义成伴生类中的 static 成员。这称为 静态转发。
// 这种行为发生在当你自己没有定义一个伴生类时。


// 伴生对象 存在的意义
//object Person(name:String) // compile error 不能有参数: traits or objects may not have parameters
// 可以理解为scala 为了对标java的static方法/变量