package datatypes

class Fort(val fortLevel: Int, val defensiveness: Double, val garrisonModifier: Double) {

  var garrisonSize: Int = math.round(fortLevel * 1000 * (garrisonModifier + 1.0)).toInt
  val fortBuildingLevel: Int = fortLevel / 2

  def updateGarrisonSize(modifier: Double) {
    garrisonSize = math.round(garrisonSize * modifier).toInt
  }

  def obsoleteFort(techAttacker: MilTechModifier): Int = {
    getFortTechLevel(techAttacker).buildingLevel - fortBuildingLevel
  }

  def getFortTechLevel(techLevel: MilTechModifier): FortTechLevel = {
    techLevel.level match {
      case lvl if lvl < 14 => CASTLE
      case lvl if lvl < 19 => BASTION
      case lvl if lvl < 24 => STAR_FORT
      case _ => FORTRESS
    }
  }

  def getMaxFortBuildingLevel(techLevel: MilTechModifier): Int = {
    getFortTechLevel(techLevel).buildingLevel
  }
}

sealed abstract class FortTechLevel(val techLevel: Int, val buildingLevel: Int)

case object CASTLE extends FortTechLevel(1, 1)
case object BASTION extends FortTechLevel(14, 2)
case object STAR_FORT extends FortTechLevel(19, 3)
case object FORTRESS extends FortTechLevel(24, 4)
