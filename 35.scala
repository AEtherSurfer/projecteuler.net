/** Circular primes
  *
  * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
  *
  * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
  *
  * How many circular primes are there below one million?
  */
lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile{j => j * j <= i}.forall{ k => i % k > 0})
val primeSet = primes.takeWhile(_ < 1000000).toSet
def allRotations(s: String) = (1 to s.size).map(i => (s.substring(s.size - i) + s.substring(0, s.size - i)).toInt).sorted
primeSet.map(_.toString).map(allRotations).filter(_.forall(primeSet.contains)).flatten.size
