//Number letter counts
val teensones =
  """
    |one
    |two
    |three
    |four
    |five
    |six
    |seven
    |eight
    |nine
    |ten
    |eleven
    |twelve
    |thirteen
    |fourteen
    |fifteen
    |sixteen
    |seventeen
    |eighteen
    |nineteen""".stripMargin.split("\n").map(x => if (x.isEmpty) None else Some(x))
val ty =
  """
    |
    |twenty
    |thirty
    |forty
    |fifty
    |sixty
    |seventy
    |eighty
    |ninety""".stripMargin.split("\n").map(x => if (x.isEmpty) None else Some(x))
val numStrLists = (1 to 1000).map{ n=>
  f"$n%04d".toList.map(_.asDigit) match {
    case thou :: hund :: ten :: one :: Nil =>
      val thouStr = teensones(thou).map(_ :: "thousand" :: Nil)
      val hundStr = teensones(hund).map(_ :: "hundred" :: Nil)
      val tenStr = ty(ten).map(_ :: Nil)
      val oneStr = ten match {
        case 1 => teensones(10 + one).map(_ :: Nil)
        case _ => teensones(     one).map(_ :: Nil)
      }
      val andStr = if ((hundStr.isDefined || hundStr.isDefined) && (tenStr.isDefined || oneStr.isDefined)) Some("and" :: Nil) else None
      (thouStr :: hundStr :: andStr :: tenStr :: oneStr :: Nil).flatten.flatten
  }
}
numStrLists.map(_.mkString(" ")).foreach(println)
numStrLists.map(_.map(_.size).sum).sum