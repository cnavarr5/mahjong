package Lab3;

import java.awt.*;

public class Circle{
  public int x;
  public int y;
  private Color color;

  public Circle(int x, int y, Color color){
    this.x = x;
    this.y = y;
    this.color = color;
  }

  public void draw(Graphics g){
    g.setColor(this.color);
    g.fillOval(this.x, this.y, 15, 15);
    g.setColor(Color.BLACK);
    g.fillOval(this.x+5, this.y+5, 5, 5);
  }

}
