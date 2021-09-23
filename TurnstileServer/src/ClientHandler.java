import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

public class ClientHandler implements Runnable, Constants{

    private Socket client;
    private PrintWriter pw;
    private Scanner sc;
    private Spectator spectator;
    private static Turnstile[] turnstiles;
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");

    public ClientHandler(Socket client, Spectator spectator, Turnstile[] turnstiles) throws IOException {
        this.client = client;
        this.pw = new PrintWriter(client.getOutputStream(), true);
        this.sc = new Scanner(client.getInputStream());
        this.spectator = spectator;
        this.turnstiles = turnstiles;

    }

    public void protocol() throws IOException {
        pw.println("Connected");
        String msg = "";

        while (!msg.equals("CLOSE")){
            pw.println("-------------------------MENU-------------------------");
            pw.println(" 1. Type P to populate the stadium");
            pw.println(" 2. Type ID to view the turnstile IDs");
            pw.println(" 3. Type S to view the amount of spectators");
            pw.println(" 4. Type C to end session");
            msg = sc.nextLine();

            switch (msg){
                case "P":
                    fillStadium();
                    break;
                case "ID":
                    for (Turnstile turnstile : turnstiles) {
                        pw.println("Turnstile ID: "+turnstile.getID());
                    }
                    break;
                case "S":
                    pw.println(Thread.currentThread().getName()+ ": ");
                    pw.println("Total spectators "+spectator.getValue()+ " at "+sdf1.format(spectator.timestamp.getTime()));
                    break;
                case "C":
                    pw.println("Session ended");
                    pw.println("Connection closed");
                    client.close();
                    break;
                default:
                    pw.println("invalid");
            }
        }
    }

    public void fillStadium(){
        for (int i = 0; i < numTurnstiles; i++) {
            populateTurnstiles().run();
        }
    }

    public Turnstile populateTurnstiles() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(turnstiles.length);
        Turnstile turnstile = turnstiles[randomNumber];
        System.out.println(Thread.currentThread().getName()+" Spectator: " + spectator.getValue()+ " has passed through turnstile: " +turnstile.getID() );
        return turnstile;
    }

    @Override
    public void run() {
        String msg = "";

        while (!msg.equals("C")){
            try {
                protocol();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
