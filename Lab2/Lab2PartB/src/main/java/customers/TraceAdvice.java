package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class TraceAdvice {
//  @Before("execution(* customers.EmailSender.sendEmail(..))")
//  public void tracebeforemethod(JoinPoint joinpoint) {
//    System.out.println("before execution of method "+joinpoint.getSignature().getName());
//  }

  @After("execution(* customers.EmailSender.sendEmail(..))")
  public void traceaftermethod(JoinPoint joinpoint) {
    System.out.println(LocalDateTime.now() + " method="+joinpoint.getSignature().getName());
  }
}
