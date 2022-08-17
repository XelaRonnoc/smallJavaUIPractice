import java.awt.Color;


public class Grass extends Surface {
  public Grass(int inX, int inY) {
    super(inX, inY);
    color = Color.GREEN;
    movementCost = 20;
  }
}
