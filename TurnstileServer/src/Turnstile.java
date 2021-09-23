import java.util.concurrent.atomic.AtomicInteger;

public class Turnstile implements Runnable{
    private final Spectator sharedCounter;
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int ID;
    private static Turnstile[] turnstiles;

    public int getID() {
        return ID;
    }

    Turnstile(Spectator sharedCounter) {
        this.sharedCounter = sharedCounter;
        ID = count.incrementAndGet();
    }

    @Override
    public void run() {
        this.sharedCounter.incrementSpectators();
    }
}
