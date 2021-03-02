package tour.s12_case_classes

object CaseClasses {

  //p020 case class 案例类: 案例类非常适合用于不可变的数据

  case class Book(isbn: String)

  case class VarBook(var isbn: String)

  case class Message(sender: String, recipient: String, body: String)

  def main(args: Array[String]): Unit = {
    // 差异点：注意在实例化案例类Book时，并没有使用关键字new，这是因为案例类有一个默认的apply方法来负责对象的创建。
    val frankenstein = Book("978-0486282114")
    // 当你创建包含参数的案例类时，这些参数是公开（public）的val
    println(frankenstein.isbn)

    // 在案例类中使用var也是可以的，但并不推荐这样!!!!!!
    val testBook = VarBook("test-isbn")
    testBook.isbn = "test-isbn2"
    println(testBook)

    //比较 ：案例类在比较的时候是按值比较而非按引用比较
    val message1 = Message("joe", "yss", "ilu")
    val message2 = Message("joe", "yss", "ilu")
    println(message1 == message2) // true  message1和message2指向两个不同的地址

    //拷贝 ： 你可以通过copy方法创建一个案例类实例的浅拷贝，同时可以指定构造参数来做一些改变。
    val message4 = Message("joe@maoyan.com", "yss@gmail.com", "iloveu");
    val message5 = message4.copy(sender = message4.recipient, recipient = message4.sender);
    println(message5)
  }
}
