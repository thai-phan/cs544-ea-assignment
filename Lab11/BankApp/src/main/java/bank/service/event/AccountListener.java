package bank.service.event;

import bank.dao.TraceRecordRepository;
import bank.domain.TraceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountListener {
  @Autowired
  TraceRecordRepository traceRecordRepository;

  @EventListener
  public void onEvent(AccountEvent event) {
    System.out.println("Email event: " + event.getMessage());;
  }

  @EventListener
  public void onEvent(TraceRecordEvent event) {
    TraceRecord record = new TraceRecord(
        event.getDateTime(),
        event.getAccountNumber(),
        event.getOperation(),
        event.getAmount()
    );
    traceRecordRepository.save(record);
//    System.out.println("Email event: " + message);
  }
}
