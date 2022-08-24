public abstract class Surface extends Cell {

  protected int movementCost;

  public Surface(int inX, int inY){
    super(inX, inY);
    
  }

  public int getMovementCost(){
    return movementCost;
  }
}
