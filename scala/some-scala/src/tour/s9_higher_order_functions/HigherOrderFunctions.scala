package tour.s9_higher_order_functions

object HigherOrderFunctions {
  def main(args: Array[String]): Unit = {
    //p017 高阶函数： 高阶函数是指使用其他函数作为参数、或者返回一个函数作为结果的函数。
    //举例：
    val salaries = Seq(2000, 7000, 4000)
    val doubleSalary = (v: Int) => v * 2
    var newSalaries = salaries.map(doubleSalary)
    println(newSalaries)

    //简写
    newSalaries = salaries.map((v: Int) => v * 2)
    println(newSalaries)

    newSalaries = salaries.map(_ * 2)
    println(newSalaries)


    // 返回一个函数
    def builder = urlBuilder(domain = "www.maoyan.com")
    println(builder("/v1/user", "?id=123"))
  }

  // 返回函数的函数
  def urlBuilder(ssl: Boolean = false, domain: String): (String, String) => String = {
    var shema = ""
    if (ssl)
      shema = "https://"
    else
      shema = "http://"

    (endPoint: String, queryStr: String) => shema + domain + endPoint + queryStr
  }
}

// 强制转换方法为函数
class WeeklyWeatherForecast(temperatures: Seq[Double]) {
  private def convertCtoF(temp: Double) = temp * 1.8 + 32

  def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF
  //方法convertCtoF被传入forecastInFahrenheit。这是可以的，因为编译器强制将方法convertCtoF转成了函数x => convertCtoF(x)
}