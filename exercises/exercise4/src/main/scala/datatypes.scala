package exercise4

import java.util.Random
import scala.util.Try

object option {
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

  /**
    * reimplement this using try
    */
  def useTry = Try(stringOrThrow)



  case class Client()
  case class User()

  /**
    * reimplement using Either[User, Client]
    */
  def userOrClient: Either[User, Client] = if (hasBoughtBefore) {
    Right(Client())
  } else {
    Left(User())
  }

}
