package s14_singleton_objects

object Logger {
  def info(message: String): Unit = println(s"INFO $message")
}
