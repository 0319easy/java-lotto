package lotto;

import java.util.Objects;

public class Quantity {

  private int quantity;

  public Quantity(int quantity) {
    if (quantity < 0) {
      throw new IllegalArgumentException("수량은 0보다 커야 합니다.");
    }
    this.quantity = quantity;
  }

  public Quantity minus(Quantity quantity) {
    int result = this.quantity - quantity.getValue();
    if (result < 0) {
      throw new IllegalArgumentException("총량 보다 클 수 없습니다.");
    }
    return new Quantity(result);
  }

  public int getValue() {
    return quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Quantity quantity1 = (Quantity) o;
    return quantity == quantity1.quantity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(quantity);
  }

}
