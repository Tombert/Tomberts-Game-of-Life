class Cell {
  var _alive:Boolean = false
  var _markedForDead:Boolean = true
  var _markedForLiving:Boolean = false

  def alive = _alive
  def alive_=(d:Boolean):Unit = _alive = d

  // def markedForDead = _markedForDead
  // def markedForDead_= (m:Boolean):Unit = _markedForDead = m
  

  def markedForLiving = _markedForLiving

  def markedForLiving_= (l:Boolean):Unit = _markedForLiving = l
  

  def kill:Unit = {
    if(markedForLiving){
      alive = true
    } else {
      alive = false
    }
  }
}
