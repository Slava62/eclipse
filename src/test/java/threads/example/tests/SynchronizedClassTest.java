package threads.example.tests;

import org.junit.jupiter.api.Test;
import threads.example.SynchronizedClass;

class SynchronizedClassTest {

    @Test
    public void synchronizedTest(){
        SynchronizedClass e1 = new SynchronizedClass();
        System.out.println("Start");
        new Thread(() -> e1.method1()).start();
        new Thread(() -> e1.method2()).start();
    }



}