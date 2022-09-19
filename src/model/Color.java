package model;

import java.text.DecimalFormat;

/**
 * the color class that has RGB values.
 */
public class Color {
  private int r;
  private int g;
  private int b;

  /**
   * constructor of the color class.
   */
  public Color(int r, int g, int b) throws IllegalArgumentException {
    if(r < 0 || g < 0 || b < 0 || r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("the rgb value should be between 0 and 255");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * gets R value of the collor.
   */
  public int getR() {
    return r;
  }

  /**
   * sets r value of the color.
   */
  public void setR(int r) throws IllegalArgumentException {
    if(r < 0 || r > 255) {
      throw new IllegalArgumentException("the integer out of range");
    }
    this.r = r;
  }

  /**
   * gets G value of the color.
   */
  public int getG() {
    return g;
  }

  /**
   * sets G value of the color.
   */
  public void setG(int g) throws IllegalArgumentException {
    if(g < 0 || g > 255) {
      throw new IllegalArgumentException("the integer out of range");
    }
    this.g = g;
  }

  /**
   * gets B value of the color.
   */
  public int getB() {
    return b;
  }

  /**
   * sets B value of the color.
   */
  public void setB(int b) throws IllegalArgumentException {
    if(b < 0 || b > 255) {
      throw new IllegalArgumentException("the integer out of range");
    }
    this.b = b;
  }

  /**
   * creates the copy of the color.
   */
  public Color copy () {
    Color newColor = new Color(r, g, b);
    return newColor;
  }

  /**
   * to String method is the String representation of the color class.
   */
  @Override
  public String toString() {
    DecimalFormat format = new DecimalFormat("0.0");
    return "Color: (" + format.format(this.getR()) + "," + format.format(this.getG()) + ","
            + format.format(this.getB()) + ")";

  }
}
