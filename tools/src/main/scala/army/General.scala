package army

class General(var fire: Int, var shock: Int, var maneuver: Int, var siege: Int) {

  /** default constructor, used for representing army without general */
  def this() {
    this(0,0,0,0)
  }

  /** calculate sumofpips, used for comparison */
  def sumOfPips: Int = {
    fire + shock + maneuver + siege
  }
}

