package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.SysexMessage;

import model.Canvas;
import model.IShape;
import model.Oval;
import model.Rectangle;
import model.Snapshot;

/**
 * this is the Webview class that implements IView.
 */
public class WebView implements IView {
  String outputFile;
  int xMax = 1000;
  int yMax = 1000;


  /**
   * this method writes and HTML file and displays the snapshots.

   * @parameter list of  snapshots
   * @throws IOException
   */

  public void display(List<Snapshot> snapshots) throws IOException {
    int windowHeight = this.xMax;
    int windowWidth = this.yMax;
    FileWriter file = new FileWriter(this.outputFile);
    BufferedWriter bw = new BufferedWriter(file);
    bw.write("<!DOCTYPE html>\n"
            + "<html>\n"
            + "<body>\n"
            + "<h1> Web view of the PhotoAlbum </h1>\n");
    bw.write("<div>\n");
    for (int i = 0; i < snapshots.size(); i++) {
      bw.write("<h2> " + snapshots.get(i).getDescription() + "</h2>\n");
      bw.write("<svg width =\"" + windowWidth + "\"" + " height=\"" + windowHeight + "\"> ");
      for (IShape shape : snapshots.get(i).getShapesOnCanvas()) {
        if (shape instanceof Oval) {
          bw.write("<ellipse id=\"" + shape.getName() + "\" cx=\"" + shape.getX()
                  + "\" cy=\"" + shape.getY()
                  + "\" rx=\"" + shape.getWidth() + "\" ry= \"" + shape.getHeight() + "\" fill=rgb\"(" +
                  shape.getR() + "," + shape.getG() + "," + shape.getB() + ")\" visibility=\"visible\"> "
                  + "</ellipse>\n");
        } else if (shape instanceof Rectangle) {
          bw.write("<rect id= \"" + shape.getName() + "\" x= \"" + shape.getX() + "\" y=\""
                  + shape.getY() + "\" width=\"" + shape.getWidth() + "\" height=\""
                  + shape.getHeight() + "\" fill=\"rgb(" +
                  shape.getR() + "," + shape.getG() + "," + shape.getB() + ")\" visibility=\"visible\" >" + "</rect>\n");
        }
      }
      bw.write("</svg>\n");
    }

    bw.write("</div>\n");
    bw.write("</body>\n");
    bw.write("</html>\n");
    bw.close();
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
  @Override
  public void setyMax(int yMax) {
    this.yMax = yMax;
  }
}

