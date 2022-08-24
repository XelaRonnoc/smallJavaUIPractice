import java.awt.Color;


public class Water extends Surface {
  //constructors
  public Water(int inX, int inY) {
    super(inX, inY);
    color = Color.BLUE;
    movementCost = 100;
  }
}