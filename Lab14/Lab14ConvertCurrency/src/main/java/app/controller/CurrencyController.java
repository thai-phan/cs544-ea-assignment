package app.controller;

import app.domain.Currency;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyController {
    @Autowired
    ChatClient chatClient;

    @GetMapping("/convert-currency/{toCurrency}/{fromAmount}")
    public Currency convertCurrencyFromDollar(@PathVariable String toCurrency, @PathVariable String fromAmount){
        return chatClient.prompt().user("just estimate the exchange rate then convert currency from dollar to " + toCurrency + " with the amount " + fromAmount)
                .call().entity(Currency.class);
    }
}
