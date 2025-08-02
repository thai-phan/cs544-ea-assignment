package jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TaxServiceListener {
  @JmsListener(destination = "taxTopic")
  public void receiveMessage(final String taxMessage) {
    System.out.println("TaxService 1 received message: " + taxMessage);
  }
}

