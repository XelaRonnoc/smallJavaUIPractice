import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public abstract class Cell extends Rectangle {
  // fields
  static int size = 35;
  Color color;
  int movementCost; 
  boolean entered = false;

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

    if(contains(mousePos)) {
      Tooltip.currentCell = this;
      if(!entered){
        Main.startTime = System.currentTimeMillis();
        entered = true;
        Tooltip.isVisible = false;
      }

      if(entered){
        Main.timeElapsed();
        System.out.println(Main.elapsedTime);
        if(Main.elapsedTime/1000 >= Tooltip.HoverDuration){
          Tooltip.isVisible = true;
        }
      }
    }else{
      entered = false;
    }
  }

  public boolean contains(Point p) {
    if(p != null) {
      return super.contains(p);
    } else {
      return false;
    }
  }
}
