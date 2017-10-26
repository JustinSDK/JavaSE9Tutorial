package cc.openhome;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        Class clz = Class.forName("cc.openhome.reflect.Some");

        Constructor constructor = clz.getDeclaredConstructor(String.class);
        Object target = constructor.newInstance("Some object");
        clz.getDeclaredMethod("doSome").invoke(target);
        
        Field field = clz.getDeclaredField("some");
    }
}
