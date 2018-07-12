package exercise5

import cats._ // this import brings all typeclasses
import exercise3._
import scala.annotation.tailrec

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

  /**
    * create a Monad instance for Maybe
    */
  sealed trait Maybe[A]
  case class Nothing[A]() extends Maybe[A]
  case class Just[A](a: A) extends Maybe[A]

  implicit val maybeMonad: Monad[Maybe] = new Monad[Maybe] {
    def pure[A](x: A): Maybe[A] = Just(x)
    def flatMap[A, B](fa: Maybe[A])(f: A => Maybe[B]): Maybe[B] = fa match {
      case Nothing() => Nothing[B]()
      case Just(a) => f(a)
    }

    @tailrec
    def tailRecM[A, B](a: A)(f: A => Maybe[Either[A, B]]): Maybe[B] =
      f(a) match {
        case Nothing() => Nothing()
        case Just(Left(a1)) => tailRecM(a1)(f)
        case Just(Right(b)) => Just(b)
      }
  }

  /**
    * Parametrize the following functions to work on typeclasses, not
    * directly on trees.
    */
  def sum[F[_]](f: F[Int])(implicit F: Foldable[F]): Int =
    F.foldLeft(f, 0)(_ + _)

  def count[F[_], A](f: F[A])(implicit F: Foldable[F]): Int =
    F.foldLeft(f, 0)((acc, c) => acc + 1)

  def toStringNodes[F[_]](f: F[Int])(implicit F: Functor[F]): F[String] =
    F.map(f)(_.toString)

  def squared[F[_]](f: F[Int])(implicit F: Functor[F]): F[Int] =
    F.map(f)(x => x * x)

  /**
    * Abstract this function further
    */
  def sumX[F[_], A](f: F[A])(implicit F: Foldable[F], A: Monoid[A]): A =
    F.foldLeft(f, A.empty)((x, y) => A.combine(x, y))

}
