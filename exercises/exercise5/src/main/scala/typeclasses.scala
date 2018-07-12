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

  /**
    * create a Foldable instance for our binary tree
    */
  implicit val treeFoldable: Foldable[Tree] = new Foldable[Tree] {
    def foldLeft[A, B](fa: Tree[A], b: B)(f: (B, A) => B): B = fa match {
      case Empty() => b
      case Node(l, a, r) => foldLeft(r, foldLeft(l, f(b, a))(f))(f)
    }

    def foldRight[A, B](fa: Tree[A],lb: Eval[B])(f: (A, Eval[B]) => Eval[B]): Eval[B] = fa match {
      case Empty() => lb
      case Node(l, a, r) => foldRight(l, foldRight(r, f(a, lb))(f))(f)
    }
  }

}
