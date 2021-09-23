public class Main {

    public static void main(String[] args) {
        Even even = new Even();
        // write your code here
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                    System.out.println(even.next()+ " "+Thread.currentThread().getName());

                }
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        System.out.println("done");
    }
}
