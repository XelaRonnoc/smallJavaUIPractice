import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Tooltip {
    static public Cell currentCell;
    static public String typeOfTerrain = "";
    static private Color background = new Color(255,255,255, 200);
    static private int xTextOffset = 15;
    static private int yTextOffset = 17;
    static private int xBackgroundOffset = 13;
    static private int yBackgroundOffset = 2;
    static private int width;
    static private int height = 35;
    static private int arc = 10;
    static public Double HoverDuration = 2.0; // seconds
    static public boolean isVisible = false;


    

    public Tooltip(){

    }
 
   static public void paint(Graphics g, Point mousePos){
        if(mouseIn(mousePos) && isVisible){
            setTTSizeLoc(mousePos);
            g.setColor(Color.BLACK);
            g.drawRoundRect(mousePos.x+xBackgroundOffset, mousePos.y+yBackgroundOffset, width, height, arc, arc);
            g.setColor(background);
            g.fillRoundRect(mousePos.x+xBackgroundOffset, mousePos.y+yBackgroundOffset, width, height, arc, arc);
            g.setColor(Color.BLACK);
            g.setFont(new Font("ToolTipFont", Font.ITALIC, 16));
            if(currentCell.getClass().getName().equals("Fence") || currentCell.getClass().getName().equals("Wall")){
                g.drawString("" + currentCell.getClass().getName(), mousePos.x+xTextOffset, mousePos.y+yTextOffset);
                g.drawString("Cannot cross", mousePos.x+xTextOffset, mousePos.y+yTextOffset+16);
            }else{
                g.drawString("" + currentCell.getClass().getName(), mousePos.x+xTextOffset, mousePos.y+yTextOffset);
                g.drawString("CrossingTime = " + currentCell.movementCost/5, mousePos.x+xTextOffset, mousePos.y+yTextOffset+16);
            }
        }
    }

    static void setTTSizeLoc(Point mousePos){
        if(currentCell.getClass().getName().equals("Fence") || currentCell.getClass().getName().equals("Wall")){
            width = 100;
            if(mousePos.x/Cell.size >=17){
                xBackgroundOffset = -90;
                xTextOffset = -88;
            }else{
                xBackgroundOffset = 13;
                xTextOffset = 15;
            }

        }else{
            width = 145;
            if(mousePos.x/Cell.size >=15){
                xBackgroundOffset = -150;
                xTextOffset = -148;
            }else{
                xBackgroundOffset = 13;
                xTextOffset = 15;
            }
        }
        
        if(mousePos.y/Cell.size >=18){
            yBackgroundOffset = -20;
            yTextOffset = -5;
        }else{
            yBackgroundOffset = 2;
            yTextOffset = 17;
        }
    }

    private static boolean mouseIn(Point mousePos){
        if(mousePos == null){
            return false;
        }
        if(mousePos.x > 710 || mousePos.x < 10 || mousePos.y > 710 || mousePos.y < 10){
            return false;
        }
        return true;
    }


}
