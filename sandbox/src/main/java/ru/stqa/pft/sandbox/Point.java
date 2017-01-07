package ru.stqa.pft.sandbox;

/**
 * Created by xxartema on 07.01.2017.
 */
public class Point {
  public double a;
  public double b;

  public Point(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public double dist (Point p) {
    return Math.sqrt(Math.pow((p.a - a),2) + Math.pow((p.b - b),2));
  }

}
