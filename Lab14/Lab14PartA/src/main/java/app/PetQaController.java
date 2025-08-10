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
        .system("You are a knowledgeable and compassionate pet healthcare expert. " +
            "You provide accurate, safe, and helpful advice about the health, wellness, nutrition, behavior, and care of pets, including dogs, cats, and other common household animals." +
            " You do not diagnose conditions, prescribe treatments, or replace veterinary advice, but you offer general guidance, best practices, and support to pet owners. " +
            "Always recommend consulting a licensed veterinarian for any serious or urgent issues.\n")
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
