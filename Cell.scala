class Cell {
  private var _alive:Boolean = false
  private var _markedForDead:Boolean = true
  private var _markedForLiving:Boolean = false

  def alive = _alive
  def alive_=(d:Boolean):Unit = _alive = d

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
