class Grid{
  private var arrayOfCells = Array.ofDim[Cell](100, 100)  
  def examine = {

    for(i<- 1 to 100){
      for(j<-1 to 100) {
	var countArray = Array.ofDim[Boolean](8) //One for each adjacent and diagonal cell

  	countArray(1) = arrayOfCells(i-1)(j-1).alive
	countArray(2) = arrayOfCells(i)(j-1).alive
	countArray(3) = arrayOfCells(i+1)(j-1).alive
	countArray(4) = arrayOfCells(i+1)(j).alive
	countArray(5) = arrayOfCells(i-1)(j).alive
	countArray(6) = arrayOfCells(i)(j+1).alive
	countArray(7) = arrayOfCells(i-1)(j+1).alive
	countArray(8) = arrayOfCells(i+1)(j+1).alive
	
	if(countArray.count(_ == true) == 2 || countArray.count(_ == true) == 3){
	  arrayOfCells(i)(j).markedForLiving = true
	}
	else {
	  arrayOfCells(i)(j).markedForLiving = false
	}
	
      }
    }
    
    //Kill the cells that are marked. 
    arrayOfCells.par.map(_.par.map(_.kill));
  }





}
