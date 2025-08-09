package app.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CompanyTool {

    @Tool(description = "Get the profit of the company for a specific month")
    public String getCompanyIncomeByMonth(String month){
        RestClient restClient = RestClient.builder()
                .baseUrl("http://localhost:8080")
                .build();

        ResponseEntity<String> response = restClient.get().uri("/profit-by-month?month=" + month)
                .retrieve()
                .toEntity(String.class);

        return response.getBody();
    }


    @Tool(description = "Convert the currency from dollar to another currency")
    public String convertTheCurrencyFromDollarWithAmount(String toCurrency, Double fromAmount){
        RestClient restClient = RestClient.builder()
                .baseUrl("http://localhost:8090")
                .build();

        ResponseEntity<String> response = restClient.get().uri("/convert-currency/"+toCurrency+"/"+fromAmount)
                .retrieve()
                .toEntity(String.class);

        return response.getBody();
    }
}
