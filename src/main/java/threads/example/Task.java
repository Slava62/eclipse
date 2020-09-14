package threads.example;

class Task implements Runnable{

    private float [] arr;

    public long getCalcTime() {
        return calcTime;
    }

    private long calcTime;

    public Task(float [] arr) {
        this.arr=arr;
    }

    public void calculate(){

        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = calcValue(arr[i]);
        }
        calcTime=System.currentTimeMillis() - start;
    }

    public float calcValue(float item){
        return (float) (item * Math.sin(0.2f + item / 5) * Math.cos(0.2f + item / 5) * Math.cos(0.4f + item / 2));
    }

    @Override
    public void  run() {
        calculate();
    }
}
