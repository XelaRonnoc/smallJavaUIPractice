import java.awt.Graphics;
import java.awt.Point;

public class Stage {
  Grid grid;

  public Stage() {
    grid = new Grid();
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);  
  }
}