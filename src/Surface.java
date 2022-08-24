public abstract class Surface extends Cell {
  //fields
  protected int movementCost;

  //constructors
  public Surface(int inX, int inY){
    super(inX, inY);
    
  }

  //methods
  public int getMovementCost(){
    return movementCost;
  }
}
