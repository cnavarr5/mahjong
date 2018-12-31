package Lab3;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {

  private static int numberofpoints = 4;

  //Polygon directly under rectangle
  private static int x[] = {0, 75, 90, 15};
  private static int y[] = {100, 100, 115, 115};

  //Bottom Polygon
  private static int x2[] = {15, 90, 105, 30};
  private static int y2[] = {115, 115, 130, 130};

  //Right Polygon
  private static int x1[] = {75, 90, 90, 75};
  private static int y1[] = {0, 25, 115, 100};

  //Far right polygon
  private static int x3[] = {90, 105, 105, 90};
  private static int y3[] = {26, 50, 130, 115};


  Color khaki = new Color(255, 250, 205);
  Color myGreen = new Color(0, 139, 0);

  public static Polygon underRect;
  public static Polygon bottom;
  public static Polygon right;
  public static Polygon farRight;

  public boolean removed = false;
  public int xSpace;
  public int ySpace;
  public int zSpace;
  public int zOr;

  static {
    underRect = new Polygon(x, y, numberofpoints);
    bottom = new Polygon(x2, y2, numberofpoints);
    right = new Polygon(x1, y1, numberofpoints);
    farRight = new Polygon(x3, y3, numberofpoints);
  }

  public void setZOr(int z){
    zOr = z;
  }

  public Tile(){
    setPreferredSize(new Dimension(120, 135));
    setOpaque(false);
    setSize(new Dimension(120, 135));
  }

  public boolean isOpen(){
    return removed;
  }
  public void remove() {removed = true;}
  public void placeBack() {removed = false;}

  public void setColor(){

    this.myGreen = Color.RED;
    this.khaki = Color.BLUE;
  }

  public void resetColor(){
    this.myGreen = new Color(0, 139, 0);
    this.khaki = new Color(255, 250, 205);
  }

  public int getXSpace(){return xSpace;}
  public int getYSpace(){return ySpace;}
  public int getZSpace(){return zSpace;}

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

//    drawRect(g, g2, khaki, 10, 20, 98, 148);
//    drawRect(g, g2, khaki, 0, 0, 100, 150);
drawRect(g, g2, khaki, 0, 0, 75, 100);

    drawPolygon(g, g2, khaki, underRect);
    drawPolygon(g, g2, khaki, right);
    drawPolygon(g, g2, myGreen, farRight);
    drawPolygon(g, g2, myGreen, bottom);
  }

  private void drawPolygon(Graphics g, Graphics2D g2d, Color d, Polygon poly){
    g2d.setPaint(d);
    g.fillPolygon(poly);
    g2d.setPaint(Color.BLACK);
    g.drawPolygon(poly);
  }

  private void drawRect(Graphics g, Graphics2D g2d, Color d, int x, int y, int width, int height){;
    g2d.setPaint(d)        ;
    g.fillRect(x, y, width, height);
    g2d.setPaint(Color.BLACK);
    g.drawRect(x, y, width, height);
  }

  public boolean matches(Tile other) {
    if (this == other) {
      return false;
    }
    if (other == null) {
      return false;
    }
    if (getClass() != other.getClass()) {
      return false;
    } else {
      return true;
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();

    frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Tile");

    frame.add(new Tile());

    frame.pack();
    frame.setVisible(true);
  }
}


