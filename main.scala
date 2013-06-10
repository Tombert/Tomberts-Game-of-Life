object mainGame {
  def main(args: Array[String]) {
    var myGrid = new Grid(50, 50)
   
    while(true){
      Runtime.getRuntime().exec("clear");
      //I don't know of a reliable way to do this.....You're going to need a posix system to run it. 
      myGrid.display

    }
  }
}
