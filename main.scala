object mainGame {
  def main(args: Array[String]) {
    var myGrid = new Grid()
   
    while(true){
      Runtime.getRuntime().exec("clear");
      //I don't know of a reliable way to do this.....You're going to need a posix system to run it. 
      myGrid.display

    }
  }
}
