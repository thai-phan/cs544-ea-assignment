package bank.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class StopWatchAdvice {

  @Around("execution(* bank.service.*.*(..))")
  public Object invoke(ProceedingJoinPoint call) throws Throwable {
    StopWatch clock = new StopWatch("");
    clock.start(call.toShortString());
    Object object = call.proceed();
    clock.stop();
    System.out.println(clock.prettyPrint());
    return object;
  }
}
