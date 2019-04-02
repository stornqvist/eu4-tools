package util

import scala.util.Random

class Dice(rnd: Random) {

  def random(range: Range): Int = {
    rnd.nextInt(range.end - range.start + 1) + range.start // in case you want range from other
  }
}
