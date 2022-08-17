import java.awt.Color;

public class Sand extends Surface {
  public Sand(int inX, int inY) {
    super(inX, inY);
    color = Color.YELLOW;
    movementCost = 50;
  }

}


