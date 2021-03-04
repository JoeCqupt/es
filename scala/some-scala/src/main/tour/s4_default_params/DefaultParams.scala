package main.tour.s4_default_params

object DefaultParams {
  def main(args: Array[String]): Unit = {
    log("running")
    log("debug running", "DEBUG")
  }

  //p012 默认参数: Scala具备给参数提供默认值的能力，这样调用者就可以忽略这些具有默认值的参数。
  //Java中方法重载可以实现该功能
  def log(message: String, level: String = "INFO") = {
    println("[" + level + "] " + message)
  }
}
