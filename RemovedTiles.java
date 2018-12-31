package Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Stack;

public class RemovedTiles extends JFrame {

  public boolean visible;
  private	GridBagLayout	layout = new GridBagLayout();
  private	GridBagConstraints constraints = new GridBagConstraints();
  private	JPanel	tilePanel = new JPanel(layout);
  private Tile temp = new Tile();

  public RemovedTiles(Stack<Tile> undone)
  {
    for(Tile t: undone){
      System.out.println(t.toString()+" From the RemovedTiles class");
    }
    setPreferredSize(new Dimension(200, 360));
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setTitle("Removed Tiles");

    constraints.ipadx = 5;
    constraints.ipady = 5;
    constraints.insets = new Insets(5, 5, 5, 5);
    add(new JScrollPane(tilePanel));

    int row = 0;
    int col = 0;
    int index = 0;

    for(Tile t: undone) {
      temp = undone.get(index);
      temp.resetColor();
      if (index % 2 == 0) {
        temp.setVisible(true);
        addComponent(temp, row, col);
        row++;
      } else {
        temp.setVisible(true);
        addComponent(temp, row, col);
        col++;
        row = 0;
      }
      index++;
      repaintPane();
    }

    pack();
    this.setVisible(true);
    tilePanel.setBackground(new Color(254, 205, 33));
    }


  public void repaintPane(){
    repaint();
  }

  private void addComponent(Component c, int row, int col)
  {
    constraints.gridx = col;
    constraints.gridy = row;
    layout.setConstraints(c, constraints);
    tilePanel.add(c);
  }

  public static void main(String[] args)
  {
    Stack<Tile> test = new Stack<>();

    test.push(new CharacterTile('1'));
    test.push(new CharacterTile('2'));
    test.push(new CharacterTile('3'));
    test.push(new CharacterTile('4'));
    test.push(new CharacterTile('5'));
    test.push(new CharacterTile('6'));
    test.push(new CharacterTile('7'));
    test.push(new CharacterTile('8'));
    test.push(new CharacterTile('9'));

    test.push(new CircleTile(1));
    test.push(new CircleTile(2));
    test.push(new CircleTile(3));
    test.push(new CircleTile(4));
    test.push(new CircleTile(5));
    test.push(new CircleTile(6));
    test.push(new CircleTile(7));
    test.push(new CircleTile(8));
    test.push(new CircleTile(9));

    test.push(new Bamboo1Tile());
    test.push(new BambooTile(2));
    test.push(new BambooTile(3));
    test.push(new BambooTile(4));
    test.push(new BambooTile(5));
    test.push(new BambooTile(6));
    test.push(new BambooTile(7));
    test.push(new BambooTile(8));
    test.push(new BambooTile(9));

    test.push(new CharacterTile('N'));
    test.push(new CharacterTile('E'));
    test.push(new CharacterTile('W'));
    test.push(new CharacterTile('S'));

    test.push(new CharacterTile('C'));
    test.push(new CharacterTile('F'));
    test.push(new WhiteDragonTile());

    test.push(new FlowerTile("Chrysanthemum"));
    test.push(new FlowerTile("Orchid"));
    test.push(new FlowerTile("Plum"));
    test.push(new FlowerTile("Bamboo"));

    test.push(new SeasonTile("Spring"));
    test.push(new SeasonTile("Summer"));
    test.push(new SeasonTile("Fall"));
    test.push(new SeasonTile("Winter"));


    RemovedTiles demo = new RemovedTiles(test);
//    JFrame frame = new JFrame();
//
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setSize(400, 250);
//    frame.setVisible(true);

  }
}
