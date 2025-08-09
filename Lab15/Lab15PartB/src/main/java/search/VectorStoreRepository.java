package search;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VectorStoreRepository {
    @Autowired
    VectorStore vectorStore;

    public void add(List<String> products) {
        List<Document> documents = products.stream()
                .map(product -> new Document(product))
                .toList();
        vectorStore.add(documents);
    }
    public List<String> findClosestMatches(String query,int numberOfMatches) {

        SearchRequest request = SearchRequest.builder()
                .query(query)
                .topK(numberOfMatches)
                .build();
        List<Document> results = vectorStore.similaritySearch(request);
        return results.stream()
                .map((Document doc) -> doc.getText())
                .toList();
    }

    public String findClosestMatch(String query) {
        return findClosestMatches(query, 1).get(0);
    }
}
