package search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Value("classpath:/IphoneUserGuide.pdf")
  private Resource documentResource;
  @Autowired
  VectorStore vectorStore;
  @Autowired
  VectorStoreRepository vectorStoreRepository;

  @Override
  public void run(String... args) throws Exception {
    vectorStoreRepository.cleanUpStore();

    TikaDocumentReader documentReader = new TikaDocumentReader(documentResource);
    TextSplitter textSplitter = new TokenTextSplitter();
    vectorStore.add(textSplitter.apply(documentReader.get()));
  }
}
