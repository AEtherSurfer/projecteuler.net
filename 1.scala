//Multiples of 3 and 5
object Main extends App {
  1 until 1000 filter(x=>x%3==0 || x%5==0) sum
  (3 until 1000 by 3 sum) + (5 until 1000 by 5 sum) - (15 until 1000 by 15 sum)
  Set() ++ (3 until 1000 by 3) ++ (5 until 1000 by 5) sum
  def threeFive(r:Int, s:Int, n:BigInt) = {
    val multR = (n-1)/r
    val totalR = r*multR*(multR+1)/2
    val multS = (n-1)/s
    val totalS = s*multS*(multS+1)/2
    val multRS = (n-1)/(s*r)
    val totalRS = s*r*multRS*(multRS+1)/2
    totalR + totalS - totalRS
  }
  threeFive(3,5,BigInt("1000000000000000000000000000000000000000000000000000000"))
}