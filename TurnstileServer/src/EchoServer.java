import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;


public class EchoServer implements Constants{
    private int port;

    private static Turnstile[] turnstiles = new Turnstile[numTurnstiles];

    public EchoServer(int port){
        this.port = port;
    }


    public void startServer() throws IOException {
        Spectator spectator = new Spectator();
        setTurnstiles(spectator);
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            Socket client = serverSocket.accept();
            ClientHandler cl = new ClientHandler(client, spectator, turnstiles);
            executorService.execute(cl);
        }
    }

    public void setTurnstiles(Spectator spectator){
        for (int i = 0; i < numTurnstiles; i++) {
            turnstiles[i] = new Turnstile(spectator);
        }
    }


}
