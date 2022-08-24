import java.awt.Color;


public class Wall extends Boundary {
  //constructors
    public Wall(int inX, int inY) {
      super(inX, inY);
      color = Color.DARK_GRAY; 
    }
}