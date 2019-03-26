package cosc250.tutorial4

import org.scalatest._

import cosc250.tutorial4.SI._


/**
  *
  */
class Tutorial4Spec extends FlatSpec with Matchers {

  "you" should "write some tests for your code and delete this"  in {
    true should be (true)
  }


  "VecOps" should "add two Vec2D" in {
    import PartOne._

    (1.0, 2.0) + (3.0, 4.0) should be ((4.0, 6.0))
  }

  it should "subtract one Vec2D from another" in {
    import PartOne._

    (1.0, 2.0) - (3.0, 4.0) should be ((-2.0, -2.0))
  }

  it should "multiply a Vec2D by a scalar" in {
    import PartOne._

    (1.0, 2.0) * 3 should be ((3.0, -6.0))
  }

  it should "take the magnitude of a Vec2D" in {
    import PartOne._

    (3.0, 4.0).magnitude should === (5.0 +- 0.1)
  }
}
