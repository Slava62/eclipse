package threads.example.tests;

import org.junit.jupiter.api.Test;
import threads.example.SynchronizedWithLockClass;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedWithLockClassTest {
    @Test
    public void lockTest() {

        SynchronizedWithLockClass e2 = new SynchronizedWithLockClass();
        System.out.println("Start");
        new

                Thread(() -> e2.method1()).

                start();
        new

                Thread(() -> e2.method1()).

                start();
    }
}