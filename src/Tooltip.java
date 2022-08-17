import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Tooltip {
    static public Cell currentCell; // cell that mouse is in
    static private Color background = new Color(255,255,255, 200); // sets colour of tooltip box
    static private int xTextOffset = 15; // sets initial offset of toolTip text (x)
    static private int yTextOffset = 17; // sets intial offset of toolTip tect (y)
    static private int xBackgroundOffset = 13; // sets initial offset of tooltip box (x)
    static private int yBackgroundOffset = 2; // sets intital offset of toolTip box (y)
    static private int width; // width of tool tip box
    static private int height = 35; // height of tool tip box
    static private int arc = 10; // corner arc of rounded rect for tool tip box
    static public Double HoverDuration = 1.0; // seconds
    static public boolean isVisible = false; // boolean helps determine if to paint tooltip or not along with mousePos


    

    public Tooltip(){

    }
 
   static public void paint(Graphics g, Point mousePos){
        if(mouseIn(mousePos) && isVisible){ // if mouse is in frame and not outside of it and isVisible is true then paint the tooltip
            setTTSizeLoc(mousePos);
            g.setColor(Color.BLACK);
            g.drawRoundRect(mousePos.x+xBackgroundOffset, mousePos.y+yBackgroundOffset, width, height, arc, arc);
            g.setColor(background);
            g.fillRoundRect(mousePos.x+xBackgroundOffset, mousePos.y+yBackgroundOffset, width, height, arc, arc);
            g.setColor(Color.BLACK);
            g.setFont(new Font("ToolTipFont", Font.ITALIC, 16));
            // if below is a boundary (first case) or a surface (second case);
            if(currentCell.movementCost < 0){
                g.drawString("" + currentCell.getClass().getName(), mousePos.x+xTextOffset, mousePos.y+yTextOffset);
                g.drawString("Cannot cross", mousePos.x+xTextOffset, mousePos.y+yTextOffset+16);
            }else{
                g.drawString("" + currentCell.getClass().getName(), mousePos.x+xTextOffset, mousePos.y+yTextOffset);
                g.drawString("CrossingTime = " + currentCell.movementCost/5, mousePos.x+xTextOffset, mousePos.y+yTextOffset+16);
            }
        }
    }

    static void setTTSizeLoc(Point mousePos){ // changes size and positon of tool tip depending on contents and postion in the grid
        if(mousePos == null){
            return;
        }
        if(currentCell.movementCost < 0){
            width = 100;
            if((mousePos.x-10)/Cell.size >=17){ // if towards right side of screen
                xBackgroundOffset = -105;
                xTextOffset = -103;
            }else{
                xBackgroundOffset = 13;
                xTextOffset = 15;
            }

        }else{ // if not a boundary
            width = 145;
            if((mousePos.x-10)/Cell.size >= 15){ // if towards right side of screen
                xBackgroundOffset = -150;
                xTextOffset = -148;
            }else{
                xBackgroundOffset = 13;
                xTextOffset = 15;
            }
        }
        // if towards bottom of screen
        if((mousePos.y-10)/Cell.size>=18){
            yBackgroundOffset = -30;
            yTextOffset = -15;
        }else{
            yBackgroundOffset = 2;
            yTextOffset = 17;
        }
    }

    private static boolean mouseIn(Point mousePos){ // checks if mouse is in the game screen
        if(mousePos == null){
            return false;
        }
        if(mousePos.x > 710 || mousePos.x < 10 || mousePos.y > 710 || mousePos.y < 10){
            return false;
        }
        return true;
    }


}
