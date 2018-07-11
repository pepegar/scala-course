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

  /**
    * reimplement this function using option
    */
  val element = if (maybeString == null) {
    null
  } else {
    maybeString
  }
}
