import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public abstract class Cell extends Rectangle {
  // fields
  protected static int size = 35; // size of the cells
  protected Color color; // cell color determined by children 
  protected long startTime; 
  protected long currentTime;
  protected long elapsedTime;
  protected boolean mouseStopped = false; // used to record initial stopping position of mouse
  protected Point mouseStartStop; // initial stopping position of mouse 

  // constructors
  public Cell(int inX, int inY) {
    super(inX, inY, size, size);
  }

  // methods
  public void paint(Graphics g, Point mousePos) {
    g.setColor(color);
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);

    mouseStopCheck(mousePos);
  }

  public void mouseStopCheck(Point mousePos){
    if(contains(mousePos)) { 
      Tooltip.currentCell = this;
      if(!mouseStopped){
        Tooltip.setVisibility(false);
        mouseStartStop = mousePos;
        startTime = System.currentTimeMillis();
        mouseStopped = true;
      }
  
      if(mouseStopped){
        currentTime = System.currentTimeMillis();
        elapsedTime = currentTime - startTime;
        if(mouseStartStop.equals(mousePos)){
          if(elapsedTime/1000 >= Tooltip.getHoverDuration()){
            Tooltip.setVisibility(true);
          }
        }else{
          mouseStopped = false;
        }
      }
    }else{
      mouseStopped = false;
    }
  }

  public boolean contains(Point p) { // uses contains method of rect with a null check
    if(p != null) {
      return super.contains(p);
    } else {
      return false;
    }
  }

  public static int getCellSize(){
    return size;
  }

  
}
