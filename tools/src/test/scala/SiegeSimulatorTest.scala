import army._
import datatypes._
import org.scalatest.FlatSpec

class SiegeSimulatorTest extends FlatSpec {

  "An army" should "have 0 artillery bonus if no artillery" in {
    val army = new Army(new General(0, 0, 0, 0), TECH_04, Array(new Regiment(0, 1000, HALBERD_INFANTRY, WESTERN)))
    assertResult(0) {
      army.getArtilleryBonus(1)
    }
  }

  it should "have max artillery bonus of 5" in {
    val army10artillery = new Army(new General, TECH_13, Array.fill(10)(new Regiment(0, 1000, SMALL_CAST_IRON_BOMBARD, WESTERN)))
    assertResult(5) {
      army10artillery.getArtilleryBonus(1)
    }
  }
  val army = new Army(new General, TECH_13,
    Array.fill(24)(new Regiment(0, 1000, GAELIC_FREE_SHOOTER, WESTERN)) ++
    Array.fill(4)(new Regiment(0, 1000, FRENCH_CARACOLLE, WESTERN)) ++
    Array.fill(10)(new Regiment(0, 1000, SMALL_CAST_IRON_BOMBARD, WESTERN)))
  val simulator = new SiegeSimulator(new Fort(1, 0, 0), army, TECH_13, 0, 0.0)
  println(simulator.siege)
}

