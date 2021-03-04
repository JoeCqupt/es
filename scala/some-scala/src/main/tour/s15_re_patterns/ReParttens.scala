package main.tour.s15_re_patterns

import scala.util.matching.Regex

object RePatterns {
  def main(args: Array[String]): Unit = {
    //p023 正则表达式是用来找出数据中的指定模式（或缺少该模式）的字符串。.r方法可使任意字符串变成一个正则表达式。
    val pattern: Regex = "[0-9]".r

    pattern.findFirstMatchIn("fas123") match {
      case Some(_) => println("found")
      case None => println("not found")
    }

    val kvPattern = "([0-9a-zA-Z-#() ]+): ([0-9a-zA-Z-#() /\\.]+)".r
    val str: String =
      """background-color: #A03300;
        |background-image: url(img/header100.png);
        |background-position: top center;
        |background-repeat: repeat-x;
        |background-size: 2160px 108px;
        |margin: 0;
        |height: 108px;
        |width: 100%;""".stripMargin //todo @joecqupt 这又是什么语法？

    for (patternMatch <- kvPattern.findAllMatchIn(str)) {
      println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")
    }
  }
}
