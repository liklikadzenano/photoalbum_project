package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * class Album represents the album page.
 */
public class Canvas implements ICanvasModel{
  private Map<String,IShape> shapesOnCanvas = new LinkedHashMap<>();
  private List<Snapshot> snapshots = new ArrayList<>();


  /**
   * creates the shape on the  album page.
   */
  @Override
  public void createShape(String name, String type, int x, int y,
                            int width, int height, int r, int g, int b) throws IllegalArgumentException {
    if(type == "" || type == null) {
      throw new IllegalArgumentException("the type cannot be empty");
    }
    else if(type.equalsIgnoreCase("oval")) {
      Oval oval = new Oval(name, x, y, width, height, r, g, b);
      shapesOnCanvas.put(oval.getName(), oval);
    }
    else if(type.equalsIgnoreCase("rectangle")) {
      Rectangle rectangle = new Rectangle(name, x, y, width, height, r, g, b);
      shapesOnCanvas.put(rectangle.getName(), rectangle);
    }
  }


  /**
   * adds shapes to the canvas.
   */
  @Override
  public void addShape(IShape shape) {
    shapesOnCanvas.put(shape.getName(), shape);
  }

  /**
   * changes color of the shape that is already on canvas.
   */
  @Override
  public void changeColorOfTheShape(String name, int r, int g, int b) throws NoSuchElementException {
    if (shapesOnCanvas.containsKey(name)) {
      shapesOnCanvas.get(name).changeColor(r, g, b);
    } else {
      throw new NoSuchElementException("the element indicated cannot be found");
    }
  }

  /**
   * moves the shape to a different location if the shape exist on canvas.
   */
  @Override
  public void movesShape(String name, int newX, int newY) throws NoSuchElementException {
    if (shapesOnCanvas.containsKey(name)) {
      shapesOnCanvas.get(name).move(newX,newY);
    }
    else {
      throw new NoSuchElementException("the element indicated cannot be found");
    }
  }

  /**
   * changes width of the shape
   */
  @Override
  public void changesSize(String name, int newWidth, int newHeight) throws NoSuchElementException {
    if (shapesOnCanvas.containsKey(name)) {
      shapesOnCanvas.get(name).changeSize(newWidth, newHeight);
    } else {
      throw new NoSuchElementException("the element indicated cannot be found");
    }

  }



  /**
   * removes the shape if that shape exists on canvas.
   */
  @Override
  public void removesShape(String name) throws NoSuchElementException {
    if (shapesOnCanvas.containsKey(name)) {
      shapesOnCanvas.remove(name);
    } else {
      throw new NoSuchElementException("The element does not exist");
    }

  }


  /**
   * gets the list of shapes in the canvas.
   */
  @Override
  public Map<String, IShape> getShapes() {
    return shapesOnCanvas;
  }


  /**
   * takes a snapshot of a canvas.
   */
  @Override
  public void takeSnapshot(String description) {
    Date date = new Date();
    Timestamp snapshotID = new Timestamp(date.getTime());
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    List<IShape> copyOfShapes = new ArrayList<>();
    for (Map.Entry<String, IShape> entry : shapesOnCanvas.entrySet()) {
      copyOfShapes.add(entry.getValue().copy());
    }

    Snapshot snapshot = new Snapshot(snapshotID,timestamp,description,copyOfShapes);
    snapshots.add(snapshot);
  }

  /**
   * return list of snapshots.
   */
  public List<Snapshot> getSnapshots() {
    return snapshots;
  }


  /**
   * this method clears snapshots.
   */
  @Override
  public void clearSnapshots() {
    snapshots.clear();

  }

}





