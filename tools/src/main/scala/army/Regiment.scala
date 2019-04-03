package army

import datatypes.TechGroup

class Regiment(val ATTACK_MORALE_BONUS: Double,
               var strength: Int,
               val unit: MilitaryUnit,
               val tech: TechGroup) {

  var currentMorale: Double = 0
  var bufferedMorale: Double = 0
  var bufferedCasualties: Int = 0

  def takeAttrition(attrition: Double): Unit = {
    strength = (strength * (1.0 - attrition)).toInt
  }

  def reinforce(rate: Double): Unit = {
    strength += (1000 * rate).toInt
    if (strength > 1000) strength = 1000
  }

  override def toString: String = {
    s"$strength $unit"
  }
}
