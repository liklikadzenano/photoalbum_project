package view;

import java.io.IOException;
import java.util.List;

import model.IShape;
import model.Snapshot;

/**
 * IView an interface.
 * int has methods to be implemented.
 * by different kinds of views.
 */
public interface IView {

  /**
   * this is the method that displays the view.
   * @parameter list of Snapshots.
   */
  public void display (List<Snapshot> snapshot) throws IOException;

  /**
   * this sets the maximum value of the width of the frame.
   * @param xMax
   */
  public void setxMax(int xMax);

  /**
   * this method sets the output file of the view.
   * this is only relevant for the web view.
   */
  public void setOutputFile(String outputFile);
  /**
   * sets the maximum height of the frame.
   * @param yMax
   */
  public void setyMax(int yMax);

}
