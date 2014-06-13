/** Amicable numbers
  *
  * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
  * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
  *
  * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
  *
  * Evaluate the sum of all the amicable numbers under 10000.
  */
lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile{j => j * j <= i}.forall{ k => i % k > 0})
def primeFactors(i: Long, z: List[Long] = Nil): List[Long] = {
  if ( i < 2) return Nil
  val factor = primes.dropWhile(i % _ != 0)(0)
  if (factor == i) factor :: z
  else primeFactors(i/factor, factor :: z)
}
def properDivisors(n: Long): Seq[Long] = {
  val fs = primeFactors(n)
  (1 until fs.size).flatMap(fs.combinations).map(_.product) :+ 1L
}
val properDivisorSums = (1L until 10000).map(x => (x, properDivisors(x).sum))
properDivisorSums.filter{case (a, b) => a != b && properDivisorSums.contains((b,a))}.map(_._1).sum
