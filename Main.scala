/**
 * Programming Assignment 3 Tasks
 *
 *  Scala functional programming exercises:
 *     data transformations on 2d ArrayBuffer of integers
 *     map, filter, reduce or aggregate
 *
 * Locate <b> TODO </b> in StreamOperation and implement them
 * using functional programming style
 *
 * <p>
 *
 * Note: Scala allows multiple application entry points (main)
 *
 * Command line compilation and execution:
 *  scalac *.scala
 *  scala Main_TestStreams
 *  or
 *  scala Main_TestStreams > output.txt
 *
 */

/**
 * Test suite for testing each TODO function in StreamOperation.scala
 *
 * To run the test (first compile: scalac *.scala), type at command line
 * scala Main_TestStreams
 * */

object Main_TestStreams extends App {

    private val streamOperations = new StreamOperation

    // for testing, add vectors with variable number of integers
    // including empty vectors Vector.empty[Int]
    // even, odd numbers
    // greater than 10, single digits
    // repeating some numbers
    // test with vectors being empty or having 1 integer

    streamOperations.addNumbers_Arr(Vector(1, 6, 8, 5))
    streamOperations.addNumbers_Arr(Vector(12))
    streamOperations.addNumbers_Arr(Vector(8, 2, 7, 11, 17))
    streamOperations.addNumbers_Arr(Vector(4, 4, 4, 13))
    streamOperations.addNumbers_Arr(Vector.empty[Int])
    streamOperations.addNumbers_Arr(Vector(5, 12, 9, 16, 4))

    streamOperations.flatten2DArrayTo1DArrayDistinctSortDescending_s
      .foreach((e: Any) => print("\t" + e))
    println()
    println(f"Sum of all numbers is : ${streamOperations.sumOfAllElements_s}")
    println(f"Average of all numbers is : ${streamOperations.averageOfAllElements_s.getOrElse(None)}")
    println(f"Max of all numbers is :: ${streamOperations.maxOfAllElements_s}")
    println(f"Does any row have a number that is multiple of 5 :: ${streamOperations.existRowWithMultipleOf5_s}")

    println()

    // Testing operations returning one vector
    println("Operations returning a vector (1D array) ---------")
    streamOperations
      .sumOfEachRow_s
      .foreach((e: Int) => println("Sum in each row : " + e))

    println()
    println("--------------------------------------")
    streamOperations
      .maxInEachRow_s
      .foreach(e => println("Max in each row : " + e))

    println()
    println("--------------------------------------")
    streamOperations
      .averageOfEachRow_s
      .foreach(e => println(f"Average in each row : ${e.getOrElse(None)}"))

    println()
    println("--------------------------------------")
    streamOperations
      .averageOfNumbers_gt_10_EachRow_s
      .foreach(e => println(f"Average of numbers (greater than 10) in each row : ${e.getOrElse(None)}"))

    println()
    println("--------------------------------------")
    streamOperations
      .firstSingleDigitInRow_s
      .foreach(e => println("First single digit in each row : " + e))

    println()
    println("Operations returning a 2D array ---------------")

    println()
    System.out.println("Rows with numbers of multiple of 5.")
    streamOperations
      .rowsWithMultipleOf5_s
      .foreach(list => {
          list.foreach((e: Any) => System.out.print("\t" + e))
          System.out.println()
      })

    println()
    println("--------------------------------------")
    System.out.println("Max 2 numbers in each row.")
    streamOperations
      .max2NumbersInEachRow_s
      .foreach(list => {
          list.foreach((e: Any) => System.out.print("\t" + e))
          System.out.println()
      })

    println("--------------------------------------")
    System.out.println("Max 2 even numbers in each row.")
    streamOperations
      .max2_EvenNumbersInEachRow_s
      .foreach(list => {
          list.foreach((e: Any) => System.out.print("\t" + e))
          System.out.println()
      })
}
