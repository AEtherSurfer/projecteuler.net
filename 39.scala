/** Integer right triangles
  *
  * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
  *
  * {20,48,52}, {24,45,51}, {30,40,50}
  *
  * For which value of p ≤ 1000, is the number of solutions maximised?
  */
(for {
  p <- 12 until 1000
  mc = p/2
  c <- 1 to mc
  b <- 1 to mc
  a = p - b - c
  if a == math.sqrt(c * c + b * b)
} yield Seq(a,b,c,p).sortBy(-_)).toSet.groupBy{x: Seq[Int] => x.head}.map {case (k, v) => (k, v.size)}.toSeq.sortBy{x: (Int, Int)=> -x._2}
