//Smallest multiple
lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile{j => j * j <= i}.forall{ k => i % k > 0})
def primeFactors(i: Int, z: List[Int] = Nil): List[Int] = {
  val factor = primes.dropWhile(i % _ != 0)(0)
  if (factor == i) factor :: z
  else primeFactors(i/factor, factor :: z)
}
val twoToTwenty = 2 to 20
val factorQty = twoToTwenty.map(primeFactors(_, Nil).reverse).map(_.groupBy(identity).mapValues(_.size))
val allFactors = factorQty.fold(Map.empty)((x,y)=>(x.keySet++y.keySet).foldLeft(Map.empty[Int, Int])((z: Map[Int, Int], k:Int) => z + (k -> Math.max(x.getOrElse(k,0), y.getOrElse(k,0)))))
allFactors.fold(1){ case (z: Int, (k: Int, v: Int)) => z * Math.pow(k, v).toInt}
