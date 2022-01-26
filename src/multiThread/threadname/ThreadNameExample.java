package multiThread.threadname;

public class ThreadNameExample {

    public static void main(String[] args) {
        //이코드를 실행하는 스레드 객체 얻기
        Thread mainThread = Thread.currentThread();
        System.out.println("프로그램 시작 스레드 이름" + mainThread.getName() );

        ThreadA threadA = new ThreadA(); // THread A 생성
        System.out.println("작업 스레드 이름: " + threadA.getName());
        threadA.start();

        ThreadB threadB = new ThreadB(); // THread B 생성
        System.out.println("작업 스레드 이름: " + threadB.getName());
        threadB.start();
    }
}
