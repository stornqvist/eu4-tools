package army {

  sealed trait UnitType {
    def flankingRange: Int // base value for flanking range
  }

  case class f(flankingRange: Int = 1) extends UnitType

  case object INFANTRY extends UnitType {
    val flankingRange = 1
  }

  case object CAVALRY extends UnitType {
    val flankingRange = 2
  }

  case object ARTILLERY extends UnitType {
    val flankingRange = 2
  }

}


