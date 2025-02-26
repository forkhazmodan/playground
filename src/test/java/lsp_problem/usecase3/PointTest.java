package lsp_problem.usecase3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  void testEquals() {

    Point p1 = new PointColored(1, 2, "RED");
    Point p2 = new PointColored(1, 2, "RED");


    assertEquals(p1, p2);
    assertEquals(p1, p2);


  }
}