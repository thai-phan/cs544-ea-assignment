package kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

  @KafkaListener(topics = {"topicA"}, groupId = "group5")
  public void receive(@Payload String message) {
    System.out.println("Receiver received message= " + message + " from topicA");
  }

}