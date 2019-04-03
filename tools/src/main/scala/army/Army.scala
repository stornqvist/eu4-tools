package army

import datatypes.MilTechModifier

class Army(var general: General, technology: MilTechModifier, var regiments: Array[Regiment]) {

  /** returns artillery bonus */
  def getArtilleryBonus(fortBuildingLevel: Int): Int = {
    regiments.count(_.unit.`type` == ARTILLERY) / (fortBuildingLevel + 1) match {
      case bonus if bonus > 5 => 5
      case bonus => bonus
    }
  }

  /** apply attrition damage, make sure it happens before reinforcements */
  def applyAttrition(percentage: Double) {
    regiments.foreach(_.takeAttrition(percentage))
  }

  /** merge two armies, assuming same MilTechLevel */
  def merge(army: Army): Army = {
    regiments = regiments ++ army.regiments
    general = if(general.sumOfPips >= army.general.sumOfPips) general else army.general
    this
  }

  /** reinforces regiments */
  def reinforce(rate: Double): Army = {
    regiments.foreach(_.reinforce(rate))
    this
  }

  override def toString: String = {
    s"$general with $technology \n ${regiments.toList}"
  }
}
