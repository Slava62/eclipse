package threads.example;

public class RunnableClass implements Runnable {
    public static void main(String[] args) {
        new Thread(new RunnableClass()).start();
        new Thread(new RunnableClass()).start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
               Thread.sleep(100);
                System.out.println("new thread: " + i);
           } catch (InterruptedException e) {
            e.printStackTrace();
           }
        }
    }
}


