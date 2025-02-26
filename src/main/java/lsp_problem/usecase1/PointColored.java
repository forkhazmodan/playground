package lsp_problem.usecase1;

import java.util.Objects;

public class PointColored extends Point {

  String color;
  public PointColored(int x, int y, String color) {
    super(x, y);
    this.color = color;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof PointColored)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    PointColored that = (PointColored) o;
    return Objects.equals(color, that.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), color);
  }
}
