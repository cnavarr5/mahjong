package Lab3;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;


/**
 * Implements a generalized system for displaying instructions or help files written in HTML.
 * The Help class extends JScrollPane, which allows large files to be easily viewed while using
 * a small amount of real estate.  Help files may be displayed in a separate frame or displayed
 * on an existing GUI container (JFrame, JPanel, JTabbedPane, etc.).  The Help class also implements
 * the HyperlinkListener interface, which allows hyperlinking HTML help files toghether.  Hyperlinks
 * should be formatted using relative path names.
 */


public class Help extends JPanel implements HyperlinkListener
{
  private	JEditorPane	text = new JEditorPane();
  private	JScrollPane	scroller = new JScrollPane();
  private	JPanel		controls = new JPanel();
  private	Stack<URL>	backStack = new Stack<URL>();
  private	Stack<URL>	forwardStack = new Stack<URL>();
  private	JFrame		frame = null;
  private	URL		currentURL = null;
  private	JButton		back = null;
  private	JButton		next = null;


  /**
   * Builds a help a help system that is displayed in a standalone frame.
   * The frame has three buttons at the bottom: "Back," "Forward," and"Close."  The back button displays
   * the previous help file; the forward button redisplays help files saved when back button is pressed;
   * the back button and forward buttons are inactive and grayed out if there no appropariate pages to
   * display.  The close button makes the help system invisible but does not destroy the help object.
   * The help system uses the <a href="http://java.sun.com/developer/techDocs/hi/repository/">standard Java
   * images</a> and ButtonFactory class.
   * @param file The name of the file containing the HTML formatted help/instructions.
   * @param title The title displayed on the help frame.
   */

  public Help(String file, String title)
  {
    this(file);
    frame = new JFrame();

    JButton close = new JButton("Close");
    close.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        getRootPane().getParent().setVisible(false);
      }
    });

    controls.add(close);

    frame.add(this);
    frame.setSize(800, 600);
    frame.setTitle(title);
    frame.setVisible(true);
  }


  /**
   * Builds a help a help system in the form of a panel that can be displayed in a frame, a panel,
   * a dialog, or other container.
   * The panel has back and forward buttons at the bottom that displays the previous and the next help files.
   * @param file The name of the file containing the HTML formatted help/instructions.
   */

  public Help(String file)
  {
    setLayout(new BorderLayout());
    scroller.setViewportView(text);
    add(scroller);
    text.addHyperlinkListener(this);
    readHTML(file);

    add(controls, BorderLayout.SOUTH);


  }


  /**
   * Pushes the current help page on a stack and displays a new page selected when the
   * user clicks on a hyperlink.  Selecting a new hyperlink invalidates all current links
   * in the forward stack.
   * This method is required by the HyperlinkListener interface.
   * @param e The hyperlink event.
   */

  public void hyperlinkUpdate(HyperlinkEvent e)
  {
    try
    {
      if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
      {
        backStack.push(currentURL);
        currentURL = e.getURL();
        text.setPage(currentURL);
        back.setEnabled(true);
        next.setEnabled(false);
        forwardStack.clear();
      }
    }
    catch (IOException ioe)
    {
      JOptionPane.showMessageDialog(this, "Unable to load page:\n" +
          e.getDescription(),
        "Help Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  // Reads the HTML-formatted file named by "file."

  private void readHTML(String file)
  {
    try
    {
      Document doc = text.getDocument();
      text.setEditable(false);

      currentURL = Help.class.getResource(file);
      text.setPage(currentURL);
    }
    catch (FileNotFoundException FNF)
    {
      JOptionPane.showMessageDialog(this, "Unable to locate help file " + file,
        "Help Error", JOptionPane.ERROR_MESSAGE);
    }
    catch (IOException ioe)
    {
      JOptionPane.showMessageDialog(this, "Unable to locate help file " + file,
        "Help Error", JOptionPane.ERROR_MESSAGE);
    }
  }
  public static void main(String[] args){
    new Help("rules.html", "Test");
  }
}
