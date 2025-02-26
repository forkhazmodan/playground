package lsp_problem.usecase1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  void testEquals() {

    Point point = new Point(1, 2);
    PointColored point2 = new PointColored(1, 2, "RED");

    Assertions.assertEquals(point, point2);
    Assertions.assertNotEquals(point2, point);
  }
}