package bank.service.aop;

import bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class JMSLogAdvice {
  @Autowired
  private ILogger logger;

  @After(value = "execution(* bank.logging.*.*(..)) && args(message)")
  public void after(JoinPoint joinpoint, String message) {
    logger.log(LocalDateTime.now() + " method=" + joinpoint.getSignature().getName() + " message="+message);
  }
}
