package Lab3;

import javax.swing.*;
import java.awt.*;

public class SeasonTile extends PictureTile {

  private Image season;

  public SeasonTile(String name){
    super(name);
    switch(name){
      case "Spring":
        season = new ImageIcon(getClass().getResource("images/Spring.png")).getImage();
        break;
      case "Summer":
        season = new ImageIcon(getClass().getResource("images/Summer.png")).getImage();
        break;
      case "Winter":
        season = new ImageIcon(getClass().getResource("images/Winter.png")).getImage();
        break;
      case "Fall":
        season = new ImageIcon(getClass().getResource("images/Fall.png")).getImage();
        break;
    }
  }
  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(season, 10, 25, this);
  }
}
