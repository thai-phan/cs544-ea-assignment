package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CalculatorListener {
  int result = 0;

  @JmsListener(destination = "calculatorTopic")
  public void receiveMessage(final String personAsString) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      CalculatorObj calculatorObj = objectMapper.readValue(personAsString, CalculatorObj.class);
      switch (calculatorObj.operation) {
        case "+" -> result += calculatorObj.number;
        case "-" -> result -= calculatorObj.number;
        case "*" -> result *= calculatorObj.number;
      }
      System.out.println("JMS receiver: Current result is " + result + " after operation " + calculatorObj.operation + " with number " + calculatorObj.number);
    } catch (IOException e) {
      System.out.println("JMS receiver 1: Cannot convert : " + personAsString + " to a Person object");
    }
  }
}

