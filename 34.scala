/** Digit factorials
  * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
  *
  * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
  *
  * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
  */
val fact = (1 to 9).scanLeft(1)(_ * _)
(for {
  i <- 3 to 10000000
  if i == i.toString.map(c=>fact(c - 48)).sum
} yield i).sum
