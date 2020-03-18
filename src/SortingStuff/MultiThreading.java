package SortingStuff;

public class MultiThreading extends Thread{

    private Thread t;
    private String threadName;

    public MultiThreading(String name){
        threadName = name;
        System.out.println("CREATING THREAD: " + name);
    }

    public void run(){
        System.out.println("RUNNING: " + this.threadName );
        try {
            for(int i = 500; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(0);
            }
        } catch (Exception e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
    }

    public static void main(String[] args) {
        MultiThreading T1 = new MultiThreading( "Thread-1");
        MultiThreading T2 = new MultiThreading( "Thread-2");
        T1.start();
        T2.start();
    }

}
