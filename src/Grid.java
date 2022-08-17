import java.awt.Graphics;
import java.awt.Point;

public class Grid {
  Cell[][] cells = new Cell[20][20]; // creates a new array of cells 20 by 20
  
  public Grid() {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        double mapKey = Math.random()*100; // sets random value
        // below is used to assign what type of cell will be at current array position through the percentages
        if(mapKey < 10){
          cells[i][j] = new Wall(10+Cell.size*i, 10+Cell.size*j);
        }else if(mapKey >=10 && mapKey <20){
          cells[i][j] = new Fence(10+Cell.size*i, 10+Cell.size*j);
        }else if(mapKey >=20 && mapKey <30){
          cells[i][j] = new Stone(10+Cell.size*i, 10+Cell.size*j);
        }else if(mapKey >=30 && mapKey <50){
          cells[i][j] = new Sand(10+Cell.size*i, 10+Cell.size*j);
        }else if(mapKey >=50 && mapKey <80){
          cells[i][j] = new Grass(10+Cell.size*i, 10+Cell.size*j);
        }else if(mapKey >=80 && mapKey <=100){
          cells[i][j] = new Water(10+Cell.size*i, 10+Cell.size*j);
        }
      }
    }
  }

  public void paint(Graphics g, Point mousePos) { // call the cells paint methods
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j].paint(g, mousePos);
      }
    }
  }
}
