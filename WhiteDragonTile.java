package Lab3;

import java.awt.*;

public class WhiteDragonTile extends Tile {
  Color khaki = new Color(255, 250, 205);

  public WhiteDragonTile(){
    setToolTipText("White Dragon");
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);

    g.setColor(Color.BLUE);
    g.fillRect(0, 0, 75, 100);
    g.setColor(khaki);
    g.fillRect(10, 53-40, 53, 75);
    g.fillRect(17, 40-40, 40, 13);
    g.fillRect(17, 128-40, 40 ,13);

    g.fillRect(62, 60-40,13, 20);
    g.fillRect(62, 100-40,13, 20);

    g.fillRect(0, 60-40,13, 20);
    g.fillRect(0, 100-40,13, 20);

    g.setColor(Color.BLACK);
    g.drawRect(0, 40-40, 75, 100);

    g.drawRect(10, 53-40, 53, 75);
    g.drawRect(17, 40-40, 40, 13);
    g.drawRect(17, 128-40, 40 ,13);


    g.drawRect(0, 60-40, 13, 20);
    g.drawRect(0, 100-40, 13, 20);
    g.drawRect(62, 60-40, 13, 20);
    g.drawRect(62, 100-40, 13, 20);

  }
  public String toString(){
    return "White Dragon";
  }
}
