package nio.sample;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

public class NioBuffers {

    public static void main(String[] args) throws CharacterCodingException {

        // 创建bytebuffer
        ByteBuffer byteData = ByteBuffer.allocate(1024);
        System.out.println(byteData);  // java.nio.HeapByteBuffer[pos=0 lim=1024 cap=1024]

        byteData.put("hello world!".getBytes());
        System.out.println(byteData);  // java.nio.HeapByteBuffer[pos=12 lim=1024 cap=1024]

        byteData.flip();// 准备读取数据
        System.out.println(byteData);  //java.nio.HeapByteBuffer[pos=0 lim=12 cap=1024]
        byte b = byteData.get();// 读了一个字符
        System.out.println((char) b);
        System.out.println(byteData);  // java.nio.HeapByteBuffer[pos=1 lim=12 cap=1024]

        // 这个时候 还想再从头读取
        byteData.rewind(); // 将pos置为0； limit不变
        b = byteData.get(); // 读了一个字符
        System.out.println((char) b);

        // 压缩字符 pos 到 limit 之间的数据进行压缩
        byteData.compact();
        System.out.println(byteData);   // java.nio.HeapByteBuffer[pos=11 lim=1024 cap=1024]

        // 复制buffer，但是共用底层array; 但是pos，limit 是独立的
        ByteBuffer byteDataCopy = byteData.duplicate(); // 复制之后 pos,limit 会和原buffer一样
        byteDataCopy.put(0, (byte) 'a');
        byteData.flip();
        b = byteData.get();
        System.out.println((char) b); // is a


        byteData.compact();
        byteData.flip();
        System.out.println(byteData);    //  java.nio.HeapByteBuffer[pos=0 lim=10 cap=1024]
        // 就是截取pos到limit这段; 但是底层的数据还是共享的
        ByteBuffer slice = byteData.slice();
        System.out.println(slice);       //  java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]
        // 而且 array() 方法还是会返回整个底层数据
        byte[] array = slice.array();
        System.out.println(Arrays.toString(array));


        // 对于byte数据在字符之间的转换
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharBuffer charBuffer = charsetDecoder.decode(byteData);
        System.out.println(charBuffer.toString());

        CharsetEncoder charsetEncoder = charset.newEncoder();
        // ....

    }

}
