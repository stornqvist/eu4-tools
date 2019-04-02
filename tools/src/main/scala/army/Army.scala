package army

import datatypes.{MilTechModifier, TechGroup}

class Army(var general: General, technology: MilTechModifier, var regiments: Array[Regiment]) {

  val siegeAbility: Double = 0.1 // TODO: Calculate siegeAbility

  /** returns artillery bonus */
  def getArtilleryBonus(fortBuildingLevel: Int): Int = {
    regiments.count(_.unit.`type` == ARTILLERY) / (fortBuildingLevel + 1) match {
      case bonus if bonus > 5 => 5
      case bonus => bonus
    }
  }

  /** apply attrition damage, make sure it happens before reinforcements */
  def applyAttrition(percentage: Double) {
    // TODO: does not update value
    regiments.map(_.strength * (1.0 - percentage))
  }

  /** merge two armies, assuming same MilTechLevel */
  def merge(army: Army): Army = {
    regiments = regiments ++ army.regiments
    general = if(general.sumOfPips >= army.general.sumOfPips) general else army.general
    this
  }


}
