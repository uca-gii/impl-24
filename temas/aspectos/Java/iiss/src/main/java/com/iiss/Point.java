package com.iiss;


public class Point implements FigureElement{
  private int x = 0, y = 0;

  int getX() { return x; }
  int getY() { return y; }

  public void setX(int x) {
    System.out.println("Entra en setY");
    this.x = x;
  }
  public void setY(int y) {
    System.out.println("Entra en setY");
    this.y = y;
  }
}