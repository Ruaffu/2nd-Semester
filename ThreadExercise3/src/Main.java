import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WorkerCancelable implements Runnable{
    boolean keepRunning = true;
    Thread thread;
    public void run() {
        thread = Thread.currentThread();
        while(keepRunning){
            System.out.println(Thread.currentThread().getName()+"Hello");

//            if (thread.isInterrupted()){
//                System.out.println("Interrupted. Stop me");
//                cancel();
//            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                cancel();
            }
        }
    }
    public void cancel() {
        keepRunning = false;
    }
}

 class ThreadExercise3 {

    public static void main(String[] args) throws InterruptedException {
        WorkerCancelable worker = new WorkerCancelable();
        WorkerCancelable worker1 = new WorkerCancelable();
        WorkerCancelable worker2 = new WorkerCancelable();
        WorkerCancelable worker3 = new WorkerCancelable();
        WorkerCancelable worker4 = new WorkerCancelable();
//        Thread t = new Thread(worker);
//        Thread t2 = new Thread(worker);
//        Thread t3 = new Thread(worker);
//        Thread t4 = new Thread(worker);
//        Thread t5 = new Thread(worker);

        ExecutorService es = Executors.newFixedThreadPool(3);
        es.execute(worker);
        es.execute(worker1);
        es.execute(worker2);
        es.execute(worker3);
        es.execute(worker4);
        es.awaitTermination(5000, TimeUnit.MILLISECONDS);
        es.shutdownNow();
           System.out.println("DONE");


//        t.start();
//        t.join(2000);
//        t.interrupt();
    }
}
