import java.awt.Color;


public class Stone extends Surface {
  public Stone(int inX, int inY) {
    super(inX, inY);
    color = Color.GRAY;
    movementCost = 10;

  }
}