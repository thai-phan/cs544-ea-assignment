package app.tools;

import app.domain.Profit;
import app.repository.ProfitRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfitTool {
  @Autowired
  private ProfitRepository profitRepository;

  @Tool(description = "Get the profit of the company for a specific month in mm-yyyy format")
  public Profit getProfitBySpecificMonth(String month) {
    return profitRepository.getProfitByMonth(month);
  }

  @Tool(description = "Get all profit of company")
  public List<Profit> getAllProfit() {
    return profitRepository.findAll();
  }
}
