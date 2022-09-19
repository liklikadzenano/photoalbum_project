package model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * this is an interface ICanvasModel that adds shapes to the album page
 */
public interface ICanvasModel {
  /**
   * creates and adds the shape to the canvas.
   */
  public void createShape(String name, String type, int x, int y,
                            int width, int height, int r, int g, int b);

  /**
   * changes color of the shape that is already on canvas.
   */
  public void changeColorOfTheShape(String name, int r, int g, int b);

  /**
   * moves the shape to a different location if the shape exist on canvas.
   */
  public void movesShape(String name, int newX, int newY);

  /**
   * changes width of the shape
   */
  public void changesSize(String name, int newWidth, int newHeight);


  /**
   * removes the shape from the canvas  if the name is found.
   */
  public void removesShape(String name);

  /**
   * adds shapes to the canvas list.
   */
  public void addShape(IShape shape);

  /**
   * returns all the shapes on the canvas.
   */
  public Map<String,IShape> getShapes();


  /**
   * takes snapshot of the shapes in canvas.
   * and adds it to the list if snapshots.
   */
  public void takeSnapshot(String description);

  /**
   * returns lis of snapShots.
   */
  public List<Snapshot> getSnapshots();


  /**
   * clears snapshots.
   */
  public void clearSnapshots();

}
