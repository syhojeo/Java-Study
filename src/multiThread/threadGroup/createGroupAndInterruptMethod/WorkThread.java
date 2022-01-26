package multiThread.threadGroup.createGroupAndInterruptMethod;

public class WorkThread extends Thread {
    //생성자에 Thread group 과 Thread 이름을 넣어서 설정해준다
    public WorkThread(ThreadGroup threadGroup, String threadName) {
        //스레드 그룹과 스레드 이름을 설정
        super(threadGroup, threadName);
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
                break;
            }
        }
        System.out.println(getName() + "종료됨");
    }
}