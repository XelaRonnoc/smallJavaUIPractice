import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main extends JFrame {
    class Canvas extends JPanel {
      Stage stage = new Stage();

      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
      }

      @Override
      public void paint(Graphics g) { 
        stage.paint(g, getMousePosition()); // paints stage which will as required call all other pain methods bar
        Tooltip.paint(g, getMousePosition()); // paints tool tip last so is ontop of everything 
      }
    }

    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();
      this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    public void run() { // continous loop while prgram is running
      while(true) {
        try{
        Thread.sleep(20);
        }catch (InterruptedException e){
        }
        repaint();
      }
    }


}
