package app.controller;

import app.domain.Profit;
import app.repository.ProfitRepository;
import app.tools.ProfitTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfitController {
  @Autowired
  private ProfitRepository profitRepository;

  @Autowired
  ChatClient chatClient;

  @Autowired
  ProfitTool profitTool;

  @PostMapping("/profits")
  public Profit addProfit(@RequestBody Profit profit) {
    return profitRepository.save(profit);
  }

  @GetMapping("/profits")
  public List<Profit> getProfits() {
    return profitRepository.findAll();
  }

  @GetMapping("/profits/{month}")
  public Profit getProfitByMonth(@PathVariable String month) {
    return profitRepository.getProfitByMonth(month);
  }

  @GetMapping("/profit-by-month")
  public String askProfit(@RequestParam(value = "month", defaultValue = "08-2025") String month) {
    return chatClient.prompt().tools(profitTool).user(
            u -> u.text("""
                Please get the profit for the month {month}.
                The format of the month must be 'mm-yyyy' (e.g., 08-2025).
                Make sure to call the tool with the month in that exact format.""").param("month", month))
        .call()
        .content();
  }
}
