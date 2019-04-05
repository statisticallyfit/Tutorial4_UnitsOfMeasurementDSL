package cosc250.lectures4

/**
  *
  */
object OnePlusDSL {
	//GOAL: make "one" plus "one" equals "two" compile

	val wordToNum = Map("one" -> 1, "two" -> 2, "three" -> 3)
	val numToWord = wordToNum map {case (k, v) => (v, k)}

	// Defining the functionality
	class AddString(s: String) {
		def plus(that: String): String = {
			numToWord( wordToNum(s) + wordToNum(that) )
		}
	}

	// implicit conversion
	implicit def strToAddStringType(s: String) = new AddString(s)

	def main(args: Array[String]) {
		assert("one" plus "one" equals "two")
		assert("one" plus "two" equals "three")
	}
}
