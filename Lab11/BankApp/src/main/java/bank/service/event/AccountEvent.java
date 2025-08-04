package bank.service.event;


public class AccountEvent {
  private String message;

  public AccountEvent(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
