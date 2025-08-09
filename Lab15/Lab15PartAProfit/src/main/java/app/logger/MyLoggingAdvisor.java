package app.logger;

import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;

public class MyLoggingAdvisor implements CallAdvisor {

  @Override
  public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
    System.out.println("------Request: " + chatClientRequest);
    ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);
    System.out.println("------Response: " + chatClientResponse);
    return chatClientResponse;
  }

  @Override
  public String getName() {
    return "MyLoggingAdvisor";
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
