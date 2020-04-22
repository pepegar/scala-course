---
title: Implicits
author: Pepe García
date: 2020-04-20
subject: Scala
keywords: [FP, Scala]
lang: "en"
---

# Implicits

Implicits provide us the ability to pass arguments to function in an
_implicit_ way.

The simplest way for understanding them is to see a simple example:

```scala mdoc
implicit val name: String = "Pepe"

def printImplicitName(implicit name: String): Unit =
  println("Hello " + name)

printImplicitName
```

# Implicits

## But, how does it work?

When finding an implicit parameter, Scala will look for candidates for
the given type in:

- The lexical scope, as any other variable
- The implicit scope
- The companion object of the datatype
- The companion object of the typeclass
- In the imports

[reference][] in the Scala docs.

[reference]: https://docs.scala-lang.org/tutorials/FAQ/finding-implicits.html


# Applications

# Implicit conversions

One of the most used features of implicits are implicit conversions.
Using implicit conversions, we'll be able to use values of a type as
values of other type **if there's an implicit conversion between
them**.

We'll declare implicit conversions as `implicit def`.

# Implicit conversions

```scala mdoc
import java.util.UUID

implicit def uuidAsString(uuid: UUID): String =
  uuid.toString

val id: UUID = UUID.randomUUID

def printString(str: String): Unit =
  println(str)

printString(id)
```

# Datatype expansion

> AKA: Pimp My Library

# Datatype expansion

We'll use datatype expansion when we want to add new methods to
datatypes we don't control.

As an example... let's copy Ruby's `n.times do...` pattern.

```scala mdoc:fail
5.times {
  println("it worked!")
}
```

# Datatype expansion

We can add new methods to a datatype we don't control using `implicit
classes`:

```scala mdoc
implicit class IntTimes(val x: Int) {
  def times(action: => Unit): Unit = {
    (1 to x).foreach(_ => action)
  }
}
```

# Datatype expansion

```scala mdoc
5.times {
  println("it worked!")
}
```

# Typeclasses

We've already mention [typeclasses previously][typeclasses], but let's
refresh it.

Other languages such as Haskell, have typeclasses built into the
language, but we don't have that in Scala, we need to emulate them.
The most common way of using typeclasses in Scala is by passing their
instances as implicit parameters.

[typeclasses]: https://github.com/pepegar/scala-course/blob/master/slides/typeclasses.pdf
