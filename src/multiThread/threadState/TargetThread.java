package multiThread.threadState;

public class TargetThread extends Thread {
    public void run() {
        //반복문 동안 RUNNABLE 상태 유지
        for (long i = 0; i < 1000000000; i++) {}
        try {
            //1.5초간 일시정지 => 일시정지 동안 Timed_WAITING 상태 유지
            Thread.sleep(1500);
        } catch (Exception e) {}
        //반복문 동안 RUNNABLE 상태 유지
        for(long i = 0; i < 1000000000; i++ ){}
    }
}
