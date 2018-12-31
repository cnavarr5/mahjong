package Lab3;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class CircleTile extends RankTile {
  public Circle[] circles = new Circle[9];
  public CircleTile(int rank){
    super(rank);
    switch(rank) {
      case 1:
        circles[0] = new Pancake(13, 28, Color.GREEN);
        break;
      case 2:
        circles[0] = new Circle(30, 25, Color.GREEN);
        circles[1] = new Circle(30, 60, Color.RED);
        break;
      case 3:
        circles[0] = new Circle(10, 20, Color.BLUE);
        circles[1] = new Circle(30, 40, Color.GREEN);
        circles[2] = new Circle(50, 60, Color.RED);
        break;
      case 4:
        circles[0] = new Circle(10, 20, Color.BLUE);
        circles[1] = new Circle(55, 20, Color.GREEN);
        circles[2] = new Circle(10, 60, Color.GREEN);
        circles[3] = new Circle(55, 60, Color.BLUE);
        break;
      case 5:
        circles[0] = new Circle(10, 20, Color.BLUE);
        circles[1] = new Circle(55, 20, Color.GREEN);
        circles[2] = new Circle(10, 60, Color.GREEN);
        circles[3] = new Circle(55, 60, Color.BLUE);
        circles[4] = new Circle(30, 40, Color.RED);
        break;
      case 6:
        circles[0] = new Circle(10, 10, Color.GREEN);
        circles[1] = new Circle(55, 10, Color.GREEN);
        circles[2] = new Circle(10, 60, Color.RED);
        circles[3] = new Circle(55, 60, Color.RED);
        circles[4] = new Circle(10, 35, Color.RED);
        circles[5] = new Circle(55, 35, Color.RED);
        break;

      case 7:
        circles[0] = new Circle(15, 15, Color.GREEN);
        circles[1] = new Circle(30, 25, Color.GREEN);
        circles[2] = new Circle(45, 35, Color.GREEN);
        circles[3] = new Circle(15, 80, Color.RED);
        circles[4] = new Circle(40, 80, Color.RED);
        circles[5] = new Circle(15, 60, Color.RED);
        circles[6] = new Circle(40, 60, Color.RED);
        break;
      case 8:
        circles[0] = new Circle(10, 20, Color.BLUE);
        circles[1] = new Circle(55, 20, Color.BLUE);
        circles[2] = new Circle(10, 80, Color.BLUE);
        circles[3] = new Circle(55, 80, Color.BLUE);
        circles[4] = new Circle(10, 40, Color.BLUE);
        circles[5] = new Circle(55, 40, Color.BLUE);
        circles[6] = new Circle(10, 60, Color.BLUE);
        circles[7] = new Circle(55, 60, Color.BLUE);
        break;
      case 9:
        circles[0] = new Circle(5, 10, Color.GREEN);
        circles[1] = new Circle(50, 10, Color.GREEN);
        circles[2] = new Circle(5, 70, Color.BLUE);
        circles[3] = new Circle(50, 70, Color.BLUE);
        circles[4] = new Circle(5, 40, Color.RED);
        circles[5] = new Circle(50, 40, Color.RED);
        circles[6] = new Circle(25, 10, Color.GREEN);
        circles[7] = new Circle(25, 40, Color.RED);
        circles[8] = new Circle(25, 70, Color.BLUE);
        break;
    }
    setToolTipText(toString());
  }
  @Override
  public boolean matches(Tile other){
    if(!super.matches(other)){return false;}
    CircleTile otherTile = (CircleTile) other;
    if(this.rank == otherTile.rank){return true;}
    else return false;
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);

    for (Circle c : circles)
      if (c != null)
        c.draw(g);
  }

  public String toString(){
    return "Circle " + this.rank;
  }
  public static void main(String [] args){
    JFrame frame = new JFrame();

    frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Tile");

    frame.add(new CircleTile(9));

    frame.pack();
    frame.setVisible(true);
  }
}
