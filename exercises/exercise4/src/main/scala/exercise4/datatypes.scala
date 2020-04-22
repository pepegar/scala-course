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
      case e: Throwable => throw e
    }

}
