package app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService svc;

  public ProductController(ProductService svc) {
    this.svc = svc;
  }

  @GetMapping
  public List<Product> all() {
    return svc.listAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> get(@PathVariable Long id) {
    return svc.getById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  /**
   * Ask a question about products. JSON payload:
   * { "question": "What's the price of product X?", "productId": 1 }
   * productId is optional.
   */
  @PostMapping("/ask")
  public AskResponse ask(@RequestBody AskRequest req) {
    return svc.ask(req);
  }

  @GetMapping("/memory")
  public List<Map<String,Object>> memory() {
    return svc.getConversationMemory();
  }
}
