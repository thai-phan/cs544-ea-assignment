package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {
  private final ProductRepository productRepository;
  private final List<Map<String,Object>> conversationMemory = Collections.synchronizedList(new ArrayList<>());
  private static final Logger log = LoggerFactory.getLogger(ProductService.class);

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> listAll() {
    return productRepository.findAll();
  }

  public Optional<Product> getById(Long id) {
    return productRepository.findById(id);
  }

  public AskResponse ask(AskRequest req) {
    final String question = req.getQuestion() == null ? "" : req.getQuestion().trim();
    String qLower = question.toLowerCase(Locale.ROOT);
    Product referenced = null;
    List<Product> recs = null;
    String answer;

    if (req.getProductId() != null) {
      referenced = productRepository.findById(req.getProductId()).orElse(null);
    }

    if (referenced == null && !question.isEmpty()) {
      for (Product p : productRepository.findAll()) {
        if (p.getName().toLowerCase().contains(qLower) || p.getDescription().toLowerCase().contains(qLower)) {
          referenced = p;
          break;
        }
      }
    }

    if (referenced != null) {
      if (qLower.contains("price") || qLower.contains("cost")) {
        answer = String.format("The price of '%s' is $%s.", referenced.getName(), referenced.getPrice());
      } else if (qLower.contains("stock") || qLower.contains("available") || qLower.contains("inventory")) {
        answer = String.format("We have %d units of '%s' in stock.", referenced.getStock(), referenced.getName());
      } else if (qLower.contains("describe") || qLower.contains("detail") || qLower.contains("what is")) {
        answer = referenced.getDescription();
      } else {
        answer = "I found the product. For specifics ask about price, stock, or details.";
      }
    } else if (qLower.contains("recommend") || qLower.contains("best") || qLower.contains("top")) {
      recs = productRepository.findTop5ByOrderByRatingDesc();
      answer = "Here are our top-rated products.";
    } else if (qLower.contains("cheap") || qLower.contains("cheapest") || qLower.contains("low price")) {
      recs = productRepository.findTop5ByOrderByPriceAsc();
      answer = "Here are some of the lower-priced items.";
    } else if (qLower.contains("list") && qLower.contains("products")) {
      List<Product> all = productRepository.findAll();
      answer = "Listing all products (see payload).";
      recs = all;
    } else if (qLower.contains("how many") && qLower.contains("products")) {
      long count = productRepository.count();
      answer = String.format("There are %d products in the catalog.", count);
    } else {
      List<Product> matches = productRepository.findAll().stream()
          .filter(p -> Arrays.stream(p.getName().split("\\s+"))
              .anyMatch(w -> qLower.contains(w.toLowerCase())))
          .collect(Collectors.toList());
      if (!matches.isEmpty()) {
        recs = matches;
        answer = "I found products that might match your question.";
      } else {
        recs = productRepository.findTop5ByOrderByRatingDesc();
        answer = "Sorry, I couldn't find a precise answer. Here are a few recommended products.";
      }
    }

    AskResponse resp = new AskResponse(question, answer, referenced, recs);

    Map<String,Object> record = new HashMap<>();
    record.put("question", question);
    record.put("answer", answer);
    record.put("productId", referenced == null ? null : referenced.getId());
    record.put("timestamp", new Date());
    conversationMemory.add(record);

    log.info("QA recorded: {}", record);

    return resp;
  }

  public List<Map<String,Object>> getConversationMemory() {
    return conversationMemory;
  }
}
