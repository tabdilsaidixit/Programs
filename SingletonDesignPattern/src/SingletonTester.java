
public class SingletonTester {
	public static void main(String[] args) {
        //Thread 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton instance1 = Singleton.getInstance();
                System.out.println("Instance 1 hash:" + instance1.hashCode());
            }
        });

        //Thread 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
            	Singleton instance2 = Singleton.getInstance();
                System.out.println("Instance 2 hash:" + instance2.hashCode());
            }
        });

        //start both the threads
        t1.start();
        t2.start();
   }
}
