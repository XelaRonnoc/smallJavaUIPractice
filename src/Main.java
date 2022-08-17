 import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

  static public long startTime;
  static public long elapsedTime; // milliseconds
  
    class Canvas extends JPanel {
      Stage stage = new Stage();

      public Canvas() {

        setPreferredSize(new Dimension(720, 720));
      }

      @Override
      public void paint(Graphics g) {

       
        stage.paint(g, getMousePosition());
        Tooltip.paint(g, getMousePosition());


        
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

    public void run() {
      while(true) {
        repaint();
      }
    }


    static public void timeElapsed(){
      long currentTime = System.currentTimeMillis();
      elapsedTime = currentTime - startTime;
  }
}
