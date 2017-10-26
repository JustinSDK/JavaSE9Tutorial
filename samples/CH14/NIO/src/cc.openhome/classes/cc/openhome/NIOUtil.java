package cc.openhome;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.*;

public class NIOUtil {
    public static void dump(ReadableByteChannel src, 
                           WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try(src; dest) {
            while(src.read(buffer) != -1) {      
                buffer.flip();
                dest.write(buffer);
                buffer.clear();
            }
        }
    }
    
    // 測試用的 main
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://openhome.cc");
        ReadableByteChannel src = Channels.newChannel(url.openStream());
        WritableByteChannel dest = 
                new FileOutputStream("index.html").getChannel();
        NIOUtil.dump(src, dest);
    }
}
