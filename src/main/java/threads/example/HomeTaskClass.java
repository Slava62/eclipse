package threads.example;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HomeTaskClass {
    static final int SIZE = 10_000_000;

    static final int HALF = SIZE / 2;
    private static final int MAX_T =4;

    public static void main(String[] args) {
        HomeTaskClass homeTaskClass = new HomeTaskClass();
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        float [] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= i;
        }
        float [] arr1=arr.clone();
        Runnable r1= new Task(arr);
        pool.execute(r1);


        float [] arrFirstHalf = new float[HALF], arrSecondHaif=new float[HALF];
        long start = System.currentTimeMillis();
        System.arraycopy(arr1,0,arrFirstHalf,0,HALF);
        System.arraycopy(arr1,HALF,arrSecondHaif,0,HALF);
        long calcTime = System.currentTimeMillis() - start;
        Runnable r2 = new Task(arrFirstHalf);
        Runnable r3 = new Task(arrSecondHaif);
        pool.execute(r2);
        pool.execute(r3);
        start=System.currentTimeMillis();
        System.arraycopy(arrFirstHalf, 0, arr1, 0, HALF);
        System.arraycopy(arrSecondHaif, 0, arr1, HALF, HALF);
        calcTime = System.currentTimeMillis()-start+calcTime;

        pool.shutdown();

        System.out.println("half value 1" + arr[HALF] + " sise " + arr.length);
        System.out.println(((Task)r1).getCalcTime());
        System.out.println("half value 2" + arr1[HALF] + " sise " + arr1.length);
        System.out.println(((Task)r2).getCalcTime()+((Task)r3).getCalcTime()+calcTime);
    }


}
