package Lab3;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CharacterTile extends Tile {
  protected char symbol;
  static HashMap<Character, Character> map = new HashMap<>();

  static {
    map.put('1', '\u4e00');
    map.put('2', '\u4e8c');
    map.put('3', '\u4e09');
    map.put('4', '\u56db');
    map.put('5', '\u4e94');
    map.put('6', '\u516d');
    map.put('7', '\u4e03');
    map.put('8', '\u516b');
    map.put('9', '\u4e5d');
    map.put('N', '\u5317');
    map.put('E', '\u6771');
    map.put('W', '\u897F');
    map.put('S', '\u5357');
    map.put('C', '\u4e2d');
    map.put('F', '\u767c');
  }

  public CharacterTile(char symbol){
    this.symbol = symbol;
    setToolTipText(toString());
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    String num = this.symbol+"";
    String text = this.toChinese();
    String wan = '\u842C' + "";
    g.setColor(Color.BLACK);
    Font f = g.getFont().deriveFont(28F);
    g.setFont(f);

    if(Character.isDigit(this.symbol)){
      g.drawString(num, getWidth()/2-5, getHeight()/ 5);
      g.drawString(text, getWidth() / 2 - 40, getHeight() / 3);
      g.setColor(Color.RED);
      g.drawString(wan, getWidth() / 2 - 40, getHeight() / 2+20);
    }
    else {
      f = g.getFont().deriveFont(28F);
      g.drawString(num, getWidth()/2-15, getHeight()/4);
      f = g.getFont().deriveFont(52F);
      g.setFont(f);
      if(this.symbol == 'C'){
        g.setColor(Color.RED);
      } else if(this.symbol == 'F') {
        g.setColor(Color.GREEN);
      } else{
        g.setColor(Color.BLACK);
      }
      g.drawString(text, (getWidth()/2)-50, getHeight() / 2+20);
      ;
    }
  }
  @Override
  public boolean matches(Tile other){
    if(!super.matches(other)){return false;}
    CharacterTile otherChar = (CharacterTile) other;
    if(this.symbol == otherChar.symbol){return true;}
    else return false;
  }

  public String toChinese(){
    char chin = map.get(this.symbol);
    return chin+"";
  }

  public String toString(){
    switch (symbol){
      case 'N':
        return "North Wind";
      case 'E':
        return "East Wind";
      case 'W':
        return "West Wind";
      case 'S':
        return "South Wind";
      case 'C':
        return "Red Dragon";
      case 'F':
        return "Green Dragon";
    }
    return "Character "+this.symbol;
  }

  public static void main(String [] args){
    JFrame frame = new JFrame();

    frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Tile");

    frame.add(new CharacterTile('N'), 3, 0);
    frame.add(new CharacterTile('E'), 3, 1);
    frame.add(new CharacterTile('W'), 3, 2);
    frame.add(new CharacterTile('S'), 3, 3);

    frame.pack();
    frame.setVisible(true);
  }
}
