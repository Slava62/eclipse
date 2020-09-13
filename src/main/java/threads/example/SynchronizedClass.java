package threads.example;

public class SynchronizedClass {
    public static void main(String[] args) {
        SynchronizedClass e1 = new SynchronizedClass();
        System.out.println("Start");
        new Thread(() -> e1.method1()).start();
        new Thread(() -> e1.method2()).start();
    }

    public synchronized void method1() { //
        System.out.println("M1 start synchronized");
        for (int i = 0; i < 10; i++) {
            System.out.println("method 1: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M1 stop");
    }
    public synchronized void method2() {
        System.out.println("M2 start synchronized");
        for (int i = 0; i < 10; i++) {
            System.out.println("method 2: " +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M2 stop");
    }

}
