/** Factorial digit sum
  *
  * n! means n × (n − 1) × ... × 3 × 2 × 1
  *
  * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
  * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
  *
  * Find the sum of the digits in the number 100!
  */
@scala.annotation.tailrec
def factorial(n: Int, z: BigInt = 1): BigInt = if(n == 0) z else factorial(n - 1, z * n)
factorial(100).toString().map(_.asDigit).sum
