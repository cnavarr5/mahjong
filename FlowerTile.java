package Lab3;

import javax.swing.*;
import java.awt.*;

public class FlowerTile extends PictureTile {
  private Image flower;

  public FlowerTile(String name){
    super(name);
    switch(name){
      case "Chrysanthemum":
        flower = new ImageIcon(getClass().getResource("images/Chrysanthemum.png")).getImage();
        break;
      case "Orchid":
        flower = new ImageIcon(getClass().getResource("images/Orchid.png")).getImage();
        break;
      case "Plum":
        flower = new ImageIcon(getClass().getResource("images/Plum.png")).getImage();
        break;
      case "Bamboo":
        flower = new ImageIcon(getClass().getResource("images/Bamboo.png")).getImage();
        break;
    }
  }
  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(flower, 10, 25, this);
  }
}
