import java.awt.Graphics;
import java.awt.Point;

public class Stage {
  //fields
  Grid grid;

  //constructors
  public Stage() {
    grid = new Grid(); // creates a new grid
  }

  // calls grid paint method
  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);  
  }
}