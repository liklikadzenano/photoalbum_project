package model;

import java.text.DecimalFormat;

public class Rectangle extends AbstractShape implements IShape {
  private int width;
  private int height;


  /**
   * this is a constructor of Abstract Shape.
   */
  public Rectangle(String name, int x, int y, int width, int height, int r, int g, int b)
          throws IllegalArgumentException {
    super(name, x, y, r, g, b);
    if(width <= 0 || height <= 0) {
      throw new IllegalArgumentException("width and height cannot 0 or negative value");
    }
    this.width = width;
    this.height = height;
  }

  /**
   * getter for the height.
   */
  @Override
  public int getHeight() {
    return height;
  }

  /**
   * gets width.
   */
  @Override
  public int getWidth() {
    return width;
  }

  /**
   * changes size of the rectangle.
   */
  @Override
  public void changeSize(int newWidth, int newHeight) throws IllegalArgumentException {
    if(newHeight <= 0 || newWidth <= 0) {
      throw new IllegalArgumentException("height and weight cannot be less than 0");
    }
    this.width = newWidth;
    this.height = newHeight;

  }

  /**
   * copies the Rectangle.
   */
  @Override
  public Rectangle copy() {
    Rectangle newRectangle = new Rectangle(this.getName(), this.getX(), this.getY(), width, height,this.getR(),
            this.getG(), this.getB());
    return newRectangle;
  }


  /**
   * String representation of the rectangle.
   */
  @Override
  public String toString() {
    DecimalFormat format = new DecimalFormat("0.0");
    return "Name: " + this.getName() + "\n"
            + "Type: rectangle\n" + "Min corner: (" + format.format(this.getX()) + ","
            + format.format(this.getY()) + "), Width: " + format.format(this.getWidth())
            + ", Height: " + format.format(this.getHeight()) + ", "
            + "Color: (" + format.format(this.getR()) + "," + format.format(this.getG()) + ","
            + format.format(this.getB()) + ")";
  }


}
