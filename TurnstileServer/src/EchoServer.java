import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class EchoServer {
    private int port;

    public EchoServer(int port){
        this.port = port;
    }
    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            Socket client = serverSocket.accept();
            ClientHandler cl = new ClientHandler(client);
            executorService.execute(cl);
        }
    }
}
