class Grid{
  var arrayOfCells = Array.ofDim[Cell](100, 100)
  
  def examine = {
    for(i<- 1 to 100){
      for(j<-1 to 100){
	arrayOfCells(i)(j)
      }
    }
  }
  
}
