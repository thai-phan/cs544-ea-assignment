package search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SemanticSearchController {
    @Autowired
    private SemanticSearchService semanticSearchService;

    @PostMapping("/SemanticSearch")
    public ResponseEntity<String> search(@RequestBody String text) {
        String response = semanticSearchService.findClosestMatch(text);
        return ResponseEntity.ok(response);
    }
}
