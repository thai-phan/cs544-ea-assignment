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
public class DAOLogAdvice {
  @Autowired
  private ILogger logger;

  @After(value = "execution(* bank.dao.*.*(..))")
  public void after(JoinPoint joinpoint) {
    logger.log(LocalDateTime.now() + " method=" + joinpoint.getSignature().getName());
  }

}
