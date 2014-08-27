/** Truncatable primes
  *
  * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
  *
  * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
  *
  * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
  */
lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile{j => j * j <= i}.forall{ k => i % k > 0})
val primeSet = primes.takeWhile(_ < 1000000).toSet
(for {
  p <- primes.drop(4).take(100000)
  s = p.toString
  pad = "       ".substring(0, s.size - 2)
  if (pad + s + pad).sliding(s.size - 1).map(_.trim.toInt).toSet.forall(primeSet.contains)
} yield p).sum
