class MyThr extends Thread {

    public MyThr(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 300) {
            System.out.println("I am a Thread!😃");
            System.out.println("Thank You!");
            i++;
        }
    }
}

public class _3_ThreadConstructor {
    @SuppressWarnings({ "deprecated", "deprecation" })
    public static void main(String[] args) {
        MyThr t1 = new MyThr("Akash");
        MyThr t2 = new MyThr("Ram Candra");

        t1.start();
        t2.start();
        
        // Due to the nature of JVM thread scheduling, System.out.println statements may not get executed when expected.
        // We have to ensure that t1 & t2 waits  until t1 and t2 complete their execution before printing the 
        // thread IDs and names. This way, you should see all your desired output properly.

        System.out.println("The id of the thread t is " + t1.getId());
        System.out.println("The name of the thread t is " + t1.getName());
        System.out.println("The id of the thread t is " + t2.getId());
        System.out.println("The name of the thread t is " + t2.getName());

    }
}
