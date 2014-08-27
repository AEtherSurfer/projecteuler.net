/** Double-base palindromes
  * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
  *
  * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
  *
  * (Please note that the palindromic number, in either base, may not include leading zeros.)
  */
(for {
  n <- Stream.range(1, 1000000)
  s10 = n.toString
  s2  = Integer.toBinaryString(n)
  if s10 == s10.reverse && s2 == s2.reverse
} yield n).sum
