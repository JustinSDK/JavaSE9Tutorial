package cc.openhome;

import java.io.*;

public class IO {
    public static void dump(InputStream src, OutputStream dest)
                               throws IOException {
        try (src; dest) {
            byte[] data = new byte[1024];
            int length;
            while ((length = src.read(data)) != -1) {
                dest.write(data, 0, length);
            }
        }
    }
}