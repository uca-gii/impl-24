package com.iiss;
import java.util.*;
import org.aspectj.lang.annotation.*;

public class Line implements FigureElement{
// public class Line{
  private Point p1, p2;

  Point getP1() { return p1; }
  Point getP2() { return p2; }

  //@Pointcut("execution(* com.iiss.Line.*(..))")
  //@Pointcut("execution(* com.iiss.Line.setP1(..)) || execution(* com.iiss.Line.setP2(..)) || execution(* com.iiss.Line.setP(..))")
  void setP(){System.out.println("a ver");}
  public void setP1(Point p1) {
    this.p1 = p1;
  }

  public void setP2(Point p2) {
    this.p2 = p2;
  }
}