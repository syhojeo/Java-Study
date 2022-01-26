package multiThread.controlThreadState.yieldMethod;

public class YieldExample {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        //TheadA, ThreadB 모두 실행
        threadA.start();
        threadB.start();
        
        try {Thread.sleep(3000);} catch (InterruptedException e) {}
        threadA.work = false; //ThreadB 만 실행

        try {Thread.sleep(3000);} catch (InterruptedException e) {}
        threadA.work = true; //ThreadA, ThreadB 모두 실행
        
        try {Thread.sleep(3000);} catch (InterruptedException e) {}
        //ThreadA, TheadB 모두 종료
        threadA.stop = true;
        threadB.stop = true;
    }
    
}
