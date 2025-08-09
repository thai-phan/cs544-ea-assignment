package app.controller;

import app.tools.CompanyTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {
    @Autowired
    ChatClient chatClient;

    @Autowired
    CompanyTool  companyTool;

    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message){
        return chatClient.prompt().tools(companyTool).user(message)
                .call().content();
    }
}
