package app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

  private final CompanyService service;

  public CompanyController(CompanyService service) {
    this.service = service;
  }

  @PostMapping("/ask")
  public ResponseEntity<?> ask(@RequestBody String question) {
    String qLower = question.toLowerCase();

    // Simple intent detection: look for month names
    String[] months = new String[]{
        "january", "february", "march", "april", "may", "june",
        "july", "august", "september", "october", "november", "december"
    };
    for (String month : months)
      if (qLower.contains(month.toLowerCase())) {
        ProfitRecord profit = service.getProfitForMonth(month);
        if (profit != null) {
          String answer = String.format(
              "The profit for %s is $%s.",
              profit.getMonth(), profit.getAmount()
          );
          return ResponseEntity.ok(new Answer(question, answer, profit));
        } else {
          return ResponseEntity.ok(
              new Answer(question, "No profit data found for " + month, null)
          );
        }
      }

    return ResponseEntity.badRequest()
        .body("Could not understand the month in your question.");
  }

  // DTO for the answer
  public record Answer(String question, String answer, ProfitRecord profit) {}
}
