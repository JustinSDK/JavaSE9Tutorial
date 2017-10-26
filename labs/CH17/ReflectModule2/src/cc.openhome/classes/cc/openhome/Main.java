package cc.openhome;

import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        Class clz = Class.forName("cc.openhome.reflect.Some");
        Constructor constructor = clz.getDeclaredConstructor(String.class);
    }
}
