package model;

import java.util.Objects;

/**
 * this is an abstract class that implements IShape and number of its methods.
 */
public abstract class AbstractShape implements IShape {
  private String name;
  private int x;
  private int y;
  private int r;
  private int g;
  private int b;



  /**
   * this is a constructor of Abstract Shape.
   */
  public AbstractShape(String name, int x, int y, int r, int g, int b) throws IllegalArgumentException {
    if(name == null || name == "") {
      throw new IllegalArgumentException("the shape must have a name");
    }
    this.name = name;
    this.x = x;
    this.y = y;
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * gets x.
   */
  @Override
  public int getX() {
    return x;
  }

  /**
   * gets y.
   */
  @Override
  public int getY() {
    return y;
  }



  /**
   * gets the name of the shape.
   */
  @Override
  public String getName() {
    return  name;
  }

  /**
   * to relocate shapes.
   */
  @Override
  public void move(int newX, int newY) {
    this.x = newX;
    this.y = newY;
  }

  /**
   * changes color.
   */
  @Override
  public void changeColor(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * gets r
   */
  public int getR() {
    return r;
  }

  /**
   * gets G.
   */
  public int getG() {
    return g;
  }

  /**
   * gets b
   */
  public int getB() {
    return b;
  }
}
