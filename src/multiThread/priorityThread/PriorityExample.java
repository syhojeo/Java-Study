package multiThread.priorityThread;

public class PriorityExample {

    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++) {
            Thread thread = new CalcThread("thread" + i);
            if(i != 10) {
                //가장 낮은 우선순위 부여
                thread.setPriority(Thread.MIN_PRIORITY);
            }
            else {
                //가장 높은 우선순위 부여
                thread.setPriority(Thread.MAX_PRIORITY);
            }
            thread.start();
        }
    }
}