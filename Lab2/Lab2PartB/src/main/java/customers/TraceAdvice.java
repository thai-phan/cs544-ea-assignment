package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class TraceAdvice {
  @Value("${mail.server}")
  String mailServer;
//  @Before("execution(* customers.EmailSender.sendEmail(..))")
//  public void tracebeforemethod(JoinPoint joinpoint) {
//    System.out.println("before execution of method "+joinpoint.getSignature().getName());
//  }

  @After(value = "execution(* customers.EmailSender.sendEmail(..)) && args(email, message)", argNames = "joinpoint,email,message")
  public void traceaftermethod(JoinPoint joinpoint, String email, String message) {
    System.out.println(LocalDateTime.now() + " method=" + joinpoint.getSignature().getName() +
        " message=" + message + " outgoing mail server= " + mailServer);
  }

  @Around("execution(* customers.CustomerDAO.save(..))")
  public Object invoke(ProceedingJoinPoint call) throws Throwable {
    StopWatch clock = new StopWatch("");
    clock.start(call.toShortString());
    Object object = call.proceed();
    clock.stop();
    System.out.println(clock.prettyPrint());
    return object;
  }
}
