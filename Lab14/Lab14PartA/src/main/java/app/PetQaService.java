package app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetQaService {

  private static final Logger logger = LoggerFactory.getLogger(PetQaService.class);

  private final List<QaRecord> history = new ArrayList<>();

  public QaRecord askQuestion(String question) {
    String answer = generateAnswer(question);

    QaRecord record = new QaRecord(question, answer);
    history.add(record);

    logger.info("Q: {} -> A: {}", question, answer);

    return record;
  }

  public List<QaRecord> getHistory() {
    return history;
  }

  private String generateAnswer(String question) {
    String q = question.toLowerCase();
    if (q.contains("fever") || q.contains("temperature")) {
      return "Take your pet's temperature. A fever is usually above 103°F for dogs or cats.";
    } else if (q.contains("vomit")) {
      return "Monitor hydration. If vomiting persists for over 24 hours, consult a vet.";
    } else if (q.contains("vaccines") || q.contains("vaccination")) {
      return "Pets typically need annual vaccinations. Ask your vet for a specific schedule.";
    } else {
      return "Please consult a veterinarian for specific health concerns.";
    }
  }
}
