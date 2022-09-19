import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import model.ICanvasModel;
import model.IShape;
import model.Oval;
import model.Rectangle;
import model.Snapshot;
import view.IView;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
  ICanvasModel mokModel;
  MokView mokView;

  List<IShape> shapes1;
  List<IShape> shapes2;




  IShape oval;
  IShape rect;

  IShape oval1;
  IShape rect2;

  /**
   * sets up the tyest cases for the controller test.
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    mokModel = new MokModel();
    mokView = new MokView();





    oval = new Oval("0", 12, 19, 10, 20, 20, 30, 100);
    rect = new Rectangle("R", 30, 60, 10, 30 ,100, 200, 200);

    oval1 = new Oval("x", 20, 100, 30, 50, 20, 10,122);
    rect2 = new Rectangle("p", 40, 50, 100, 330, 20, 20, 20);
  }

  @Test
  public void go() throws IOException {
    List<IShape> shapes1 = new ArrayList<>();
    List<IShape> shapes2 = new ArrayList<>();
    List<Snapshot>snapshotList = new ArrayList<>();
    List<List> expected = new ArrayList<>();
    shapes1.add(oval);
    shapes1.add(rect);

    shapes2.add(oval1);
    shapes2.add(rect2);

    Timestamp snapshotID = Timestamp.valueOf("2022-09-01 09:01:15");
    Timestamp timestamp = Timestamp.valueOf("2022-09-01 09:01:15");

    Timestamp snapshotID2 = Timestamp.valueOf("2022-08-01 09:01:15");
    Timestamp timestamp2 = Timestamp.valueOf("2022-08-01 09:01:15");

    Snapshot snap1 = new Snapshot(snapshotID,timestamp,"this", shapes1);
    Snapshot snap2 = new Snapshot(snapshotID2, timestamp2,"that",shapes2);
    snapshotList.add(snap1);
    snapshotList.add(snap2);

    expected.add(shapes1);
    expected.add(shapes2);
    System.out.println("this is an example" + expected)
;
    File fileIn = new File("/Users/nanoliklikadze/Desktop/MVC5004/example.txt");
    Controller controller1 = new Controller(mokModel,mokView);
    try {
      controller1.go(fileIn);
    } catch (IOException e) {
      System.out.println("no input file was found");
    }
    assertEquals(expected, mokView.getShapes());

  }
}