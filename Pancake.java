package Lab3;

import java.awt.*;

public class Pancake extends Circle {


  public Pancake(int x, int y, Color color){
    super(x, y, color);
  }

  public void draw(Graphics g){
    g.setColor(Color.GREEN);
    g.fillOval(x, y, 50, 50);
    g.setColor(Color.RED);
    g.fillOval(this.x+17, this.y+18, 15, 15);
    g.setColor(Color.BLACK);
    g.drawLine(x, y+25, x+17, y+25);
    g.drawLine(x+32, y+25, x+50, y+25);
  }
}
