import org.lwjgl._
import opengl.{Display,GL11,DisplayMode}
import GL11._
import input._
import math._

object DisplayIt {
  val FRAMERATE = 60
  private var _width = 0
  private var _height = 0
  
  def width = _width
  def width_=(w:Int):Unit = _width = w
  
  def height = _height
  def height_=(h:Int):Unit = _height = h


  def init (g:Grid,w:Int=800, h:Int=600) = {
    try {
      width = w
      height = h
      Display.setDisplayMode(new DisplayMode(width,height))
      Display.create
    } catch {
      case e: Exception =>  e.printStackTrace;      System.exit(0)
    }
    
    startGL
    while(!Display.isCloseRequested){
      updateIt(g)
    }
    Display.destroy
  }
  
  def startGL = {
    GL11.glMatrixMode(GL11.GL_PROJECTION);
    GL11.glLoadIdentity;
    GL11.glOrtho(0, 800, 0, 600, 1, -1);
    GL11.glMatrixMode(GL11.GL_MODELVIEW);
  }

  def drawBox(center:Int, sideLength:Int=100) = {
    var realSideLength = sideLength/2
    GL11.glBegin(GL11.GL_QUADS)
    GL11.glVertex2f(center-realSideLength,center-realSideLength)
    GL11.glVertex2f(center+realSideLength,center-realSideLength)
    GL11.glVertex2f(center+realSideLength,center+realSideLength)
    GL11.glVertex2f(center-realSideLength,center+realSideLength)
    GL11.glEnd
  }

  def renderGrid(g:Grid) = {
    
  }
  
  def updateIt(g:Grid) = {

    Display.sync(FRAMERATE)

    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    
    drawBox(200);
    
    Display.update

  }
}
