
import java.util.{ArrayList, Arrays, List}
import java.util.stream.Collectors
import scala.collection.mutable.ArrayBuffer
import scala.annotation.varargs

class StreamOperation() {
  // Java examples
  private val numbers = new ArrayList[List[Int]]()
  private var row1 = new ArrayList[Int](Arrays.asList(1, 6, 8, 5))
  private var row2 = new ArrayList[Int](Arrays.asList(19, 2, 7, 11))
  private var row3 = new ArrayList[Int](Arrays.asList(15, 4, 3, 13))
  private var row4 = new ArrayList[Int](Arrays.asList(14, 12, 9, 16))
  numbers.add(row1)
  numbers.add(row2)
  numbers.add(row3)
  numbers.add(row4)

  // Scala functional programming exercises:
  //    data transformations on 2d ArrayBuffer of integers
  //    map, filter, reduce or aggregate

  // TODO You MUST use pure functional programming for implementing
  // the functions below for the TODO sections

  // Member variable that holds a 2D number array
  // Some operation implementations are given below to
  // demonstrate the use of pure functional programming for
  // data transformations

  // Search TODO below for the operations to be implemented by you
  // Note ArrayBuffer is mutable, while Vector is immutable
  private val numbers_2d = ArrayBuffer.empty[Vector[Int]]

  // Add a row (vector) to the 2D array
  // Note: arr argument could be empty vector, Vector.empty[Int]
  def addNumbers_Arr(vector : Vector[Int]): Unit = {
    numbers_2d += vector
  }

  // Java
  def sumOfAllElements(): Int = {
    numbers
      .stream()
      .flatMap(list => list.stream())
      .mapToInt(integer => integer.intValue())
      .sum()
  }

  // Scala
  /**
   * @return Sum of all numbers in all rows / vectors in the array
   *
   *         Note: an empty vector would have a sum of zero
   * @param
   * */
  def sumOfAllElements_s : Int = {
    numbers_2d
      .flatten.sum // flatMap, then sum
  }

  // Java
  def flatten2DArrayTo1DArray() : List[Int] = {
    numbers
      .stream()
      .flatMap(list => list.stream())
      .collect(Collectors.toList())
  }

  // Scala
  /**
   * @return Array of distinct numbers from all rows / vectors
   *
   * @param
   * */
  def flatten2DArrayTo1DArrayDistinct_s : Vector[Int] = {
    // flatMap followed by distinct
    numbers_2d.flatten.distinct.toVector
  }

  /**
   * @return Array of distinct numbers in descending order from all rows / vectors
   *
   * @param
   * */
  def flatten2DArrayTo1DArrayDistinctSortDescending_s : Vector[Int] = {
    // TODO
    // hint: flatMapping, apply distinct,
    // then use either sorted, sortBy, or sortWith for sorting
    // then convert to Vector to return
    val flattened = numbers_2d.flatten.distinct.sorted(Ordering[Int].reverse).toVector
    return flattened
  }

  // Java
  def averageOfAllElements(): Double = {
    numbers
       .stream()
       .flatMap(list => list.stream())
       .mapToInt(integer => integer.intValue())
       .average()
       .orElse(0)
  }

  // Scala
  /**
   * @return Average of numbers from all rows / vectors
   *
   * @param
   * */
  def averageOfAllElements_s : Option[Double] = {
    val flattened = numbers_2d.flatten // flatMap
    flattened.length match {
      // Some and None are subclasses of Option
      case 0 => None // length of the combined array is zero
      case _ => Some (flattened.sum.toDouble / flattened.length)
    }
  }

  // Java
  def maxOfAllElements(): Int = {
    numbers
       .stream()
       .flatMap(list => list.stream())
       .mapToInt(integer => integer.intValue())
       .max()
       .orElse(0)
  }

  // Scala
  /**
   * @return max number from all rows / vectors
   *
   * @param
   * */
  def maxOfAllElements_s : Option[Int] = {
    // TODO

    // hint: first, do flatMapping. After flatmapping:
    // if there are numbers in the flattened collection, use max method;
    // otherwise, return None, note using max on an empty array will
    // throw an exception

    // refer to averageOfAllElements_s on dealing with empty row / vector

    val flattened = numbers_2d.flatten
    flattened.length match {
      case 0 => None 
      case _ => Some (flattened.max)
    }

  }

  // Java
  def sumOfEachRow(): List[Int] = {
     numbers
       .stream() // since each row is a list or a collection you can invoke stream api on each row
       .map[Int](list => list.stream()
         // mapToInt changes Stream<Integer> to IntStream which has built in methods like sum
         .mapToInt(value => value.intValue())
         .sum())
       .collect(Collectors.toList())
  }

  // Scala
  /**
   * @return Array of sums of each row / vector
   *
   * @param
   * */
  def sumOfEachRow_s : Vector[Int] = {
    numbers_2d
      .map(vector => vector.sum).toVector
  }

  // Java
  def maxInEachRow(): List[Int] = {
    numbers
       .stream()
       .map[Int](list => list // since each row is a list or a collection you can invoke stream api on each row
          .stream()
          .mapToInt(value => value.intValue()) // mapToInt changes Stream<Integer> to IntStream which has built in methods like max
          .max()
          .orElse(0))
       .collect(Collectors.toList())
  }

  // Scala
  /**
   * @return Array of max number of each row / vector
   *         Note: each vector could be empty
   * @param
   * */
  def maxInEachRow_s : Vector[Option[Int]] = {

    // hint: use map operation
    // combine the approach in sumOfEachRow_s and averageOfAllElements_s
    // note there could be empty vectors and using max on an empty vector
    // will result in exception

    numbers_2d
      .map(vector => {
        vector.nonEmpty match
        {
          case true => Some(vector.max)
          case false => None
        }
      }).toVector
  }

  // Java
  def averageOfEachRow(): List[Double] = {
    numbers
       .stream()
       .map[Double](list => list // since each row is a list or a collection you can invoke stream api on each row
          .stream()
          .mapToInt(value => value.intValue()) // mapToInt changes Stream<Integer> to IntStream which has built in methods like max
          .average()
          .orElse(0))
       .collect(Collectors.toList())
  }

  // Scala
  /**
   * @return Array of average of each vector in the array
   *         Note: each vector could be empty
   * @param
   * */
  def averageOfEachRow_s : Vector[Option[Double]] = {
    // TODO

    // see hint in maxInEachRow_s
    val avgs = numbers_2d
      .map(vector => {
        vector.nonEmpty match
        {
          case true => Some(vector.sum.toDouble/vector.size)
          case false => None
        }
      }).toVector
      
    return avgs
  }

  /**
   * @return Array of average of each row / vector
   * map each nnnn> 10) numbers in the row / vector, average should be None
   *         Note: each vector could be empty
   * @param
   * */
  def averageOfNumbers_gt_10_EachRow_s : Vector[Option[Double]] = {

    // TODO
    // hint: see implementation approach in maxInEachRow_s
    // add filtering for getting the numbers > 10 in the vector
    // then if there are numbers in the vector bigger than 10,
    //   calculate for average
    //   otherwise, use None

    val avgs = numbers_2d
      .map(vector => {
        val overTen = vector.filter(_ > 10)
        if (overTen.nonEmpty)
          Some(overTen.sum.toDouble / overTen.size)
        else
          None
      }).toVector

    return avgs


  }

  // Java
  def firstSingleDigitInRow(): List[Int] = {
    numbers
       .stream()
       .map[Int](list => list // since each row is a list or a collection you can invoke stream api on each row
          .stream()
          .filter(e => e < 10)
          .findFirst() // return the first element that stream encounters
          .orElse(0)) // if no element is found return 0
       .collect(Collectors.toList())
  }

  // Scala
  /**
   * @return Array of first single digit number (< 10) of each vector
   *         map each vector to the first single digit number (< 10)
   *         if there are no single digit (< 10) numbers in a vector, use None
   *
   *         Note: each vector could be empty
   * @param
   * */
  def firstSingleDigitInRow_s : Vector[Option[Int]] = {

    // TODO

    // hint: see implementation approach in maxInEachRow_s
    // need to add filtering for getting the numbers < 10 in the vector
    // then if there are numbers in the vector less than 10,
    //   use take method to grab the first single digit number
    //   otherwise, use None

   val singleDigits = numbers_2d
      .map(vector => {

        val underTen = vector.filter(_ < 10)
        underTen.nonEmpty match
        {
          case true => Some(underTen.head)
          case false => None
        }
      }).toVector
    
    return singleDigits
  }

  // Java
  def existRowWithMultipleOf5(): Boolean = {
    numbers
       .stream()
       .anyMatch(integers => integers // returns true if any one element passing the condition is found;
          .stream()
          .anyMatch(integer => integer % 5 == 0))
  }

  // Scala
  /**
   * @return Boolean, whether any row has a number that is a multiple of 5
   *
   * @param
   * */
  def existRowWithMultipleOf5_s : Boolean = {
    numbers_2d
      .exists(vector => vector
         .exists(i => i % 5 == 0))
  }

  /**
   * @return Array of all rows that have multiple of 5 number/numbers
   *
   * @param
   * */
  def rowsWithMultipleOf5_s : Vector[Vector[Int]] = {
    // TODO

    // hint: use filter and see existRowWithMultipleOf5_s above

    numbers_2d
      .filter(row => row.exists(_ % 5 == 0))
        .toVector
    
  }

  /**
   * @return Array of the max two numbers of row with the max number first
   *
   * @param
   * */
  def max2NumbersInEachRow_s : Vector[Vector[Int]] = {

    // TODO

    // hint: see implementation approach in maxInEachRow_s
    // sort each row in descending order, then
    //   use take method to grab the first two numbers

    numbers_2d
      .map(vector => {
        vector.sorted(Ordering[Int].reverse).take(2)
      }).toVector

  }

  /**
   * @return Array of the max two EVEN numbers of row with the max number first
   *
   * @param
   * */
  // map each vector in ArrayBuffer to the biggest 2 even integers in the vector
  // filter, sort, then take the top 2 integers
  def max2_EvenNumbersInEachRow_s : Vector[Vector[Int]] = {

    // TODO

    // hint:
    // filter for all even numbers for each row / vector
    // then sort in descending order, then
    // use take method to grab the first two numbers

    numbers_2d
      .map(vector => {
        vector.filter(_ % 2 == 0).sorted(Ordering[Int].reverse).take(2)
      }).toVector


  }

}