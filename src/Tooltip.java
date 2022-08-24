import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Tooltip {
    //fields
    static public Cell currentCell; // cell that mouse is in
    static final private Color background = new Color(255,255,255, 200); // sets colour of tooltip box
    static final private int xTextOffset = 2; // sets initial offset of toolTip text relative to background offset (x)
    static final private int yTextOffset = 15; // sets intial offset of toolTip text relative to background offset(y)
    static final private int scndLnOffset = 16; // offsets the second line of text additionally in y direction
    static private int xBackgroundOffset = 13; // sets initial offset of tooltip box (x)
    static private int yBackgroundOffset = 2; // sets intital offset of toolTip box (y)
    static private int width; // width of tool tip box
    static private int height = 35; // height of tool tip box
    static final private int arc = 10; // corner arc of rounded rect for tool tip box
    static final private Double HoverDuration = 1.0; // seconds
    static private boolean isVisible = false; // boolean helps determine if to paint tooltip or not along with mousePos

    //constructors
    public Tooltip(){
    }

    // methods
    static public void paint(Graphics g, Point mousePos){
        if(mouseIn(mousePos) && isVisible){ // if mouse is in frame and not outside of it and isVisible is true then paint the tooltip
            setTTSizeLoc(mousePos);
            g.setColor(background);
            g.fillRoundRect(mousePos.x+xBackgroundOffset, mousePos.y+yBackgroundOffset, width, height, arc, arc);
            g.setColor(Color.BLACK);
            g.setFont(new Font("ToolTipFont", Font.BOLD, 16));
            // if below is a boundary (first case) or a surface (second case);
            if(currentCell instanceof Boundary){
                g.drawString("" + currentCell.getClass().getName(), mousePos.x+xBackgroundOffset+xTextOffset, mousePos.y+yBackgroundOffset+yTextOffset);
                g.drawString("Cannot cross", mousePos.x+xBackgroundOffset+xTextOffset, mousePos.y+yBackgroundOffset+yTextOffset+scndLnOffset);
            }else{
                g.drawString("" + currentCell.getClass().getName(), mousePos.x+xBackgroundOffset+xTextOffset, mousePos.y+yBackgroundOffset+yTextOffset);
                g.drawString("CrossingTime = " + ((Surface) currentCell).getMovementCost()/5, mousePos.x+xBackgroundOffset+xTextOffset, mousePos.y+yBackgroundOffset+yTextOffset+scndLnOffset);
            }
        }
    }

    static void setTTSizeLoc(Point mousePos){ // changes size and positon of tool tip depending on contents and postion in the grid
        if(mousePos == null){
            return;
        }
        if(currentCell instanceof Boundary){
            width = 110;
            if((mousePos.x-10)/Cell.size >=17){ // if towards right side of screen
                xBackgroundOffset = -105;
            }else{
                xBackgroundOffset = 13;
            }
        }else{ // if not a boundary
            width = 145;
            if((mousePos.x-10)/Cell.getCellSize() >= 15){ // if towards right side of screen
                xBackgroundOffset = -150;
            }else{
                xBackgroundOffset = 13;
            }
        }
        // if towards bottom of screen
        if((mousePos.y-10)/Cell.getCellSize()>=18){
            yBackgroundOffset = -30;
        }else{
            yBackgroundOffset = 2;
        }
    }

    private static boolean mouseIn(Point mousePos){ // checks if mouse is in the game screen
        if(mousePos == null){
            return false;
        }
        if(mousePos.x >= 710 || mousePos.x <= 10 || mousePos.y >= 710 || mousePos.y <= 10){
            return false;
        }
        return true;
    }

    public static double getHoverDuration(){
        return HoverDuration;
    }

    public static boolean getVisibility(){
        return isVisible;
    }

    public static void setVisibility(boolean vis){
        isVisible = vis;
        return;
    }

}
