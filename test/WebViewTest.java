import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.IShape;
import model.Oval;
import model.Rectangle;
import model.Snapshot;
import view.WebView;

import static org.junit.Assert.*;

/**
 * This class tests the HTML view.
 */
public class WebViewTest {
  List<Snapshot> example = new ArrayList<>();
  List<IShape>shape = new ArrayList<>();
  List<IShape>shapeList2 = new ArrayList<>();
  IShape shape1;
  IShape shape2;
  IShape shape3;

  IShape shape01;
  IShape shape02;
  IShape shape03;

  Snapshot snapshot1;
  Snapshot snapshot2;

  /**
   * setting up a few snapshots for testing the html view.
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    shape1 = new Rectangle("R", 10, 10, 200, 200, 255, 20, 60);
    shape2 = new Oval("o", 60, 60, 25, 70, 0, 80, 0);
    shape3 = new Rectangle("x", 0, 1, 23, 26, 50 , 70, 90);
    shape01 = new Oval("oval", 30, 50, 300, 200, 25, 200, 60);
    shape02 = new Oval("more", 20, 60, 80, 100, 0, 200, 225);
    shape03 = new Rectangle("rect", 10, 100, 80, 90, 50 , 70, 90);
    shape.add(shape1);
    shape.add(shape2);
    shape.add(shape3);

    shapeList2.add(shape01);
    shapeList2.add(shape02);
    shapeList2.add(shape03);

    Timestamp snapshotID = Timestamp.valueOf("2022-09-01 09:01:15");
    Timestamp timestamp = Timestamp.valueOf("2022-09-01 09:01:15");

    Timestamp snapshotID2 = Timestamp.valueOf("2028-09-01 09:01:25");
    Timestamp timestamp2 = Timestamp.valueOf("2022-09-01 09:01:15");

    snapshot1 = new Snapshot(snapshotID,timestamp,"first snapshot of the canvas",shape);
    snapshot2 = new Snapshot(snapshotID2,timestamp2,"second",shapeList2);

    example.add(snapshot1);
    example.add(snapshot2);

  }

  /**
   * testing the html view, by comparing the expected string to the actual html file output.
   */
  @Test
  public void display() throws IOException {

    String testString = "<!DOCTYPE html>\n" + "<html>\n" + "<body>\n"
            + "<h1> Web view of the PhotoAlbum </h1>\n" + "<div>\n"
            + "<h2> first snapshot of the canvas</h2>\n" + "<svg width =\"1000\" height=\"1000\">"
            + " <rect id= \"R\" x= \"10\" y=\"10\" width=\"200\" height=\"200\" "
            + "fill=\"rgb(255,20,60)\" visibility=\"visible\" ></rect>\n"
            + "<ellipse id=\"o\" cx=\"60\" cy=\"60\" rx=\"25\" ry= \"70\" fill=rgb\"(0,80,0)\" "
            + "visibility=\"visible\"> </ellipse>\n"
            + "<rect id= \"x\" x= \"0\" y=\"1\" width=\"23\" height=\"26\" fill=\"rgb(50,70,90)\" "
            + "visibility=\"visible\" ></rect>\n" + "</svg>\n" + "<h2> second</h2>\n"
            + "<svg width =\"1000\" height=\"1000\"> <ellipse id=\"oval\" cx=\"30\" cy=\"50\""
            + " rx=\"300\" ry= \"200\" fill=rgb\"(25,200,60)\" visibility=\"visible\"> </ellipse>\n"
            + "<ellipse id=\"more\" cx=\"20\" cy=\"60\" rx=\"80\" "
            + "ry= \"100\" fill=rgb\"(0,200,225)\" visibility=\"visible\"> </ellipse>\n"
            + "<rect id= \"rect\" x= \"10\" y=\"100\" width=\"80\" height=\"90\" "
            + "fill=\"rgb(50,70,90)\" visibility=\"visible\" ></rect>\n"
            + "</svg>\n" +  "</div>\n" +  "</body>\n" + "</html>\n";

    String html = "";
    WebView web = new WebView();
    web.setOutputFile("/Users/nanoliklikadze/Desktop/MVC5004/myWeb.html");
    web.display(example);

    File file = new File("/Users/nanoliklikadze/Desktop/MVC5004/myWeb.html");
    Scanner scan = new Scanner(file);
    while(scan.hasNextLine()) {
      html += scan.nextLine() + "\n";
    }
    assertEquals(testString,html);

  }
}