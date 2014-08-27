/** Champernowne's constant
  *
  * An irrational decimal fraction is created by concatenating the positive integers:
  *
  * 0.123456789101112131415161718192021...
  *
  * It can be seen that the 12th digit of the fractional part is 1.
  *
  * If dn represents the nth digit of the fractional part, find the value of the following expression.
  *
  * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
  */
lazy val c = Stream.from(0).map(_.toString).flatten.map(_-48)
(0 to 6).map(math.pow(10,_).toInt).map(c.drop(_).head).product
