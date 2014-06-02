//Highly divisible triangular number
lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile{j => j * j <= i}.forall{ k => i % k > 0})
def primeFactors(i: Long, z: List[Long] = Nil): List[Long] = {
  val factor = primes.dropWhile(i % _ != 0)(0)
  if (factor == i) factor :: z
  else primeFactors(i/factor, factor :: z)
}
def triangles = new Iterator[Long] {
  private var i, t = 1
  def hasNext = !((t + i) < 0)
  def next() = { val result = t; i += 1; t += i; result }
}
def divisorsQty(n: Long) = {
  val fs = primeFactors(n)
  (1 to fs.size).flatMap(fs.combinations).size + 1
}
triangles.drop(1).dropWhile(divisorsQty(_) < 500).next()
