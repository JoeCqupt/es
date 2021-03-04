package main.scalabook.s1_preliminaries.p09_class

trait TailWagger {
  def startTail(): Unit = println("tail is wagging")

  def stopTail(): Unit = println("tail is stopped")
}

trait Runner {
  def startRunning(): Unit = println("I'm running")

  def stopRunning(): Unit = println("Stopped running")
}

class Dog(val name: String)

object Clazz {

  def main(args: Array[String]): Unit = {
    // 即时混合特征
    val dog = new Dog("fido") with TailWagger with Runner
    dog.startRunning()
  }


}

