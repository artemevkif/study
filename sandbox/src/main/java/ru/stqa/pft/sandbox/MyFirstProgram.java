package ru.stqa.pft.sandbox;

public class MyFirstProgram {
//  public static void main(String[] args) {
//
//    hello("324");
//    hello("Aleksey");
//    hello("world");
//
//    Square s = new Square(5);
//    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
//
//    Rectangle r = new Rectangle(14,6);
//    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
//
//  }
//
//  public static void hello(String somebody) {
//    System.out.println("Hello " + somebody + "!");
//  }

  public static void main(String[] args) {
    Point p1 = new Point(1,0);
    Point p2 = new Point(800,0);

    System.out.println("Расстояние: " + p1.dist(p2));
  }
}