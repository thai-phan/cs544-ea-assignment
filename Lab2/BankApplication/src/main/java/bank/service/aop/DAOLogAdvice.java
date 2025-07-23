package bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class DAOLogAdvice {


  @After(value = "execution(* bank.dao.*.*(..))")
  public void after(JoinPoint joinpoint) {
    System.out.println(LocalDateTime.now() + " method=" + joinpoint.getSignature().getName());
  }

}
