package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PersonMessageListener2 {
  @JmsListener(destination = "testTopic")
  public void receiveMessage(final String personAsString) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Person person = objectMapper.readValue(personAsString, Person.class);
      System.out.println("JMS receiver 2 received message:" + person.getFirstName() + " " + person.getLastName());
    } catch (IOException e) {
      System.out.println("JMS receiver 2: Cannot convert : " + personAsString + " to a Person object");
    }
  }
}