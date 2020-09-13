package threads.example.tests;

import org.junit.jupiter.api.Test;
import threads.example.RunnableClass;

class RunnableClassTest {

    @Test
    void runTest() {
        new Thread(new RunnableClass()).start();
        new Thread(new RunnableClass()).start();
    }
}