package utility;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import model.IShape;
import model.Oval;
import model.Rectangle;

/***
 * painter class to draw the shapes from in the Snapshots.
 * takes the list of shapes.
 */
public class SnapshotPainter extends JPanel {
  List<IShape> shapes;

  public SnapshotPainter(List<IShape> shapes) {
    this.shapes = shapes;
  }

  /**
   * repaints whatever is drawn in the paintCompinent method.
   */

  public void drawing() {
    repaint();
  }

  public void setShapes(List<IShape> shapes) {
    this.shapes = shapes;
  }

  /**
   * the method paintComponent used to draw shapes.
   * @parameter g.
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (IShape shape : shapes) {
      if (shape instanceof Oval) {
        g.setColor(new Color(shape.getR(), shape.getG(), shape.getB()));
        g.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
      } else if (shape instanceof Rectangle) {
        g.setColor(new Color(shape.getR(), shape.getG(), shape.getB()));
        g.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
      }
    }
  }
}
