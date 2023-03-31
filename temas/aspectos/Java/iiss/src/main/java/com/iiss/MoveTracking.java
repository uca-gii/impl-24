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

  // @After("execution(* com.iiss.Line.*(..)) && args(fe)")
  // public void after(FigureElement fe) {
  //   System.out.println("After");
  //   movees.add(fe);}

  @After("execution(* com.iiss.Line.*(..)) || execution(* com.iiss.Point.*(..))")
  public void after(JoinPoint jp) {
    System.out.println("After");
    Object[] args = jp.getArgs();
    for (Object arg : args) {
      if (arg instanceof FigureElement) {
        movees.add((FigureElement) arg);
      }
    }
  }

  // public void after(){
  //   System.out.println("After");
  // }


}