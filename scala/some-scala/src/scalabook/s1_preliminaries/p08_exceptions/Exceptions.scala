package scalabook.s1_preliminaries.p08_exceptions

import java.io.{FileNotFoundException, IOException}

object Exceptions {

  def openAndReadAFile(fileName: String): Unit = ???

  def closeFile(): Unit = ???

  def main(args: Array[String]): Unit = {
    val fileName = ""
    try {
      openAndReadAFile(fileName);
    } catch {
      case e: FileNotFoundException => println("Couldn't find that file.")
      case e: IOException => println("Had an IOException trying to read that file")
    }finally {
      closeFile();
    }
  }
}
