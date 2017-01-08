package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xxartema on 08.01.2017.
 */
public class PointTest_2 {
  @Test
  public void testPoint() {
    Point p1 = new Point(1,0);
    Point p2 = new Point(10,0);

    Assert.assertEquals(p1.dist(p2),9.0);
  }

}
