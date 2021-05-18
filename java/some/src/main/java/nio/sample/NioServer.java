package nio.sample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 使用java nio特性实现一个简单的服务器程序
 * <p>
 * 功能就是 echo 客户端的数据
 */
public class NioServer {

    private static final long ACCPET_TIME_OUT = 200;

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();

        serverSocket.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        serverSocket.bind(new InetSocketAddress(8400));

        EchoSelectorHandler echoSelectorHandler = new EchoSelectorHandler();

        while (true) {
            int i = selector.select(ACCPET_TIME_OUT);
            if (i == 0) {
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isValid() && key.isAcceptable()) {
                    echoSelectorHandler.handleAccept(key);
                }
                if (key.isValid() && key.isReadable()) {
                    echoSelectorHandler.handleRead(key);
                }
                if (key.isValid() && key.isWritable()) {
                    echoSelectorHandler.handlerWrite(key);
                }

                iterator.remove();
            }

        }
    }


    static class EchoSelectorHandler {

        void handleAccept(SelectionKey key) throws IOException {
            System.out.println("accept a new connection!");

            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);

            Selector selector = key.selector();
            // 注册 可读 事件
            socketChannel.register(selector,
                    SelectionKey.OP_READ);
        }

        void handleRead(SelectionKey key) throws IOException {
            SocketChannel socketChannel = (SocketChannel) key.channel();

            ByteBuffer data = ByteBuffer.allocate(1024);
            int read = socketChannel.read(data);

            if (read == -1) {
                System.out.println("客户端关闭");
                socketChannel.close();
            } else if (read > 0) {
                key.attach(data);
                key.interestOps(SelectionKey.OP_WRITE);
            }
        }

        void handlerWrite(SelectionKey key) throws IOException {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer data = (ByteBuffer) key.attachment();
            data.flip();
            socketChannel.write(data);
            key.interestOps(SelectionKey.OP_READ);
        }
    }
}
