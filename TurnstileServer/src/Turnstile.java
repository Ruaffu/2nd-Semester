import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Turnstile implements Runnable{
    private Spectator specCount;
    private BlockingQueue<Spectator> spectators = new ArrayBlockingQueue<>(1);

    public Turnstile(Spectator count){
        this.specCount = count;
        spectators.add(new Spectator());
    }


    @Override
    public void run() {
        while (true){
            
        }
    }
}
