package app;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet-health")
public class PetQaController {

  @Autowired
  private PetQaService service;

  @Autowired
  ChatClient chatClient;


  @GetMapping("/chat")
  public String chat(@RequestParam(value = "message") String message) {
    return chatClient.prompt()
        .user(message)
        .call()
        .content();
  }

  @PostMapping("/ask")
  public QaRecord askQuestion(@RequestBody String question) {
    return service.askQuestion(question);
  }

  @GetMapping("/history")
  public List<QaRecord> getHistory() {
    return service.getHistory();
  }
}
