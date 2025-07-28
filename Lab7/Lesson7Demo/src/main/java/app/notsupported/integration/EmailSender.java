package app.notsupported.integration;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailSender {
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void sendEmail(String message){
        if (message.equals("Hello")) throw new RuntimeException("Cannot send email");
        System.out.println("------- send email: "+ message);
    }
}
