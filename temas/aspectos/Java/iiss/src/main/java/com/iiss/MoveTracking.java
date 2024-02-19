package com.iiss;

import java.util.*;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;

@Aspect
public class MoveTracking {
  private Set movees = new HashSet();
  public Set getmovees() {
    Set result = movees;
    movees = new HashSet();
    return result;
  }

  @After("execution(* com.iiss.Line.set*(..)) || execution(* com.iiss.Point.set*(..))")
  public void after(JoinPoint jp) {
    System.out.println("-Entra en after");
    Object[] args = jp.getArgs();
    for (Object arg : args) {
      if (arg instanceof FigureElement) {
        movees.add((FigureElement) arg);
      }
    }
  }


}