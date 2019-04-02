package army

import datatypes.{TechGroup}

class Regiment(val ATTACK_MORALE_BONUS: Double,
               val strength: Int,
               val unit: MilitaryUnit,
               val tech: TechGroup) {

  var currentMorale: Double = 0
  var bufferedMorale: Double = 0
  var bufferedCasualties: Int = 0

}
