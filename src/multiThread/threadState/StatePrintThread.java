package multiThread.threadState;

public class StatePrintThread extends Thread {

    private Thread targetThread;

    public StatePrintThread(Thread targetThread) { //매개변수로는 상태를 조사할 스레드 받아오기
        this.targetThread = targetThread;
    }

    public void run() {
        while (true) {
            //스레드 상태 얻기
            Thread.State state = targetThread.getState();
            System.out.println("타겟 스레드 상태: " + state);

            //객체 생성상태인경우
            if (state == Thread.State.NEW) {
                targetThread.start();
            }

            //타겟 스레드가 종료상태일 경우 while문을 종료함
            if (state == State.TERMINATED) {
                break;
            }
            try {
                //0.5 초간 일시 정지
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}
