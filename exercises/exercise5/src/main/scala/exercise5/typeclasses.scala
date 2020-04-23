package exercise5

import cats._ // this import brings all typeclasses
import exercise3._
import scala.annotation.tailrec

object typeclasses {

  /**
    * create a Functor instance for our binary tree
    */
  implicit val treeFunctor: Functor[Tree] = ???

}
