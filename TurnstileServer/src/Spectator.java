import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Spectator {

    private static long count = 0;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());


    public synchronized long getValue() {
        return count;
    }

    public void incrementSpectators() {
        count++;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}