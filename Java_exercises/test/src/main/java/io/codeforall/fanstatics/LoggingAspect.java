package io.codeforall.fanstatics;

public class LoggingAspect {

    public void logBefore() {
        System.out.println("Log (AOP): Método está prestes a ser executado.");
    }

    public void logAfter() {
        System.out.println("Log (AOP): Método foi executado.");
    }
}
