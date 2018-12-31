package Lab3;

import java.awt.*;

public class Bamboo {
  private int x;
  private int y;
  private Color color;

  public Bamboo(int x, int y, Color color){
    this.x = x;
    this.y = y;
    this.color = color;
  }

  public void draw(Graphics g){
    g.setColor(color);
    g.fillRect(x, y, 15, 5);
    g.fillRect(x+3, y+5, 7, 20);
    g.fillRect(x, y+25,15, 5);
    g.setColor(Color.WHITE);
    g.fillRect(x+5, y+5, 2, 20);
  }

}
