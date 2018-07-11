package exercise5

import cats._ // this import brings all typeclasses
import exercise3._

object typeclasses {

  /**
    * create a Functor instance for our binary tree
    */
  implicit val treeFunctor: Functor[Tree] = ???
}
