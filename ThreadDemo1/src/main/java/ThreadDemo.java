class MyRunnable implements  Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from thread "+Thread.currentThread().getName() + " i = "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Who am i? "+Thread.currentThread().getName());
        System.out.println("Are we done?");
    }

}
