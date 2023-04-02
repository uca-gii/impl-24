package com.iiss;
import java.util.*;
import org.aspectj.lang.annotation.*;

public class Line implements FigureElement{
// public class Line{
  private Point p1, p2;

  Point getP1() { return p1; }
  Point getP2() { return p2; }

  public void setP1(Point p1) {
    System.out.println("Entra en setP1");
    this.p1 = p1;
  }

  public void setP2(Point p2) {
    System.out.println("Entra en setP2");
    this.p2 = p2;
  }
}