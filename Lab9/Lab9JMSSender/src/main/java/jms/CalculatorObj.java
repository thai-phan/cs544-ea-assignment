package jms;

public class CalculatorObj {
  public int number;
  public String operation;

  public CalculatorObj() {
  }

  public CalculatorObj(String operation, int number) {
    this.number = number;
    this.operation = operation;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public int getNumber() {
    return number;
  }

  public String getOperation() {
    return operation;
  }
}
