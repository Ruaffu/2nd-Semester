import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Turnstile implements Runnable{
    private Spectator specCount;
    private int ID;
    private BlockingQueue<Spectator> spectators = new ArrayBlockingQueue<>(1);

    public Turnstile(Spectator count){
        this.specCount = count;
        this.ID = ID++;
        spectators.add(new Spectator());
    }


    @Override
    public void run() {
        while (true){
            
        }
    }
}
