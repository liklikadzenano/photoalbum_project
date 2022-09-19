package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;

import model.IShape;
import model.Rectangle;
import model.Oval;
import model.Snapshot;
import utility.SnapshotPainter;

/**
 * this is the Graphical view class that extends Jframe and implements IView.
 * this class uses Java Swing to draw shapes in the photo album.
 */
public class GraphicalView extends JFrame  implements  IView, ActionListener {
  String outputFile;
  int xMax = 1000;
  int yMax = 1000;
  int i = 0;
  List<Snapshot>snapshots;
  Snapshot currentSnap;
  Map<Timestamp, Snapshot> snapMap;
  SnapshotPainter shapesOnDisplay;
  JButton prev;
  JButton select;
  JButton nextButton;
  JButton quit;


  /**
   * this is the display method.
   * @parameter List of Snapshots.
   * this method is responsible for making the main frame.
   * it sets 3 panels and buttons and gives them the functionality.
   */
  public void display(List<Snapshot> snapshots) throws IOException  {
    this.snapshots = snapshots;
    Map<Timestamp, Snapshot> snapMap = new LinkedHashMap<>();
    this.snapMap = snapMap;
    for(Snapshot snap: snapshots) {
      snapMap.put(snap.getSnapShotID(), snap);
    }

    currentSnap = snapshots.get(i);

    //below panel is of the snapshot ID
    JPanel pinkPanel = new JPanel();
    JLabel label = new JLabel();
    label.setText(currentSnap.getSnapShotID().toString());
    pinkPanel.add(label);
    pinkPanel.setBackground(new Color(241, 156, 187));
    setPreferredSize(new Dimension(1000, 120));
    //this draws shapes on canvas.
    //main panel using paintComponent.
    shapesOnDisplay = new SnapshotPainter(currentSnap.getShapesOnCanvas());
    shapesOnDisplay.setBackground(new Color(0, 187, 165));
    shapesOnDisplay.setPreferredSize(new Dimension(1000,800));
    shapesOnDisplay.drawing();

    //bottom pane where the buttons will be.
    JPanel yellowPanel = new JPanel(); // makes a panel this is where the snapshot ID will go
    yellowPanel.setBackground(new Color(255, 200, 0));
    yellowPanel.setPreferredSize(new Dimension(1000, 40));//the third parameter is width so that will change based on input

    // creating 4 buttons below. but they are not working for some reason.
    prev = new JButton();
    prev.setBounds(10, -980, 30, 20);
    prev.addActionListener(this);
    prev.setText("<<Prev<<");
    prev.setFocusable(false);

    select = new JButton();
    select.setBounds(30, -980, 30, 20);
    select.addActionListener(this);
    select.setText("^^Select^^");
    select.setFocusable(false);

    nextButton = new JButton();
    nextButton.setBounds(50, -980, 30, 20);
    nextButton.addActionListener(this);
    nextButton.setText(">>Next>>");
    nextButton.setFocusable(false);

    quit = new JButton();
    quit.setBounds(70, -980, 30, 20);
    quit.addActionListener(this);
    quit.setText("xx Quit xx");
    quit.setFocusable(false);

    this.setSize(this.xMax, this.yMax); // this has to be generated from command line but for now...
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application.
    this.getContentPane().setBackground(new Color(255, 255, 255));

    yellowPanel.add(prev);
    yellowPanel.add(select);
    yellowPanel.add(nextButton);
    yellowPanel.add(quit);

    this.add(pinkPanel, BorderLayout.NORTH);
    this.add(shapesOnDisplay, BorderLayout.CENTER);
    this.add(yellowPanel, BorderLayout.SOUTH);
    this.setTitle("cs 5004 Shapes Photo Album Viewer");
    this.pack();
    this.setVisible(true); // make frame visible.
  }


  /**
   * this is the method that responds to the button clicks.
   * @param e
   */

  @Override
  public void actionPerformed(ActionEvent e) {

    if(e.getSource() == prev ) {
      if(i > 0 ) {
        i--;
        currentSnap = snapshots.get(i);
        shapesOnDisplay.setShapes(currentSnap.getShapesOnCanvas());

        shapesOnDisplay.setBackground(new Color(0, 187, 165));
        shapesOnDisplay.setPreferredSize(new Dimension(1000,800));
        shapesOnDisplay.repaint();
      }
    } else if(e.getSource() == select) {
      Timestamp[]snapshotIDs = new Timestamp[snapshots.size()]; //list of ID's
      for (int i = 0; i < snapshots.size(); i++) {
        snapshotIDs[i] = snapshots.get(i).getSnapShotID();
      }
      Timestamp input = (Timestamp) JOptionPane.showInputDialog(
              null,
              "Select a snapshot",
              "Go to snapshot",
              JOptionPane.QUESTION_MESSAGE,
              null,
              snapshotIDs,
              this.currentSnap.getSnapShotID());
      if(input != null) {
        currentSnap = snapMap.get(input);
        shapesOnDisplay.setShapes(currentSnap.getShapesOnCanvas());
        shapesOnDisplay.setBackground(new Color(0, 187, 165));
        shapesOnDisplay.setPreferredSize(new Dimension(1000,800));
        shapesOnDisplay.repaint();
      }

      
    } else if (e.getSource()== nextButton) {
      if(i < snapshots.size()-1){
        i++;
        currentSnap = snapshots.get(i);
        shapesOnDisplay.setShapes(currentSnap.getShapesOnCanvas());
        shapesOnDisplay.setBackground(new Color(0, 187, 165));
        shapesOnDisplay.setPreferredSize(new Dimension(1000,800));
        shapesOnDisplay.repaint();

      } else {
        JOptionPane.showMessageDialog(null,"end of the photo album no more snapshots",
                "Message", JOptionPane.INFORMATION_MESSAGE);
      }
    }else if(e.getSource() == quit) {
      System.exit(0);
    }
  }


  /**
   * this sets the maximum value of the width of the frame.
   * @param xMax
   */
  @Override
  public void setxMax(int xMax) {
    this.xMax = xMax;
  }

  /**
   * this method sets the output file of the view.
   * this is only relevant for the web view.
   */
  @Override
  public void setOutputFile(String outputFile) {
    this.outputFile = outputFile;
  }

  /**
   * sets the maximum height of the frame.
   * @param yMax
   */
  public void setyMax(int yMax) {
    this.yMax = yMax;
  }
}

