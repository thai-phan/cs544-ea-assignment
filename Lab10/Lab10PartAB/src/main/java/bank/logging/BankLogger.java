package bank.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class BankLogger implements ILogger {

  Logger logger = LoggerFactory.getLogger(BankLogger.class);

  public void log(String logstring) {
    logger.info(logstring);
  }

}
