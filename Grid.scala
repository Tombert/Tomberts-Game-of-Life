class Grid{
  var arrayOfCells = Array.fill(100,100){new Cell}

  def display = {
   this.examine

    for(i<-arrayOfCells) {
      for(j<-i) {
       
    	if(j.alive){
    	  print("x")
    	}
    	else {
    	  print("o")
    	}
      }
     println("")
    }

  }

  def examine = {
    var countArray = Array.ofDim[Boolean](8) //One for each adjacent and diagonal cell
 
    for(i<- 0 to 99){
      for(j<- 0 to 99) {

	
   	if(i>0 && j>0){
	  countArray(0) = arrayOfCells(i-1)(j-1).alive
	}
	if(i<99 && j<99){
    	  countArray(1) = arrayOfCells(i+1)(j+1).alive
	}
	if(j>0){
    	  countArray(2) = arrayOfCells(i)(j-1).alive
	}
	if(j>0 && i<99){
    	  countArray(3) = arrayOfCells(i+1)(j-1).alive
	}
	if(i<99){
    	  countArray(4) = arrayOfCells(i+1)(j).alive
	}
   	if(i>0){
    	  countArray(5) = arrayOfCells(i-1)(j).alive
	}
	if(j<99){
    	  countArray(6) = arrayOfCells(i)(j+1).alive
	}
	if(i>0 && j<99){
    	  countArray(7) = arrayOfCells(i-1)(j+1).alive
	}

	// countArray(0) = true
	// countArray(1) = true
	// countArray(2) = true
	// countArray(3) = true
	// countArray(4) = true
	// countArray(5) = true
	// countArray(6) = true
	// countArray(7) = true
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
