package app;


import java.util.List;

public class AskResponse {
  private String question;
  private String answer;
  private Product product;
  private List<Product> recommendations;

  public AskResponse() {}

  public AskResponse(String question, String answer, Product product, List<Product> recommendations) {
    this.question = question;
    this.answer = answer;
    this.product = product;
    this.recommendations = recommendations;
  }

  public String getQuestion() { return question; }
  public void setQuestion(String question) { this.question = question; }

  public String getAnswer() { return answer; }
  public void setAnswer(String answer) { this.answer = answer; }

  public Product getProduct() { return product; }
  public void setProduct(Product product) { this.product = product; }

  public List<Product> getRecommendations() { return recommendations; }
  public void setRecommendations(List<Product> recommendations) { this.recommendations = recommendations; }
}
