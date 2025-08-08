package app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.Locale;

@RestController
@RequestMapping("/api/profits")
public class ProfitController {

  private final ProfitRepository repo;

  public ProfitController(ProfitRepository repo) {
    this.repo = repo;
  }

  @GetMapping("/{month}")
  public ResponseEntity<?> getProfitByMonth(@PathVariable String month) {
    try {
      Month parsedMonth = Month.valueOf(month.toUpperCase(Locale.ROOT));
      return repo.findByMonth(parsedMonth)
          .map(ResponseEntity::ok)
          .orElse(ResponseEntity.notFound().build());
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body("Invalid month: " + month);
    }
  }
}
