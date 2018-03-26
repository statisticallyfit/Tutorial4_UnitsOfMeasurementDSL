# Tutorial, week 4: A DSL challenge

This week's tutorial is designed to be optional -- there's an assignment due soon.

It's quite short, but will ask you to exercise what you've learnt about implicit 
conversions to create a *domain specific language*.

In this tutorial, we'll play around with implicits to see if we can get
an equation for Volts, Watts, Amps, and Ohms working.
SI units is actually quite a hard problem, so we're not going to go very far.
We're just going to get the equation from the lecture working.

First, we'll do an example with prefixes (eg, "milli" for thousandths), where
I've provided the class but not the implicit conversion function.

Then we'll do one that sets up equations with units -- I've written the
machinery for handling the units, but you'll need to define a class and an
implicit conversion so that you can make things like
3.pico.Watts
compile

As we need to implement the language to get your code to compile, it doesn't use unit
tests. (If the code doesn't compile, tests can't run anyway). Instead, the SI class 
extends App so you can run it directly.


