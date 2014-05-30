//Special Pythagorean triplet
Stream.from(2).take(501).combinations(2).map{ case a #:: b #:: Stream.Empty => List(a, b, Math.sqrt(a * a + b * b)) }.dropWhile(_.sum != 1000).next().product.toLong