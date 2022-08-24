import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public abstract class Cell extends Rectangle {
  // fields
  protected static int size = 35; // size of the cells
  protected Color color; // cell color determined by children 
   // movement cost determined by children 
  protected boolean entered = false; // allows cell to check when mouse enters the cell
  protected long startTime;
  protected long currentTime;
  protected long elapsedTime;

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

    if(contains(mousePos)) { // if mouse is in the cell
      
      if(!entered){ // if this is the first frame that the mouse entered the cell 
        Tooltip.setVisibility(false); // makes tool tip invisible if it was previously visible from another cell
        Tooltip.currentCell = this; // tooltip's cell now = this cell
        startTime = System.currentTimeMillis(); // records time that mouse entered cell
        entered = true; // sets the mouse was in this cell
       
      }

      if(entered){
        currentTime = System.currentTimeMillis();
        elapsedTime = currentTime - startTime;
        // sets the elapsed time variable to time since start time was reset
        if(elapsedTime/1000 >= Tooltip.getHoverDuration()){ // if elapsed time greated than the set hover wait period
          Tooltip.setVisibility(true); //display tooltip
        }
      }
    }else{
      entered = false; // when mouse leaves cell reset to false 
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
