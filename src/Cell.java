import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public abstract class Cell extends Rectangle {
  // fields
  static int size = 35; // size of the cells
  Color color; // cell color determined by children 
  int movementCost; // movement cost determined by children 
  boolean entered = false; // allows cell to check when mouse enters the cell

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
      Tooltip.currentCell = this; // tooltip's cell now = this cell
      if(!entered){ // if this is the first frame that the mouse entered the cell 
        Main.startTime = System.currentTimeMillis(); // records time that mouse entered cell
        entered = true; // sets the mouse was in this cell
        Tooltip.isVisible = false; // makes tool tip invisible if it was previously visible from another cell
      }

      if(entered){
        Main.timeElapsed(); // sets the elapsed time variable to time since start time was reset
        if(Main.elapsedTime/1000 >= Tooltip.HoverDuration){ // if elapsed time greated than the set hover wait period
          Tooltip.isVisible = true; //display tooltip
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
}
