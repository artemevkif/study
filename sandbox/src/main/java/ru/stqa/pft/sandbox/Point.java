package ru.stqa.pft.sandbox;

/**
 * Created by xxartema on 07.01.2017.
 */
public class Point {
  public double a;
  public double b;

  public static double distance (Point p1, Point p2) {
    return Math.sqrt(Math.pow((p2.a - p1.a),2) + Math.pow((p2.b - p1.b),2));
  }

  public static void main(String[] args) {
    Point p1 = new Point();
    p1.a = 1;
    p1.b = 1;

    Point p2 = new Point();
    p2.a = 8;
    p2.b = 8;

    System.out.println("Расстояние: " + distance(p1, p2));
  }
}
