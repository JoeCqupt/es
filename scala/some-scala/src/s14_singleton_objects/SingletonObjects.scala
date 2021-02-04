package s14_singleton_objects

object SingletonObjects {
  def main(args: Array[String]): Unit = {

  }
}
//p022 单例对象：单例对象是一种特殊的类，有且只有一个实例。和惰性变量一样，单例对象是延迟创建的，当它第一次被使用时创建。
// ps 惰性变量？？？ todo @jiangyuan
// 当对象定义于顶层时(即没有包含在其他类中)，单例对象只有一个实例。
// 当对象定义在一个类或方法中时，单例对象表现得和惰性变量一样。