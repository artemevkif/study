package ru.stqa.pft.sandbox;
import org.testng.annotations.Test; //объявление полного названия класса, для упрощения написания теста

/**
 * Created by xxartema on 08.01.2017.
 */

public class SquareTests {

  @Test //обязательно объявлять класс тест!
  public void testArea() {
    Square s = new Square(5);
    assert s.area() == 25; //Знак равно для присваивания, два знака для сравнения
}
}
