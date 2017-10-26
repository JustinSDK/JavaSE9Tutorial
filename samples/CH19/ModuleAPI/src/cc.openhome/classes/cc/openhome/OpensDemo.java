package cc.openhome;

import cc.openhome.util.Some;
import java.lang.reflect.Field;

public class OpensDemo {
    public static void main(String[] args) throws Exception {
        Some s = new Some();
        if(args.length != 0 && "opens".equals(args[0])) {
            s.openTo(OpensDemo.class.getModule());
        }
        Field f = Some.class.getDeclaredField("some");
        f.setAccessible(true);
        System.out.println(f.get(s));
    }
}
