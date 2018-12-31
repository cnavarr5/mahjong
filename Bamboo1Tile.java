package Lab3;

import javax.swing.*;
import java.awt.*;

public class Bamboo1Tile extends PictureTile {

  private Image sparrow = new ImageIcon(getClass().getResource("images/Sparrow.png")).getImage();


  public Bamboo1Tile(){
    super("Sparrow");
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);

    g.drawImage(sparrow, 10, 25, this);
  }

  public String toString(){
    return "Bamboo 1";
  }
}
