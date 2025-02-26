package lsp_problem.usecase2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  void testEquals() {
    Point point1 = new Point(1, 2);
    PointColored point2 = new PointColored(1, 2, "RED");
    Point point3 = new Point(1, 2);

    Assertions.assertNotEquals(point2, point1);
    Assertions.assertNotEquals(point1, point2);
    Assertions.assertEquals(point1, point3);
    Assertions.assertEquals(point3, point1);
  }
}