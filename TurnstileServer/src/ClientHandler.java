import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    Socket client;
    PrintWriter pw;
    Scanner sc;
    Spectator spectator;

    public ClientHandler(Socket client) throws IOException {
        this.client = client;
        this.pw = new PrintWriter(client.getOutputStream(), true);
        this.sc = new Scanner(client.getInputStream());
    }

    public void protocol() throws IOException {
        pw.println("Connected");
        String msg = "";
        while (!msg.equals("ENDSESH")){
            pw.println("Type SHOWCOUNT to see number of spectators");
            pw.println("Type CLOSE to end session");
            msg = sc.nextLine();

            switch (msg){
                case "SHOWCOUNT":
                    pw.println(spectator.getSpecCount());
                    break;
                case "CLOSE":
                    pw.println("Session ended");
                    client.close();
                    break;
                default:
                    pw.println("invalid");
            }
        }
    }

    @Override
    public void run() {
        String msg = "";

        while (!msg.equals("CLOSE")){
            try {
                protocol();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
