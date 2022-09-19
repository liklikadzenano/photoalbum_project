package model;

/**
 * this is an IShape interface with methods that all the shapes that implement IShape.
 * should use.
 */
public interface IShape {
  /**
   * this method should return the x position of the shape.
   */
  public int getX();

  /**
   * this method should return Y position of the shape.
   */
  public int getY();

  /**
   * gets width of the shape.
   */
  public int getWidth();

  /**
   * gets height of the shape.
   */
  public int getHeight();


  /**
   * get the name of the shape;
   */
  public String getName();

  public int getR();
  public int getG();
  public int getB();

  /**
   * to relocate shapes.
   */
  public void move(int newX, int newY);

  /**
   * changes color.
   */
  public void changeColor(int r, int g, int b);

  /**
   * change height.
   */
  public void changeSize(int width, int Height);



  /**
   * creates copy of the object and returns that copy.
   */
  public IShape copy();
}
