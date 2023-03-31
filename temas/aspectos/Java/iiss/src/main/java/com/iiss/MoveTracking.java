package com.iiss;

import java.util.*;
import org.aspectj.lang.annotation.*;

@Aspect
public class MoveTracking {
  private Set movees = new HashSet();
  public Set getmovees() {
    Set result = movees;
    movees = new HashSet();
    return result;
  }

  @After("execution(* com.iiss.Line.*(..)) && args(fe)")
  public void after(FigureElement fe) {
    System.out.println("After");
    movees.add(fe);}

  // public void after(){
  //   System.out.println("After");
  // }


}