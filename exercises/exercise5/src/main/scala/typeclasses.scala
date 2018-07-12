package exercise5

import cats._ // this import brings all typeclasses
import exercise3._

object typeclasses {

  /**
    * create a Functor instance for our binary tree
    */
  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {
    def map[A, B](fa: Tree[A])(f: A => B): Tree[B] =
      exercise3.Tree.map(fa)(f)
  }
}
