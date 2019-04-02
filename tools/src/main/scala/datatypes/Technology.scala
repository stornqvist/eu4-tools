package datatypes

class Technology {
}

  sealed trait TechGroup

    case object OTTOMAN extends TechGroup
    case object CHINESE extends TechGroup
    case object EASTERN extends TechGroup
    case object HIGHAMERICAN extends TechGroup
    case object INDIAN extends TechGroup
    case object MESOAMERICAN extends TechGroup
    case object MUSLIM extends TechGroup
    case object NOMAD extends TechGroup
    case object NORTH_AMERICAN extends TechGroup
    case object SOUTH_AMERICAN extends TechGroup
    case object SUB_SAHARAN extends TechGroup
    case object WESTERN extends TechGroup

  sealed abstract class MilTechModifier(val level: Int,
                                        val morale: Double,
                                        val tactics: Double,
                                        val combatWidth: Int,
                                        val flankingRange: Double,
                                        val infantryFire: Double,
                                        val infantryShock: Double,
                                        val cavalryFire: Double,
                                        val cavalryShock: Double,
                                        val artilleryFire: Double,
                                        val artilleryShock: Double)

  case object TECH_01 extends MilTechModifier(1, 2.00, 0.50, 15, 1.00, 0.35, 0.30, 0.00, 0.80, 0.00, 0.00)
  case object TECH_02 extends MilTechModifier(2, 2.00, 0.50, 20, 1.00, 0.35, 0.50, 0.00, 1.00, 0.00, 0.00)
  case object TECH_03 extends MilTechModifier(3, 2.50, 0.50, 20, 1.00, 0.35, 0.50, 0.00, 1.00, 0.00, 0.00)
  case object TECH_04 extends MilTechModifier(4, 3.00, 0.75, 20, 1.00, 0.35, 0.50, 0.00, 1.00, 0.00, 0.00)
  case object TECH_05 extends MilTechModifier(5, 3.00, 0.75, 22, 1.00, 0.35, 0.65, 0.00, 1.20, 0.00, 0.00)
  case object TECH_06 extends MilTechModifier(6, 3.00, 1.00, 24, 1.00, 0.55, 0.95, 0.00, 1.20, 0.00, 0.00)
  case object TECH_07 extends MilTechModifier(7, 3.00, 1.25, 24, 1.00, 0.55, 0.95, 0.00, 1.20, 1.00, 0.05)
  case object TECH_08 extends MilTechModifier(8, 3.00, 1.25, 24, 1.00, 0.80, 0.95, 0.00, 2.00, 1.00, 0.05)
  case object TECH_09 extends MilTechModifier(9, 3.00, 1.50, 25, 1.00, 0.80, 0.95, 0.00, 2.00, 1.00, 0.05)
  case object TECH_10 extends MilTechModifier(10, 3.00, 1.50, 25, 1.25, 0.80, 0.95, 0.00, 2.00, 1.00, 0.05)
  case object TECH_11 extends MilTechModifier(11, 3.00, 1.50, 27, 1.25, 0.80, 1.15, 0.50, 2.00, 1.00, 0.05)
  case object TECH_12 extends MilTechModifier(12, 3.00, 1.75, 27, 1.25, 0.80, 1.15, 0.50, 2.00, 1.00, 0.05)
  case object TECH_13 extends MilTechModifier(13, 3.00, 1.75, 27, 1.25, 0.80, 1.15, 0.50, 2.00, 1.00, 0.15)
  case object TECH_14 extends MilTechModifier(14, 3.00, 1.75, 29, 1.25, 1.10, 1.15, 0.50, 2.00, 1.00, 0.15)
  case object TECH_15 extends MilTechModifier(15, 4.00, 2.00, 29, 1.25, 1.10, 1.15, 0.50, 2.00, 1.00, 0.15)
  case object TECH_16 extends MilTechModifier(16, 4.00, 2.00, 30, 1.25, 1.10, 1.15, 0.50, 2.00, 2.40, 0.25)
  case object TECH_17 extends MilTechModifier(17, 4.00, 2.00, 30, 1.25, 1.10, 1.15, 0.50, 3.00, 2.40, 0.25)
  case object TECH_18 extends MilTechModifier(18, 4.00, 2.00, 32, 1.50, 1.10, 1.15, 0.50, 3.00, 2.40, 0.25)
  case object TECH_19 extends MilTechModifier(19, 4.00, 2.50, 32, 1.50, 1.10, 1.15, 0.50, 3.00, 2.40, 0.25)
  case object TECH_20 extends MilTechModifier(20, 4.00, 2.50, 34, 1.50, 1.60, 1.15, 0.50, 3.00, 2.40, 0.25)
  case object TECH_21 extends MilTechModifier(21, 4.00, 2.75, 34, 1.50, 1.60, 1.65, 0.50, 3.00, 2.40, 0.25)
  case object TECH_22 extends MilTechModifier(22, 4.00, 2.75, 36, 1.50, 1.60, 1.65, 1.00, 3.00, 4.40, 0.35)
  case object TECH_23 extends MilTechModifier(23, 4.00, 3.00, 36, 2.00, 1.60, 1.65, 1.00, 4.00, 4.40, 0.35)
  case object TECH_24 extends MilTechModifier(24, 4.00, 3.25, 38, 2.00, 1.60, 1.65, 1.00, 4.00, 4.40, 0.35)
  case object TECH_25 extends MilTechModifier(25, 4.00, 3.25, 38, 2.00, 1.60, 1.65, 1.00, 4.00, 6.40, 0.45)
  case object TECH_26 extends MilTechModifier(26, 5.00, 3.25, 40, 2.00, 1.60, 1.65, 1.00, 4.00, 6.40, 0.45)
  case object TECH_27 extends MilTechModifier(27, 5.00, 3.25, 40, 2.00, 2.10, 1.65, 1.00, 4.00, 6.40, 0.45)
  case object TECH_28 extends MilTechModifier(28, 5.00, 3.25, 40, 2.25, 2.10, 2.15, 1.00, 4.00, 6.40, 0.45)
  case object TECH_29 extends MilTechModifier(29, 5.00, 3.25, 40, 2.25, 2.10, 2.15, 1.00, 4.00, 6.40, 0.45)
  case object TECH_30 extends MilTechModifier(30, 6.00, 3.50, 40, 2.50, 3.10, 2.15, 1.00, 4.00, 6.40, 0.45)
  case object TECH_31 extends MilTechModifier(31, 6.00, 3.50, 40, 2.50, 3.10, 2.15, 1.00, 5.00, 6.40, 0.45)
  case object TECH_32 extends MilTechModifier(32, 6.00, 3.75, 40, 2.50, 3.10, 2.15, 1.00, 5.00, 8.40, 0.55)
