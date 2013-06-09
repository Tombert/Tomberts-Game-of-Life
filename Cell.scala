class Cell {
  var _dead:Boolean = true
  var _markedForDead:Boolean = false

  def dead = _dead
  def dead_=(d:Boolean):Unit = _dead = d

  def markedForDead = _markedForDead
  def markedForDead_= (m:Boolean):Unit = _markedForDead = m
  
}
