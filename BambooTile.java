package Lab3;

import java.awt.*;

public class BambooTile extends RankTile {
  public Bamboo[] bamboos = new Bamboo[9];

  public BambooTile(int rank){
    super(rank);
    //Subtracted 20 from all Ys, 10 from all Xs
    switch(rank){
      case 2:
        bamboos[0] = new Bamboo(30, 10, Color.BLUE);
        bamboos[1] = new Bamboo(30, 65, Color.GREEN);
        break;
      case 3:
        bamboos[0] = new Bamboo(30, 10, Color.BLUE);
        bamboos[1] = new Bamboo(5, 55, Color.GREEN);
        bamboos[3] = new Bamboo(55, 55, Color.GREEN);
        break;
      case 4:
        bamboos[0] = new Bamboo(10, 20, Color.BLUE);
        bamboos[1] = new Bamboo(10, 55, Color.GREEN);
        bamboos[2] = new Bamboo(50, 55, Color.BLUE);
        bamboos[3] = new Bamboo(50, 20, Color.GREEN);
        break;
      case 5:
        bamboos[0] = new Bamboo(10, 10, Color.BLUE);
        bamboos[1] = new Bamboo(10, 65, Color.GREEN);
        bamboos[2] = new Bamboo(45, 65, Color.BLUE);
        bamboos[3] = new Bamboo(45, 10, Color.GREEN);
        bamboos[4] = new Bamboo(27, 35, Color.RED);
        break;
      case 6:
        bamboos[0] = new Bamboo(10, 20, Color.BLUE);
        bamboos[1] = new Bamboo(10, 55, Color.GREEN);
        bamboos[2] = new Bamboo(50, 55, Color.GREEN);
        bamboos[3] = new Bamboo(50, 20, Color.BLUE);
        bamboos[4] = new Bamboo(30, 20, Color.BLUE);
        bamboos[5] = new Bamboo(30, 55, Color.GREEN);
        break;
      case 7:
        bamboos[0] = new Bamboo(10, 35, Color.BLUE);
        bamboos[1] = new Bamboo(10, 70, Color.GREEN);
        bamboos[2] = new Bamboo(50, 70, Color.GREEN);
        bamboos[3] = new Bamboo(50, 35, Color.BLUE);
        bamboos[4] = new Bamboo(30, 35, Color.BLUE);
        bamboos[5] = new Bamboo(30, 70, Color.GREEN);
        bamboos[7] = new Bamboo(30, 0, Color.RED);
        break;
      case 8:
        bamboos[0] = new Bamboo(5, 5, Color.BLUE);
        bamboos[1] = new Bamboo(5, 70, Color.GREEN);
        bamboos[2] = new Bamboo(45, 70, Color.GREEN);
        bamboos[3] = new Bamboo(45, 5, Color.BLUE);
        bamboos[4] = new Bamboo(25, 5, Color.BLUE);
        bamboos[5] = new Bamboo(25, 70, Color.GREEN);
        bamboos[6] = new Bamboo(10, 38, Color.RED);
        bamboos[7] = new Bamboo(40, 38, Color.RED);
        break;
      case 9:
        bamboos[0] = new Bamboo(5, 5, Color.BLUE);
        bamboos[1] = new Bamboo(5, 65, Color.GREEN);
        bamboos[2] = new Bamboo(50, 65, Color.GREEN);
        bamboos[3] = new Bamboo(50, 5, Color.BLUE);
        bamboos[4] = new Bamboo(28, 5, Color.BLUE);
        bamboos[5] = new Bamboo(28, 65, Color.GREEN);
        bamboos[6] = new Bamboo(5, 35, Color.RED);
        bamboos[7] = new Bamboo(50, 35, Color.RED);
        bamboos[8] = new Bamboo(28, 35, Color.RED);
        break;
    }
    setToolTipText(toString());
  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);

    for (Bamboo b : bamboos)
      if (b != null)
        b.draw(g);
  }
  public String toString(){
    return "Bamboo "+this.rank;
  }
}
