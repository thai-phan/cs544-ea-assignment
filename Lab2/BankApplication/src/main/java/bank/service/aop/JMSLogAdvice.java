package bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class JMSLogAdvice {


  @After(value = "execution(* bank.logging.*.*(..)) && args(message)")
  public void after(JoinPoint joinpoint, String message) {
    System.out.println(LocalDateTime.now() + " method=" + joinpoint.getSignature().getName() + " message="+message);
  }
}
