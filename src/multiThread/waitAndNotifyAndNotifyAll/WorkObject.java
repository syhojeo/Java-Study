package multiThread.waitAndNotifyAndNotifyAll;

public class WorkObject {
    public synchronized  void methodA() {
        System.out.println("ThreadA 의 methodA() 작업 실행");
        notify(); //일시 정지 상태에 있는 ThreadB 를 실행 대기 상태로 만듦
        try {
            wait(); //ThreadA를 일시 정지 상태로 만듦
        }catch (InterruptedException e) {}
    }

    public synchronized void methodB() {
        System.out.println("ThreadB 의 methodB() 작업 실행");
        notify(); //일시정지 상태에 있는 ThreadA를 실행 대기상태로 만듦
        try {
            wait(); //ThreadB를 일시 정지 상태로 만듦
        }catch (InterruptedException e) {}
    }

    public synchronized void methodC() {
        System.out.println("ThreadC 의 methodC() 작업 실행");
        notify(); //일시정지 상태에 있는 ThreadA를 실행 대기상태로 만듦
        try {
            wait(); //ThreadB를 일시 정지 상태로 만듦
        }catch (InterruptedException e) {}
    }
}
