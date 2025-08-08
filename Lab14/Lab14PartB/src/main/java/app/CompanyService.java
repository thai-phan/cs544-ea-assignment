package app;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CompanyService {

  private final WebClient webClient;
  private final String profitBaseUrl;

  public CompanyService(WebClient.Builder builder,
                        @Value("${profit-service.base-url}") String profitBaseUrl) {
    this.webClient = builder.baseUrl(profitBaseUrl).build();
    this.profitBaseUrl = profitBaseUrl;
  }

  public ProfitRecord getProfitForMonth(String month) {
    return webClient.get()
        .uri("/{month}", month)
        .retrieve()
        .bodyToMono(ProfitRecord.class)
        .block();
  }
}
