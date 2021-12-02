package spacetime.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.Properties;

/**
 * @author zhangsx
 */
public class Server {
    private EventLoopGroup main;
    private EventLoopGroup worker;
    private ServerBootstrap boot;
    private ChannelFuture cFuture;
    public static void main(String[] args) {

    }

    private Properties config(){
        return new Properties();
    }

    private void startup(){
        Server server=new Server();
        server.main = new NioEventLoopGroup();
        server.worker = new NioEventLoopGroup(60);
        int port = 8867;
        try {
            ServerBootstrap boot = new ServerBootstrap();
            boot.group(server.main, server.worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ch.pipeline();
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            // Bind and start to accept incoming connections.
            server.cFuture = boot.bind(port).sync();

        } catch (InterruptedException e) {
            server.cFuture.channel().closeFuture();
            server.main.shutdownGracefully();
            server.worker.shutdownGracefully();
            System.exit(1);
        }
    }
}
