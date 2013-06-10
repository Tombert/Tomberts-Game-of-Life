class Grid(inputheight:Int, inputwidth:Int){
  var _height = inputheight
  var _width = inputwidth
  
  def height = inputheight
  def height_= (h:Int):Unit= _height = h

  def width = _width
  def width_= (w:Int):Unit= _width = w

  var arrayOfCells = Array.fill(height,width){new Cell}
  // arrayOfCells (19)(20).alive = true
  // arrayOfCells (20)(20).alive = true
  // arrayOfCells (21)(20).alive = true
  // arrayOfCells (21)(19).alive = true
  // arrayOfCells (20)(18).alive = true
  //Coordinates of a glider. Need to make a text parser, I think
  arrayOfCells(19)(19).alive = true
  arrayOfCells(19)(20).alive = true
  arrayOfCells(19)(21).alive = true
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
 
    for(i<- 0 to height-1){
      for(j<- 0 to width-1) {

	
   	if(i>0 && j>0){
	  countArray(0) = arrayOfCells(i-1)(j-1).alive
	}
	if(i<height-1 && j<width-1){
    	  countArray(1) = arrayOfCells(i+1)(j+1).alive
	}
	if(j>0){
    	  countArray(2) = arrayOfCells(i)(j-1).alive
	}
	if(j>0 && i<height-1){
    	  countArray(3) = arrayOfCells(i+1)(j-1).alive
	}
	if(i<height-1){
    	  countArray(4) = arrayOfCells(i+1)(j).alive
	}
   	if(i>0){
    	  countArray(5) = arrayOfCells(i-1)(j).alive
	}
	if(j<width-1){
    	  countArray(6) = arrayOfCells(i)(j+1).alive
	}
	if(i>0 && j<width-1){
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
