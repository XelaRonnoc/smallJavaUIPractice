public abstract class Boundary extends Cell {
 
  public Boundary(int inX, int inY){
    super(inX, inY);
    movementCost = -1; // sets all movement cost for boundary cells to -1 so can be easily checked
  }
}
