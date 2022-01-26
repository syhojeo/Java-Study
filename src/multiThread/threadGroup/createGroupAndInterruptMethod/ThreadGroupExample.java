package multiThread.threadGroup.createGroupAndInterruptMethod;

public class ThreadGroupExample {
    public static void main(String[] args) {
        //myGroup 생성
        ThreadGroup myGroup = new ThreadGroup("myGroup");
        //myGroup에 workThreadA,B를 소속시킴
        WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
        WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");
        
        workThreadA.start();
        workThreadB.start();

        System.out.println("[ main 스레드 그룹의 list() 메소드 출력 내용]");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        mainGroup.list();
        System.out.println();
        
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){}

        System.out.println("[ myGroup 스레드 그룹의 interrup() 메소드 호출 ]");
        myGroup.interrupt();
    }
}
