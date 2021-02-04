package nio.sample;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NioClient {

    private static final long CONNECTION_TIME_OUT = 200;

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        socketChannel.connect(new InetSocketAddress(8400));
        EchoClientHandler echoClientHandler = new EchoClientHandler();

        while (true) {
            int select = selector.select(CONNECTION_TIME_OUT);
            if (select == 0) {
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isValid() && key.isConnectable()) {
                    echoClientHandler.handleConnect(key);
                }
                if (key.isValid() && key.isReadable()) {
                    echoClientHandler.handleRead(key);
                }
                if (key.isValid() && key.isWritable()) {
                    echoClientHandler.handleWrite(key);
                }
                iterator.remove();
            }
        }
    }

    static class EchoClientHandler {
        void handleConnect(SelectionKey key) throws IOException {
            SocketChannel channel = (SocketChannel) key.channel();
            channel.finishConnect();

            key.interestOps(SelectionKey.OP_WRITE);
        }

        void handleRead(SelectionKey key) throws IOException {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer data = ByteBuffer.allocate(1024);

            int read = channel.read(data);
            if (read  == -1) {
                // 通道关闭
                System.out.println("通道关闭");
                channel.close();
                return;
            }
            data.flip();
            System.out.println(data.remaining());
            System.out.println(data.toString());
            System.out.println(new String(data.array(), 0 , data.remaining()));
            System.out.println("==========================");
            key.interestOps(SelectionKey.OP_WRITE);
        }

        void handleWrite(SelectionKey key) throws IOException {
            SocketChannel channel = (SocketChannel) key.channel();
            channel.write(ByteBuffer.wrap("hello world!".getBytes(Charset.forName("UTF-8"))));
            key.interestOps(SelectionKey.OP_READ);
        }
    }
}
