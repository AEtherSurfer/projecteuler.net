/** Number spiral diagonals
  * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
  *
  * 21 22 23 24 25
  * 20  7  8  9 10
  * 19  6  1  2 11
  * 18  5  4  3 12
  * 17 16 15 14 13
  *
  * It can be verified that the sum of the numbers on the diagonals is 101.
  *
  * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
  */
lazy val evens = Stream.from(1).map(_<<1).flatMap(x=>List(x,x,x,x))
lazy val diags = Stream.from(1).map(evens.take(_).foldLeft(1L)(_+_))
diags.take(4 * (1001/2)).sum + 1
