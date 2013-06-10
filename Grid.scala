class Grid{
  var arrayOfCells = Array.fill(50,50){new Cell}
  arrayOfCells (19)(20).alive = true
  arrayOfCells (20)(20).alive = true
  arrayOfCells (21)(20).alive = true
  arrayOfCells (21)(19).alive = true
  arrayOfCells (20)(18).alive = true
  //Coordinates of a glider. Need to make a text parser, I think

  def display = {
    for(i<-arrayOfCells) {
      for(j<-i) {
       
    	if(j.alive){
    	  print("X")
    	}
    	else {
    	  print(" ")
    	}
      }
     println("")
    }
    println("")
    this.examine
  }

  def examine = {
    var countArray = Array.fill(8){false} //One for each adjacent and diagonal cell
 
    for(i<- 0 to 49){
      for(j<- 0 to 49) {

	
   	if(i>0 && j>0){
	  countArray(0) = arrayOfCells(i-1)(j-1).alive
	}
	if(i<49 && j<49){
    	  countArray(1) = arrayOfCells(i+1)(j+1).alive
	}
	if(j>0){
    	  countArray(2) = arrayOfCells(i)(j-1).alive
	}
	if(j>0 && i<49){
    	  countArray(3) = arrayOfCells(i+1)(j-1).alive
	}
	if(i<49){
    	  countArray(4) = arrayOfCells(i+1)(j).alive
	}
   	if(i>0){
    	  countArray(5) = arrayOfCells(i-1)(j).alive
	}
	if(j<49){
    	  countArray(6) = arrayOfCells(i)(j+1).alive
	}
	if(i>0 && j<49){
    	  countArray(7) = arrayOfCells(i-1)(j+1).alive
	}

	var theCount = countArray.count(_ == true)
	if (!arrayOfCells(i)(j).alive && theCount==3){
    	  arrayOfCells(i)(j).markedForLiving = true
	}

    	else if(arrayOfCells(i)(j).alive && (theCount == 2 || theCount == 3)){

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
