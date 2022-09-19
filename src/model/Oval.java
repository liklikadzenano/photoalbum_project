package model;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * this is a concrete class Oval.
 * in extends AbstractShape and implements IShape.
 */
public class Oval extends AbstractShape implements IShape {
  private int yRadius;
  private int xRadius;
  /**
   * this is a constructor of Abstract Shape.
   */
  public Oval(String name, int x, int y, int xRadius, int yRadius, int r, int g, int b)
          throws IllegalArgumentException {
    super(name, x, y, r, g, b );
    if(xRadius <= 0 || yRadius <= 0) {
      throw new IllegalArgumentException("neither radius can be less than 0");
    }

    this.xRadius = xRadius;
    this.yRadius = yRadius;
  }


  /**
   * GETS X Radius.
   */
  public int getWidth() {
    return xRadius;
  }

  /**
   * gets Y radius.
   */
  public int getHeight() {
    return yRadius;
  }

  /**
   * changes size of the rectangle.
   */
  @Override
  public void changeSize(int newWidth, int newHeight) throws IllegalArgumentException {
    if(newHeight <= 0 || newWidth <= 0) {
      throw new IllegalArgumentException("radius cannot be 0 or negative");
    }
    this.xRadius = newWidth;
    this.yRadius = newHeight;

  }


  /**
   * copies the oval.
   */
  @Override
  public Oval copy() {
    Oval newOval = new Oval(this.getName(), this.getX(), this.getY(), xRadius, yRadius,this.getR(),
            this.getG(), this.getB());
    return newOval;
  }




  /**
   * overriding a toString method to return the string representation of Oval.
   */
  @Override
  public String toString() {
    DecimalFormat format = new DecimalFormat("0.0");
    return "Name: " + this.getName() + "\n"
            +"Type: oval\n" + "Center: (" + format.format(this.getX()) + ","
            + format.format(this.getY()) + "), X radius: " + format.format(this.getWidth())
            + ", Y radius: " + format.format(this.getHeight()) + ", "
            + "Color: (" + format.format(this.getR()) + "," + format.format(this.getG()) + ","
            + format.format(this.getB()) + ")" ;

  }


}
