//Longest Collatz sequence
def collatz(n: Long): List[Long] = {
  if (n < 1) throw new IllegalArgumentException(s"n($n) must be positive")
  if (n == 1) 1 :: Nil
  else {
    if (n % 2 == 0) n :: collatz(n/2)
    else n :: collatz(3 * n + 1)
  }
}
(1 until 1000000).map(i=> (i, collatz(i).size)).maxBy(_._2)
