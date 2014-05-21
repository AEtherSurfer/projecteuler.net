//Largest prime factor
val target = 600851475143L
val sqrtOfTarget =  Math.sqrt(target)
lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile{j => j * j <= i}.forall{ k => i % k > 0});
primes.takeWhile(_ < sqrtOfTarget).filter(target % _ == 0) toList