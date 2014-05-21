//Even Fibonacci numbers
val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
val fibsEven = fibs.filter(_ % 2 == 0)
fibsEven.takeWhile(_ < 4000000).sum
