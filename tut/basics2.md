# Pattern matching

##

Pattern matching is a technique used in scala (and other languages) to
compare values against shapes and conditions.  You can think of it
like a more powerful `switch` statement.

##

it's used the following way:

```tut
val a: Int = 3

a match {
  case 3 => "it's three!"
  case _ => "it's not three!"
}
```

## Exhaustivity

One of the cool things of scala's pattern matching is that it has an
exhaustivity checker.  This means that, if we're using pattern
matching agains a `sealed trait`, the compiler will warn if we forget
to match against one of the cases.

## Exhaustivity

```tut:silent
sealed trait Color
case object Blue extends Color
case object Red extends Color
case class Other(name: String) extends Color
```

## Exhaustivity

```tut:silent
val color: Color = Blue
```

## Exhaustivity

WARNING:

```tut
color match {
  case Blue => println("it's blue!")
  case Other(x) => println(s"it's $x!")
}
```

## Destructuring

Destructuring allows us to query inner parts of an ADT

## Destructuring

```tut:silent
sealed trait Vehicle
case class Car(brand: String, model: String, color: Color) extends Vehicle
case class Plane(brand: String, model: String, wingSpan: Int) extends Vehicle
```

## Destructuring

```tut
val vehicle: Vehicle = Car("Honda", "Accord", Red)
```

## Destructuring

```tut
vehicle match {
  case Car(brand, model, Red) => s"it's a red $brand $model"
  case Car(brand, model, Blue) => s"it's a red $brand $model"
  case Car(brand, model, Other(colorName)) => s"it's a $colorName $brand $model"
  case Plane(brand, model, wingSpan) => s"it's a $brand $model with $wingSpan meter of wing span!"
}
```

## Guards

Guards are boolean conditions we want to check in a pattern matching:

## Guards

given

```tut
val plane: Vehicle = Plane("Boeing", "747", 47)
```

## Guards

```tut
plane match {
  case Plane(brand, model, wingSpan) if wingSpan > 40 => s"it's a big $brand $model"
  case Plane(brand, model, wingSpan) if wingSpan <= 40 => s"it's a small $brand $model"
  case _ => s"it's not a plane..."
}
```
