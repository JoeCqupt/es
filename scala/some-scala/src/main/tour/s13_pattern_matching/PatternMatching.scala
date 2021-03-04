package main.tour.s13_pattern_matching

import scala.util.Random

object PatternMatching {
  def main(args: Array[String]): Unit = {
    //p021 模式匹配：模式匹配是检查某个值（value）是否匹配某一个模式的机制，一个成功的匹配同时会将匹配值解构为其组成部分。
    // 它是Java中的switch语句的升级版，同样可以用于替代一系列的 if/else 语句。

    //一个模式匹配语句包括一个待匹配的值，match关键字，以及至少一个case语句。
    // 基本语法
    val x = Random.nextInt();
    x match { // 记住这个语法的match
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case _ => "other" //case _表示匹配其余所有情况
    }

    // match表达式具有一个结果值
    val y = x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case other => "other" // 注意看这里的语法和"case _"一样的效果
    }
    println(y)

    // 匹配case class
    val sms = new SMS("12345", "Are you there?")
    val voiceRecording = new VoiceRecording("Tom", "voicerecording.org/id/123")
    println(notify(sms))
    println(notify(voiceRecording))

    // Pattern guards
    val importantSms = SMS("189999", "important thing")
    println(importantNotify(importantSms, List("189999")))

    // 只匹配类型
    val device: Device = Phone()
    println(action(device))

    // 密封类
    val furniture: Furniture = Bed();
    println(lay(furniture))

    var bed = Bed(); // ps case class的特殊语法：实例化必须有括号，不然类型推断会推断为Type类型，下面有演示
    println(lay(bed)) // scala支持多态

    var bed2 = Bed
    //    println(lay(bed2)) //compile error 应为bed2被类型推断为：Bed.type
  }

  //===================================================================================
  // 密封类 sealed class：这意味着其所有子类都必须与之定义在相同文件中，从而保证所有子类型都是已知的。
  // 这对于模式匹配很有用，因为我们不再需要一个匹配其他任意情况的case。
  sealed abstract class Furniture

  case class Chair() extends Furniture

  case class Bed() extends Furniture

  def lay(furniture: Furniture): String = {
    furniture match {
      case c: Chair => "lay on chair"
      case b: Bed => "lay on bead"
    }
  }

  //===================================================================================
  // 只匹配类型
  abstract class Device

  case class Phone() extends Device {
    val off = "off";
  }

  case class Computer() extends Device {
    val on = "on"
  }

  def action(device: Device): String = {
    device match {
      case p: Phone => p.off //ps 注意看这里的语法
      case c: Computer => c.on
    }
  }

  //===================================================================================
  // 模式守卫：Pattern gaurds
  def importantNotify(notification: Notification, importantList: List[String]): String = {
    notification match {
      case Email(sender, _, _) if importantList.contains(sender) => // 可以使用if判断来细化匹配
        s"you got an important email !!"
      case SMS(caller, _) if importantList.contains(caller) =>
        s"you got an important sms !!"
      case other => // 注意看这里的other 和上面的_ 一个效果
        notify(notification)
    }
  }

  //===================================================================================
  // case classes 匹配
  def notify(notification: Notification): String = {
    notification match {

      case Email(sender, title, _) => // 在case Email(sender, title, _)中，对象的sender和title属性在返回值中被使用，而body属性则被忽略，故使用_代替。
        s"you got an email from $sender title:$title"
      case SMS(caller, message) =>
        s"you got an sms from $caller message:$message"
      case VoiceRecording(contactName, link) =>
        s"you get an voice recoding form $contactName link:$link"
    }
  }

  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification

  case class SMS(caller: String, message: String) extends Notification

  case class VoiceRecording(contactName: String, link: String) extends Notification

}
