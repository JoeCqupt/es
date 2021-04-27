package leetcode

object LC9 {

  def reverse(x: Int): Int = {

    val flag = x >= 0; // 表示是否是正数？
    var param = x;
    var res = 0;
    while (param != 0) {
      val num = param % 10;
      if (flag) {
        if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < num)) {
          return 0;
        }
      } else {
        if (Integer.MIN_VALUE / 10 > res || (Integer.MIN_VALUE / 10 == res && Integer.MIN_VALUE % 10 > num)){
          return 0;
        }
      }
      res = res * 10 + num;
      param = param / 10;
    }

    return res;
  }

}
