package main.tour.s3_classes

//p011 类：
//Scala中的类是用于创建对象的蓝图，其中包含了方法、常量、变量、类型、对象、特质、类，这些统称为成员。类型、对象和特质将在后面的文章中介绍。

//类定义：
class User

class Point(var x: Int, var y: Int) {
  def move(dx: Int, dy: Int) = {
    x = x + dx
    y = y + dy
  }

  // 重写了AnyRef的toString方法
  override def toString: String = s"($x, $y)" //todo @joecqupt 这是什么用法
}

//构造器: 可以给构造器参数设置默认值
class Color(name: String = "white")

class Employ(name: String = "foo", id: String)

//私有成员和Getter/Setter语法
//成员默认是公有（public）的。使用private访问修饰符可以在类外部隐藏它们。
//ps：很奇特的getter/setter语法
class Mobile {
  private var _brand: String = ""; // 手机品牌
  private var privateModel: String = ""; // 手机型号


  // ps:这一行必须存在，不然下一行的setter调用会报错
  def brand = _brand

  // ps: 这好像是个固定语法糖，必须带后下划线_,不带就compile error
  // ps: 这个定义方法语法很奇怪，目前只有这里见过
  def brand_=(setBrand: String) = _brand = setBrand;

  def model = privateModel

  def model_=(setModel: String) = privateModel = setModel;


  override def toString: String = _brand + privateModel
}


// 主构造方法中带有val和var的参数是公有的
class SomeOneClass(val x: Int, val y: Int)

// 不带val或var的参数是私有的，仅在类中可见。
class SomeTwoClass(x: Int, y: Int)

// test
object Classes {
  def main(args: Array[String]): Unit = {
    // 实例化User
    val user: User = new User
    // 实例化Point
    val p: Point = new Point(1, 3)
    p.move(2, 0)
    println(p)

    // 带默认参数的构造器类
    val c: Color = new Color
    val green: Color = new Color("green")
    val employ: Employ = new Employ(id = "no1")

    //私有成员
    val iphone11 = new Mobile
    iphone11.brand = "iphone"
    iphone11.model = "11"
    println(iphone11)

    //构造器成员变量
    val someOne = new SomeOneClass(1, 2)
    println(someOne.x)

    val someTwo = new SomeTwoClass(1, 2)
    //    println(someTwo.x) //compile error

  }
}
