package cc.openhome;

import static java.lang.System.out;
import java.util.List;

public class StackTraceDemo {   
    public static void main(String[] args) {
        c();
    }

    static void c() {
        b();
    }

    static void b() {
        a();
    }

    static void a() {
        Thread currentThread = Thread.currentThread();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        
        out.printf("Stack trace of thread %s:%n", currentThread.getName());
        List.of(stackTrace).forEach(out::println);
    }
}
