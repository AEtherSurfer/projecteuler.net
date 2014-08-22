/** Digit fifth powers
  * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
  *
  * 1634 = 1^4 + 6^4 + 3^4 + 4^4
  * 8208 = 8^4 + 2^4 + 0^4 + 8^4
  * 9474 = 9^4 + 4^4 + 7^4 + 4^4
  *
  * As 1 = 1^4 is not a sum it is not included.
  *
  * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
  *
  * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
  */
var s = System.nanoTime()
(2 until 1000000).filter(x => x.toString.map(c => Math.pow(c.asDigit, 5)).sum == x).sum
(System.nanoTime() - s) / 1000000
s = System.nanoTime()
(2 until 1000000).filter(x => x.toString.map(_.asDigit).map(Math.pow(_, 5)).sum == x).sum
(System.nanoTime() - s) / 1000000
s = System.nanoTime()
(2 until 1000000).filter(x => x.toString.map(_.asDigit).map(d => d * d * d * d * d).sum == x).sum
(System.nanoTime() - s) / 1000000
s = System.nanoTime()
(2 until 1000000).filter(x => x.toString.map{c => val d = c.asDigit; d * d * d * d * d}.sum == x).sum
(System.nanoTime() - s) / 1000000
s = System.nanoTime()
(2 until 1000000).filter(x => x.toString.map{c => val d = c.toInt-48; d * d * d * d * d}.sum == x).sum
(System.nanoTime() - s) / 1000000
