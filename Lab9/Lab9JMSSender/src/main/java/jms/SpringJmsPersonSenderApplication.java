package jms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
@EnableJms
public class SpringJmsPersonSenderApplication implements CommandLineRunner {
  @Autowired
  JmsTemplate jmsTemplate;


  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(SpringJmsPersonSenderApplication.class, args);
    context.close();
  }

  @Override
  public void run(String... args) throws Exception {
//    Person person = new Person("Frank", "Brown");
//    sendPerson(person);

    CalculatorObj calculatorObj1 = new CalculatorObj("+", 5);
    sendCalculatorObj(calculatorObj1);

    CalculatorObj calculatorObj2 = new CalculatorObj("+", 3);
    sendCalculatorObj(calculatorObj2);
  }

  public void sendPerson(Person person) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    String personAsString = objectMapper.writeValueAsString(person);
    System.out.println("Sending a JMS message:" + personAsString);
    jmsTemplate.convertAndSend("testTopic", personAsString);
  }

  public void sendCalculatorObj(CalculatorObj calculatorObj) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    String calculatorObjAsString = objectMapper.writeValueAsString(calculatorObj);
    System.out.println("Sending a JMS message:" + calculatorObjAsString);
    jmsTemplate.convertAndSend("calculatorTopic", calculatorObjAsString);
  }

}
