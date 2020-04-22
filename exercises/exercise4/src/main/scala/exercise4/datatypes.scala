package exercise4

import java.util.Random
import scala.util.Try

object Exercise4 {
  val random = new Random

  val maybeString =
    if (random.nextBoolean) {
      "it's not null"
    } else {
      null
    }

  val stringOrThrow =
    if (random.nextBoolean) {
      "it's not null"
    } else {
      throw new Exception("oh oh")
    }

  val hasBoughtBefore = random.nextBoolean

  /**
    * reimplement this using Option
    */
  def useOption = Option(maybeString)

}
