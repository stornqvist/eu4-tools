package army

import datatypes.WESTERN
import org.scalatest.{BeforeAndAfter, FlatSpec}

class RegimentTest extends FlatSpec with BeforeAndAfter {

  var regiment: Regiment = _

  before {
    regiment = new Regiment(0, 1000, GAELIC_FREE_SHOOTER, WESTERN)
  }

  "A regiment" should "take attrition" in {
    //regiment = new Regiment(0, 1000, GAELIC_FREE_SHOOTER, WESTERN)
    regiment.takeAttrition(0.01)
    assertResult(990) {regiment.strength}
  }

  it should "reinforce" in {
    regiment.takeAttrition(0.01)
    regiment.reinforce(0.005)
    assertResult(995) {regiment.strength}
  }
}
