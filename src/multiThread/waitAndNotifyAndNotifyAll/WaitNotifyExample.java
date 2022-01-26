package multiThread.waitAndNotifyAndNotifyAll;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

public class WaitNotifyExample {

    public static void main(String[] args) {
        WorkObject sharedObject = new WorkObject();

        ThreadA threadA = new ThreadA(sharedObject);
        ThreadB threadB = new ThreadB(sharedObject);
        ThreadC threadC = new ThreadC(sharedObject);

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
