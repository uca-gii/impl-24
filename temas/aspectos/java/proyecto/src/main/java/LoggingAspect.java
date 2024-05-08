import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;


@Aspect
class LoggingAspect {
    @Pointcut("execution(* UserManager.getCurrentUser())")
    public void accessUser() {}

    @Pointcut("execution(* UserManager.setCurrentUser(User)) || execution(* UserManager.deleteUser())")
    public void modifyUser() {}

    @Before("accessUser()")
    public void beforeAccessUser() {
        System.out.println("Accessing user data");
    }

    @After("modifyUser()")
    public void afterModifyUser() {
        System.out.println("User data modified");
    }

    @Around("execution(* User.setName(String)) || execution(* User.setAge(int))")
    public Object aroundUserPropertyChange(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Changing user property");
        Object returnValue = pjp.proceed();
        System.out.println("User property changed");
        return returnValue;
    }
}