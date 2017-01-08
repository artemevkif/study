package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

/**
 * Created by xxartema on 08.01.2017.
 */
public class PointTest_1 {
  @Test
  public void testPoint() {
    Point p1 = new Point(2,0);
    Point p2 = new Point(799,0);

    assert p1.dist(p2) ==  797;
  }

}
