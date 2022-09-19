import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.ICanvasModel;
import model.IShape;
import model.Oval;
import model.Rectangle;
import model.Snapshot;

public class MokModel implements ICanvasModel {
  private Map<String,IShape> shapesOnCanvas = new LinkedHashMap<>();
  List<Snapshot>snapshots = new ArrayList<>();

  @Override
  public void createShape(String name, String type, int x, int y, int width, int height, int r, int g, int b) {
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

  @Override
  public void changeColorOfTheShape(String name, int r, int g, int b) {

  }

  @Override
  public void movesShape(String name, int newX, int newY) {

  }

  @Override
  public void changesSize(String name, int newWidth, int newHeight) {

  }

  @Override
  public void removesShape(String name) {

  }

  @Override
  public void addShape(IShape shape) {

  }

  @Override
  public Map<String, IShape> getShapes() {
    return null;
  }

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

  @Override
  public List<Snapshot> getSnapshots() {
    return this.snapshots;
  }

  @Override
  public void clearSnapshots() {

  }
}
