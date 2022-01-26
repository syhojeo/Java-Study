package multiThread.synchronizedMethodAndBlock;

public class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }

    //동기화 메소드
    /*public synchronized void setMemory(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){}
        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }*/

    //동기화 블록
    public void setMemory(int memory) {
        synchronized (this) { //this 를 씀으로써 자기자신의 객체를 잠김대상으로 넣는다
            this.memory = memory;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e){}
            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }
    }
}
