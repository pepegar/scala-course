package exercise4

import java.util.Random

object option {

  val maybeString = {
    val random = new Random

    if (random.nextBoolean) {
      "it's not null"
    } else {
      null
    }
  }

  val stringOrThrow = {
    val random = new Random

    if (random.nextBoolean) {
      "it's not null"
    } else {
      throw new Exception("oh oh")
    }
  }

  /**
    * reimplement this using Option
    */
  def useOption = Option(maybeString)

  /**
    * reimplement this using try
    */
  def useTry = try {
    stringOrThrow
  } catch {
    case e: Exception => throw e
  }

}
