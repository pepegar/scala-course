package exercise3

sealed trait Tree[A]
case class Empty[A]() extends Tree[A]
case class Node[A](l: Tree[A], a: A, r: Tree[A]) extends Tree[A]

object Tree {

  /**
    * implement the fold function
    */
  def fold[A, B](tree: Tree[A])(onEmpty: B, onNode: (B, A, B) => B): B = tree match {
    case Empty() => onEmpty
    case Node(left, a, right) => onNode(
      fold(left)(onEmpty, onNode),
      a,
      fold(right)(onEmpty, onNode)
    )
  }

  /**
    * Refactor all the functions we implemented with primitive recursion 
    */
  def height[A](tree: Tree[A]): Int = tree match {
    case Empty() => 0
    case Node(l, _, r) => 1 + (height(l).max(height(r)))
  }

  def sum(tree: Tree[Int]): Int = tree match {
    case Empty() => 0
    case Node(l, x, r) => x + sum(l) + sum(r)
  }

  def count[A](tree: Tree[A]): Int =  tree match {
    case Empty() => 0
    case Node(l, _, r) => 1 + count(l) + count(r)
  }

  def toStringNodes(tree: Tree[Int]): Tree[String] = tree match {
    case Empty() => Empty()
    case Node(l, x, r) => Node(
      toStringNodes(l),
      x.toString,
      toStringNodes(r))
  }

  def squared(tree: Tree[Int]): Tree[Int] = tree match {
    case Empty() => Empty()
    case Node(l, x, r) => Node(
      squared(l),
      x * x,
      squared(r))
  }

}
