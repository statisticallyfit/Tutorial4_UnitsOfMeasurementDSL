# Tutorial, week 4: A DSL challenge

This week's tutorial doesn't come with a repository or a set of tests. For this week, we're going to move up to a more open ended design challenge (as that's what you face in Assignment 2).

And since this week's lectures have covered Domain Specific Languages, let's ask you to create one -- based on the idea in the lecture.

There is a repository at [https://github.com/UNEcosc250/tutorial_units_of_measurement](https://github.com/UNEcosc250/tutorial_units_of_measurement)
that contains a mostly empty project, with mostly empty tests, if you're looking for a blank template to start from.

## Units of Measurement

Units of measurement are fairly well defined -- there is an [SI](https://en.wikipedia.org/wiki/International_System_of_Units) standard that defines seven base measures, and the remaining units are derived from combinations of these.

I would like you to create a module (Object, and child classes) that allows us to say things like:


```scala
val d:Distance = 8.m
```

or

```scala
val v:Velocity = (8.k.m) / (3.hr)
```

## Some hints

There's not just one solution to this problem, but let's give some hints for one way of doing it:

* You'll need a trait for the units.
* Start by creating the base units. And probably start with kg, m, and s. (Get it working for Newtonian physics)
* You'll need composite units that are Divides; you can get away without a Multiplies if the Divides takes several numerators and can have an empty denominator
* You'll need to simplify the units where there's the same unit on both sides of a divide
* You'll need type aliases for the composite units
* You'll need a case class for a measurement (a value and a unit)
* You'll need to define operator methods for your measurements too
* You'll need an implicit class or implicit conversion to give numbers the "k", "m" etc methods
* You'll probably need an intervening class for if someone just says `(8.k)`

And now let's delve further into some of the components you'll need...

## Implicit classes

Implicit conversions and implicit classes allow us to effectively give existing types new methods. For example:

```scala
implicit class ReadyForUnit(val n:Int) extends AnyVal {

  def m = ???

}
```

You can say things like:

```scala
8.m
```

## Methods that look like operators

In Scala, methods can be given symbolic names like `+` and `/`

So for example, this would allow measurements to be added, and type-check that the units are the same

```scala
case class Measurement[U](value: Double, unit:U) {

  def +(otherValue:Measurement[U)) = ???

}
```

If we like, for this exercise we can just have measurements hold Doubles.
But if we wanted, we could let them be defined for any Numeric type.
But `Numeric` isn't a superclass, it's a typeclass, so we would need to define our measurement
to accept "any type that is a numeric", like this:

```scala
  case class Measurement[T : Numeric, U](value:T) {
    def +[TT : Numeric](other:Measurement[TT, U]) = ???
  }

```

(And notice that the + method now accepts another type `TT` because we might add an `Int` measurement to a `Double` measurement)


