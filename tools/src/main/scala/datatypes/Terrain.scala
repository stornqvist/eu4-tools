package datatypes

sealed abstract class Terrain(val name: String,
                              val supplyLimit: Int,
                              val localDefensiveness: Double, /** determines the length of siege phases */
                              val movementCost: Double,       /** determines travel time of units */
                              val combatWidth: Double,        // not used in recent patches
                              val attackerPenalty: Int) 	    /** Flat modifier to attacker's die rolls (positive) */

case object GLACIAL extends Terrain("Glacial", 4, 1.0, 1.0, 1.0, 1)
case object FARMLANDS extends Terrain("Farmlands", 10, 1.0, 1.1, 1.0, 0)
case object FOREST extends Terrain("Forest", 6, 1.0, 1.25, 0.8, 1)
case object HILLS extends Terrain("Hills", 4, 1.1, 1.4, 0.75, 1)
case object WOODS extends Terrain("Woods", 6, 1.0, 1.1, 0.8, 1)
case object MOUNTAINS extends Terrain("Mountains", 4, 1.25, 1.5, 0.5, 2)
case object GRASSLANDS extends Terrain("Grasslands", 8, 1.0, 1.0, 1.0, 0)
case object JUNGLE extends Terrain("Jungle", 4, 1.0, 1.5, 0.75, 1)
case object MARSH extends Terrain("Marsh", 4, 1.0, 1.3, 0.75, 1)
case object DESERT extends Terrain("Desert", 4, 1.0, 1.05, 1.0, 0)
case object COASTAL_DESERT extends Terrain("Coastal Desert", 4, 1.0, 1.0, 1.0, 0)
case object COASTLINE extends Terrain("Coastline", 6, 1.0, 1.0, 1.0, 0)
case object DRYLANDS extends Terrain("Drylands", 6, 1.0, 1.0, 1.0, 0)
case object HIGHLANDS extends Terrain("Highlands", 6, 1.1, 1.4, 0.75, 1)
case object SAVANNAH extends Terrain("Savannah", 4, 1.0, 1.0, 1.0, 0)
case object STEPPE extends Terrain("Steppe", 6, 1.0, 1.0, 1.0, 0)

/** Crossing penalty for attacker, cancelled if movement skill of attacking general is higher than defending, checked daily */
sealed abstract class CrossingPenalty(val name: String, val penalty: Int)

case object NONE extends CrossingPenalty("No crossing penalty", 0)
case object RIVER extends CrossingPenalty("Crossing river", 1)
case object STRAIT extends CrossingPenalty("Crossing strait", 2)
case object AMPHIBIOUS_LANDING extends CrossingPenalty("Amphibious landing", 2)
