import army.Army
import datatypes.{Fort, MilTechModifier}
import util.Dice

import scala.util.Random

class SiegeSimulator(fort: Fort, army: Army, attackerTech: MilTechModifier, blockadeImpact: Int) {

  private val phaseLength: Int = (30 + (30 * fort.defensiveness) - (30 * army.siegeAbility)).toInt
  private val startingBonus: Int = -fort.fortLevel + army.getArtilleryBonus(fort.fortBuildingLevel) + army.general.siege + blockadeImpact

  val seed: Long = 9128736712903876L
  private val dice: Dice = new Dice(new Random(seed))

  /** helper function for recursive siege */
  def siege: Int ={
    siege(0,0,0)
  }

  /** tail-recursive function for siege simulation
    * @param phaseCount number of phases that the siege has proceeded
    * @param siegeStatus starts at 0, max 12/13/14/15 depending on attacker max fort level
    * @param wallsBreached starts at 0, max 3
    * @return elapsed time until surrender
    */
  private def siege(phaseCount: Int, siegeStatus: Int, wallsBreached: Int): Int = {
    // check army size > garrison size else siege progress stops


    // take 1% attrition


    // dice roll (1-14)
    val roll = dice.random(1 to 14)

    // apply modifiers
    val modifiedRoll = roll + army.general.siege + army.getArtilleryBonus(fort.fortBuildingLevel) + blockadeImpact + wallsBreached

    // check for surrender
    if (modifiedRoll >= 20) {
      return phaseCount*phaseLength
    }

    // check for effects
    val tuple = if (roll == 1) {
      diseaseOutbreak()
      (phaseCount, siegeStatus, wallsBreached)
    }

    // check for breach
    else if((roll + (army.getArtilleryBonus(fort.fortBuildingLevel) + fort.obsoleteFort(attackerTech) ) /
      3 + fort.getMaxFortBuildingLevel(attackerTech) / 10 ) >= 14) {
      (phaseCount, siegeStatus + 2, wallsBreached + 1)
    }

    else {
      val (siegeStatusIncrement, garrisonUpdateModifier) = modifiedRoll match {
        case n if n <= 4 => (0, 0.0) // status quo
        case n if 5 to 11 contains n => suppliesShortage()
        case n if 12 to 13 contains n => foodShortage()
        case n if 14 to 15 contains n => waterShortage()
        case n if 16 to 19 contains n => defendersDesert()
      }
      fort.updateGarrisonSize(garrisonUpdateModifier)
      (phaseCount, siegeStatus + siegeStatusIncrement, wallsBreached)
    }

    siege(tuple._1 + 1, tuple._2, tuple._3)
  }

  private def diseaseOutbreak() {
    army.applyAttrition(0.05)
  }
  private def suppliesShortage(): (Int, Double) = {
    (1, 0.01)
  }
  private def foodShortage(): (Int, Double) = {
    (2, 0.03)
  }
  private def waterShortage(): (Int, Double) = {
    (3, 0.05)
  }
  private def defendersDesert(): (Int, Double) = {
    (2, 0.1)
  }
}
