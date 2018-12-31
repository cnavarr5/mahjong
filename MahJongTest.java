package Lab3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.util.Stack;
import javax.swing.*;

public class MahJongTest extends JFrame
{
  public TileDeck deck = new TileDeck();
  public static Tile[][][] board = new Tile[15][8][4];
  public static Tile peakTile;
  public Stack<Tile> pairStack = new Stack<Tile>();
  public Stack<Tile> undo = new Stack<Tile>();
  public JButton btn = new JButton("Undo");
  public RemovedTiles list;
  public boolean tournamentMode = false;
  public long thisSeed;
  public boolean soundOn = true;

	public MahJongTest(){
	  while(undo.size() == deck.getSize()){
	    checkForWin();
    }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newDeck();
    makeMenu();
    btn.setLocation(0, 0);
    btn.setSize(100, 100);
    ActionListener a = new Action() {
      @Override
      public Object getValue(String key) {return null;}
      @Override
      public void putValue(String key, Object value) {}
      @Override
      public void setEnabled(boolean b) {}
      @Override
      public boolean isEnabled(){return false;}
      @Override
      public void addPropertyChangeListener(PropertyChangeListener listener) {}
      @Override
      public void removePropertyChangeListener(PropertyChangeListener listener) {}
      @Override
      public void actionPerformed(ActionEvent e) {
        undo();
      }
    };
    btn.addActionListener(a);
    add(btn);
		add(new Board());
    add(new Background());

    setSize(1400, 800);
		setVisible(true);
	}
	public MahJongTest(long seed){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      seedDeck(seed);
      makeMenu();
      btn.setLocation(0, 0);
      btn.setSize(100, 100);
      ActionListener a = new Action() {
        @Override
        public Object getValue(String key) {return null;}
        @Override
        public void putValue(String key, Object value) {}
        @Override
        public void setEnabled(boolean b) {}
        @Override
        public boolean isEnabled(){return false;}
        @Override
        public void addPropertyChangeListener(PropertyChangeListener listener) {}
        @Override
        public void removePropertyChangeListener(PropertyChangeListener listener) {}
        @Override
        public void actionPerformed(ActionEvent e) {
          undo();
        }
      };
      btn.addActionListener(a);
      add(btn);
      add(new Board());
      add(new Background());

      setSize(1400, 800);
      setVisible(true);
    }
  public MahJongTest(boolean tournament){
    while(undo.size() == deck.getSize()){
      checkForWin();
    }
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    newDeck();
    makeMenu(true);
    add(new Board());
    add(new Background());

    setSize(1400, 800);
    setVisible(true);
  }

	public void newDeck(){
    deck.shuffle();
    this.thisSeed = deck.ranSeed;
    //Layer 1, variable lengths
    for(int i = 1; i  < 13; i++){
      board[i][0][0] = deck.deal();
    }
    for(int i = 3; i < 11; i++){
      board[i][1][0] = deck.deal();
    }
    for(int i = 2; i < 12; i++){
      board[i][2][0] = deck.deal();
    }
    for(int i = 0; i  < 15; i++){
      board[i][3][0] = deck.deal();
    }
    for(int i = 1; i  < 13; i++){
      board[i][4][0] = deck.deal();
    }
    for(int i = 2; i < 12; i++){
      board[i][5][0] = deck.deal();
    }
    for(int i = 3; i < 11; i++){
      board[i][6][0] = deck.deal();
    }
    for(int i = 1; i  < 13; i++){
      board[i][7][0] = deck.deal();
    }

    //Layer 2 6x6
    for(int x = 4; x < 10; x++){
      for(int y = 1; y<7;y++){
        board[x][y][1] = deck.deal();
      }
    }
    //Layer 3
    for(int x = 5; x < 9; x++){
      for(int y = 2; y<6;y++){
        board[x][y][2] = deck.deal();
      }
    }
    //Layer 4
    for(int x = 6; x < 8; x++){
      for(int y = 3; y < 5; y++){
        board[x][y][3] = deck.deal();
      }
    }

    peakTile = deck.deal();
  }
  public void seedDeck(long seed){
    deck.shuffle(seed);
    //Layer 1, variable lengths
    for(int i = 1; i  < 13; i++){
      board[i][0][0] = deck.deal();
    }
    for(int i = 3; i < 11; i++){
      board[i][1][0] = deck.deal();
    }
    for(int i = 2; i < 12; i++){
      board[i][2][0] = deck.deal();
    }
    for(int i = 0; i  < 15; i++){
      board[i][3][0] = deck.deal();
    }
    for(int i = 1; i  < 13; i++){
      board[i][4][0] = deck.deal();
    }
    for(int i = 2; i < 12; i++){
      board[i][5][0] = deck.deal();
    }
    for(int i = 3; i < 11; i++){
      board[i][6][0] = deck.deal();
    }
    for(int i = 1; i  < 13; i++){
      board[i][7][0] = deck.deal();
    }

    //Layer 2 6x6
    for(int x = 4; x < 10; x++){
      for(int y = 1; y<7;y++){
        board[x][y][1] = deck.deal();
      }
    }
    //Layer 3
    for(int x = 5; x < 9; x++){
      for(int y = 2; y<6;y++){
        board[x][y][2] = deck.deal();
      }
    }
    //Layer 4
    for(int x = 6; x < 8; x++){
      for(int y = 3; y < 5; y++){
        board[x][y][3] = deck.deal();
      }
    }

    peakTile = deck.deal();
  }

	public void toggleSound(){
	 System.out.println(soundOn);
   soundOn = !soundOn;
   System.out.println(soundOn);
  }

  public void setTournamentMode(){
	 if( JOptionPane.showConfirmDialog(this, "Enable Tournament mode?") == 0){
	   this.setVisible(false);
	   new MahJongTest(true);
   }
  }

	public void restart(){
	  int confirm = JOptionPane.showConfirmDialog(this, "Restart Game?");
	  if(confirm == 0) {
	    this.setVisible(false);
      new MahJongTest(thisSeed);
    } else{
	    System.out.println("Did not restart");
    }
  }

  public void numberedGame(){
    int confirm = JOptionPane.showConfirmDialog(this, "Restart Game?");
    if(confirm == 0) {
      this.setVisible(false);
      String seedStr = JOptionPane.showInputDialog(this, "Input Seed Number");
      int seed = Integer.parseInt(seedStr);
      new MahJongTest(seed);
    } else{
      System.out.println("Did not restart");
    }
  }

  public void makeNewGame(){
	  if(JOptionPane.showConfirmDialog(this, "New game? Progress will be lost") == 0){
	    this.setVisible(false);
	    new MahJongTest();
    }
  }

  public void showRemovedTilesPane(){
    list = new RemovedTiles(undo);
  }

  public void makeMenu(boolean tournamentMode){
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);

    JMenu gameOptions = new JMenu("Game Options");
    menuBar.add(gameOptions);

    JMenu help = new JMenu("Help");
    menuBar.add(help);

    JMenuItem helpRules = new JMenuItem("Rules");
    help.add(helpRules);
    helpRules.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new Help("rules.html", "Rules");
      }
    });


    JMenuItem helpOperations = new JMenuItem("Operations");
    help.add(helpOperations);
    helpOperations.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new Help("operations.html", "Operations");
      }
    });

    JMenuItem newGame = new JMenuItem("New Game");
    newGame.setToolTipText("newGame");
    gameOptions.add(newGame);
    newGame.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        makeNewGame();
      }
    });

    JMenuItem restartGame = new JMenuItem("Restart");
    restartGame.setToolTipText("Restart Game");
    gameOptions.add(restartGame);
    restartGame.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        restart();
      }
    });

    JMenuItem toggleSound = new JMenuItem("Toggle Sound");
    toggleSound.setToolTipText("Sound currently on?");
    gameOptions.add(toggleSound);
    toggleSound.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        toggleSound();
      }
    });
  }

  public void makeMenu(){
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);

    JMenu gameOptions = new JMenu("Game Options");
    menuBar.add(gameOptions);

    JMenu help = new JMenu("Help");
    menuBar.add(help);

    JMenuItem helpRules = new JMenuItem("Rules");
    help.add(helpRules);
    helpRules.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new Help("rules.html", "Rules");
      }
    });

    JMenuItem helpOperations = new JMenuItem("Operations");
    help.add(helpOperations);
    helpOperations.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new Help("operations.html", "Operations");
      }
    });

    JMenuItem tournament = new JMenuItem("Enable Tournament Mode");
    tournament.setToolTipText("Enable Tournament Mode");
    gameOptions.add(tournament);
    tournament.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setTournamentMode();
      }
    });

    JMenuItem newGame = new JMenuItem("New Game");
    newGame.setToolTipText("newGame");
    gameOptions.add(newGame);
    newGame.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        makeNewGame();
      }
    });

    JMenuItem restartGame = new JMenuItem("Restart");
    restartGame.setToolTipText("Restart Game");
    gameOptions.add(restartGame);
    restartGame.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        restart();
      }
    });

    JMenuItem numberedGame = new JMenuItem("Numbered Game");
    numberedGame.setToolTipText("Play a numbered game");
    gameOptions.add(numberedGame);
    numberedGame.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        numberedGame();
      }
    });

    JMenuItem showUndo = new JMenuItem("Undo stack");
    showUndo.setToolTipText("Display Moves");
    gameOptions.add(showUndo);
    showUndo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        showRemovedTilesPane();
      }
    });
    JMenuItem toggleSound = new JMenuItem("Toggle Sound");
    toggleSound.setToolTipText("Sound currently on?");
    gameOptions.add(toggleSound);
    toggleSound.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        toggleSound();
      }
    });
  }

	public void undo() {
    for(Tile t: undo){
      t.resetColor();
    }
      if (!undo.isEmpty()) {
        Tile popped = undo.pop();
        Tile popped2 = undo.pop();
        popped.placeBack();
        popped2.placeBack();
        System.out.println(popped.toString()+" Undone 1. Removed? " + popped.removed);
        popped.setVisible(true);
//        positionTile(popped, 75+(popped.getWidth() * popped.xSpace) - (popped.xSpace * popped.getWidth() / 3) - 50,
//          (popped.ySpace * popped.getHeight()) - popped.ySpace * 45 - 122);
        System.out.println(popped2.toString()+" Undone 2. Removed? "+popped2.removed);
        popped2.setVisible(true);
        popped.addMouseListener(new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent e) {
            logicForMouse(e, this);
          }

          @Override
          public void mousePressed(MouseEvent e) {
          }

          @Override
          public void mouseReleased(MouseEvent e) {
          }

          @Override
          public void mouseEntered(MouseEvent e) {
          }

          @Override
          public void mouseExited(MouseEvent e) {
          }
        });
        popped2.addMouseListener(new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent e) {
            logicForMouse(e, this);
          }

          @Override
          public void mousePressed(MouseEvent e) {
          }

          @Override
          public void mouseReleased(MouseEvent e) {
          }

          @Override
          public void mouseEntered(MouseEvent e) {
          }

          @Override
          public void mouseExited(MouseEvent e) {
          }
        });
      } else {
        System.out.println("Nothing to undo");
      }
  }

	public void positionTile(Tile t, int x, int y){
	  t.setLocation(x, y);
	  add(t);
  }

  public boolean match(Stack<Tile> pair){
    if(pairStack.size() == 2) {
      return pairStack.get(0).matches(pairStack.get(1));
    }
    else return false;
  }

  public class Background extends JPanel {
    public Image bg = new ImageIcon(getClass().getResource("images/dragon_bg.png")).getImage().getScaledInstance(1400, 800, Image.SCALE_FAST);
    public Background(){
      setOpaque(false);
      setSize(new Dimension(1400, 800));
    }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.YELLOW);
      g.fillRect(0, 0, 1400, 800);
      g.drawImage(bg, 0, 0, this);
    }
  }

	public class Board extends JPanel implements MouseListener{

		public Board()
		{
		  setLayout(null);

		  if(!peakTile.isOpen()) {
        positionTile(peakTile, 25+(peakTile.getWidth() * 3) + 125, peakTile.getHeight() * 2 - 100);
        peakTile.zSpace = 4;
      }
      peakTile.addMouseListener(this);

      for(int x = 14; x >= 0; x--){
        for(int y = 7; y >= 0; y--){
          if(board[x][y][3] != null){
            Tile t = board[x][y][3];
            t.addMouseListener(this);
            t.ySpace = y;
            t.xSpace = x;
            t.zSpace = 3;
            if(!t.isOpen()) {
              positionTile(t, 75+(t.getWidth() * x) - (x * t.getWidth() / 3) - 50, (y * t.getHeight()) - y * 45 - 122);
            }
          }
        }
      }
      for(int x = 14; x >= 0; x--){
        for(int y = 7; y >= 0; y--){
          if(board[x][y][2] != null){
            Tile t = board[x][y][2];
            t.addMouseListener(this);
            t.ySpace = y;
            t.xSpace = x;
            t.zSpace = 2;
            if(!t.isOpen()) {
              positionTile(t, 50+(t.getWidth() * x) - (x * t.getWidth() / 3), (y * t.getHeight()) - y * 45 - 80);
            }
          }
        }
      }
      for(int x = 14; x >= 0; x--){
        for(int y = 7; y >= 0; y--){
          if(board[x][y][1] != null){
            Tile t = board[x][y][1];
            t.addMouseListener(this);
            t.ySpace = y;
            t.xSpace = x;
            t.zSpace = 1;
            if(!t.isOpen()) {
              positionTile(t, 70 + (t.getWidth() * x) - (x * t.getWidth() / 3), (y * t.getHeight()) - y * 45 - 40);
            }
          }
        }
      }
      for(int x = 14; x >= 0; x--){
        for(int y = 7; y >= 0; y--){
          if(board[x][y][0] != null){
            Tile t = board[x][y][0];
            t.addMouseListener(this);
            t.ySpace = y;
            t.xSpace = x;
            t.zSpace = 0;
            if(!t.isOpen()) {
              positionTile(t, 100 + (t.getWidth() * x) - (x * t.getWidth() / 3), (y * t.getHeight()) - y * 45);
            }
          }
        }
      }

		}
    public void mousePressed(MouseEvent e)
    {
      logicForMouse(e, this);
    }

    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

	}

	public boolean checkIfRemovable(Tile t, Tile[][][] board){
    int xp = t.getXSpace();
    int yp = t.getYSpace();
    int zp = t.getZSpace();
    if(t == peakTile){
      System.out.println("This is the peak tile");
      return true;
    } else {

      if(xp == 0){
        System.out.println("Removable");
        return true;
      }
      if(xp == 14){
        System.out.println("Removable true");
        return true;
      }
      if((
        ( zp < 3 &&((board[xp][yp][zp+1] == null || board[xp][yp][zp+1].removed))&&
          ((board[xp+1][yp][zp] == null || board[xp+1][yp][zp].removed))
        ||((board[xp-1][yp][zp] == null || board[xp-1][yp][zp].removed))))){
        System.out.println("Removable");
        return true;
      }  else {
          System.out.println("Not Removable");
          return false;
        }
    }
  }

  public static void main(String[] args)
	{
		new MahJongTest();
	}

	public void tryRepainting(){
    repaint();
  }

  public void checkForWin(){
	  System.out.println(undo.size());
    if(undo.size() >= 142){
      System.out.println("You WIN!");
      this.setVisible(false);
      JFrame frame = new JFrame();
      Fireworks	fw = new Fireworks();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1000, 800);
      frame.add(fw.getPanel());
      frame.setVisible(true);

      fw.setExplosions(0, 1000);
      fw.fire();

      try
      {
        Thread.sleep(10000);
        fw.stop();
      }
      catch (InterruptedException ie) {}
    }
  }

  public void playStoneSound() {
    if (soundOn) {
      try {
        PlayClip clip = new PlayClip("stone-scraping.wav", true);

        clip.play();
        Thread.sleep(200);

      } catch (InterruptedException ie) {
      }
    }
  }

  public void logicForMouse(MouseEvent e, MouseListener l){
    Tile tile = (Tile) e.getSource();
    pairStack.add(tile);
    tile.setColor();
    tryRepainting();
//    System.out.println(tile.toString()+" Added to hand");
    for(Tile t: pairStack){
//      System.out.println(t.toString());
    }
//    System.out.println(pairStack.size());
    if(pairStack.size() == 2)
//      System.out.println("In here");
    if (match(pairStack) && (checkIfRemovable(pairStack.get(0), board) && checkIfRemovable(pairStack.get(1), board))){
//      System.out.println("Removing");
      checkForWin();
      pairStack.get(0).removeMouseListener(l);
      pairStack.get(1).removeMouseListener(l);
//    tile.removeMouseListener(this);

      if (e.getButton() == MouseEvent.BUTTON1) {
          pairStack.get(0).setVisible(false);
          pairStack.get(1).setVisible(false);
          playStoneSound();

          pairStack.get(0).remove();
          pairStack.get(1).remove();
          undo.add(pairStack.get(0));
          undo.add(pairStack.get(1));
          pairStack = new Stack<Tile>();
      }
    }
    else if(pairStack.size() >= 2){
      checkForWin();
      for(Tile t: pairStack){
        t.resetColor();
        pairStack = new Stack<Tile>();
      }
      pairStack = new Stack<Tile>();
      JOptionPane.showMessageDialog(this, "Pair does not match or a tile could not be removed");
      pairStack = new Stack<Tile>();
    }
  }


}

