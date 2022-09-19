package model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

/**
 * this is the snapshot class that is used for taking snapshots of the canvas.
 */
public class Snapshot {
  private Timestamp snapShotID;
  private Timestamp timeStamp; //is this a correct way of initializing it?
  private String description;
  private List<IShape> shapesOnCanvas;

  /**
   * snapshot constructor that has the below parameters.
   * snapShotID - gives the unique ID to the snapshot.
   * timeStamp - gives the time stamp when the snapshot is taken.
   * description - gives the description of the snapshot.
   * shapesOnCanvas - the list of shapes on canvas at the moment when snapshot was taken.
   */
  public Snapshot(Timestamp snapShotID, Timestamp timeStamp, String description,
                  List<IShape> shapesOnCanvas) {
    this.snapShotID = snapShotID;
    this.timeStamp = timeStamp;
    this.description = description;
    this.shapesOnCanvas = shapesOnCanvas;
  }

  /**
   * gets the snapshot ID.
   */
  public Timestamp getSnapShotID() {
    return snapShotID;
  }

  /**
   * gets the timeStapm of yhe Snapshot.
   */
  public Timestamp getTimeStamp() {
    return timeStamp;
  }

  /**
   * gets the description of the snapShot.
   */
  public String getDescription() {
    return description;
  }

  /**
   * gets the list of shapes on the canvas.
   */
  public List<IShape> getShapesOnCanvas() {
    return Collections.unmodifiableList(shapesOnCanvas);
  }

  /**
   * String represenatation of the SnapShot.
   */
  @Override
  public String toString() {
    String shapeString = "";
    for (int i = 0; i < shapesOnCanvas.size(); i++) {
      shapeString += shapesOnCanvas.get(i).toString();
      if (i != shapesOnCanvas.size() - 1) {
        shapeString += "\n";
      }
    }
    return "Snapshot ID: " + snapShotID + "\n" + "Timestamp: " + timeStamp + "\n"
            + "Description: " + description + "\n" + "Shape Information:\n" + shapeString;


  }
}
