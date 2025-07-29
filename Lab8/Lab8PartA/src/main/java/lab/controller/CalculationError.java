package lab.controller;


public class CalculationError {

  private String message;

  public CalculationError() {
  }

  public CalculationError(String message) {
    this.message = message;
  }

  // Getter and Setter
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
