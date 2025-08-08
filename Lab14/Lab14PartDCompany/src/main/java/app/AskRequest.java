package app;

public class AskRequest {
  private String question;
  private Long productId;

  public AskRequest() {}

  public AskRequest(String question, Long productId) {
    this.question = question;
    this.productId = productId;
  }

  public String getQuestion() { return question; }
  public void setQuestion(String question) { this.question = question; }

  public Long getProductId() { return productId; }
  public void setProductId(Long productId) { this.productId = productId; }
}
