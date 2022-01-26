package multiThread.threadname;

public class ThreadA extends Thread{
    //생성자에서 이름설정
    public ThreadA() {
        setName("ThreadA");
    }
    //ThreadA 의 실행내용
    public void run() {
        for(int i = 0; i < 2; i++) {
            //부모 객체 Thread의 getName() 메소드를 통해 스레드 이름 가져오기
            System.out.println(getName() + "가 출력한 내용");
        }
    }
}
