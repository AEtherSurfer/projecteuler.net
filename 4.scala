//Largest palindrome product
val threeDigitNumbers = 100 to 999
val products = for {
  a <- threeDigitNumbers
  b <- threeDigitNumbers
} yield a * b
val palindromes = products.map(_.toString).filter(s => s == s.reverse)
palindromes.map(_.toLong).max