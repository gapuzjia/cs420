object TestScript extends App {
  println("✅ Scala setup is working!")

  val numbers = List(1, 2, 3, 4, 5)
  val sum = numbers.sum
  println(s"The sum of $numbers is: $sum")

  def greet(name: String): String = s"Hello, $name!"
  println(greet("Jia"))
}
