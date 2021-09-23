import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
class Writer extends Thread{
    PrintWriter pwFromServer;
    boolean keepRunning = true;
    Scanner scan = new Scanner(System.in);
    String msg = "";

    public Writer(PrintWriter pw){
        pwFromServer = pw;

    }

    public void run(){
        while (keepRunning){
            msg = scan.nextLine();
            pwFromServer.println(msg);

        }
    }
}

class Reader extends Thread{
    boolean keepRunning = true;
    Scanner scFromServer;

    public Reader(Scanner sc){
        scFromServer = sc;

    }
    public void run(){
        while (keepRunning){
            System.out.println("READER "+scFromServer.nextLine());

        }
    }
}

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.startClient();
	// write your code here
    }

    public void startClient(){
        Scanner keyboard = new Scanner(System.in);
        String msg = "";
        String fromServer = "";
        try {
            Socket socket = new Socket("localHost", 8285);
            Scanner sc = new Scanner(socket.getInputStream());
            Reader reader = new Reader(sc);
            reader.start();
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            Writer writer = new Writer(pw);
            writer.start();
            while (!msg.equals("CLOSE#")){
                msg = keyboard.nextLine();
                pw.println(msg);

//                fromServer = sc.nextLine();
//                System.out.println(fromServer);
            }
            pw.println("CLOSE#");
            socket.close();

        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
}
