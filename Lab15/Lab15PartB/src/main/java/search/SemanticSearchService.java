package search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SemanticSearchService {
    VectorStoreRepository vectorStoreRepository;

    @Autowired
    public SemanticSearchService(VectorStoreRepository vectorStoreRepository) {
        this.vectorStoreRepository = vectorStoreRepository;
        fillVectorStore();
    }

    private void fillVectorStore() {
        //  Sample product catalog:
        List<String> products = List.of(
                "Wireless Mouse: A comfortable wireless mouse with ergonomic design and long battery life, perfect for seamless connectivity without cables.",
                "Wireless Headphones: Lightweight, noise-canceling technology, immersive sound and long battery life, ideal for people on-the-go.",
                "Bluetooth Speaker: Portable Bluetooth speaker with excellent sound quality and long battery life, suitable for outdoor use and parties.",
                "4K Monitor: A 27-inch 4K UHD monitor with vibrant colors and high dynamic range for stunning visuals, providing an exceptional viewing experience."
        );
        vectorStoreRepository.add(products);
    }

    public String findClosestMatch(String query) {
        return vectorStoreRepository.findClosestMatch(query);
    }
}
