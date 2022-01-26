package multiThread.threadGroup.getThreadGroupName;

import java.util.Map;
import java.util.Set;
import multiThread.threadGroup.getThreadGroupName.AutoSaveThread;

public class ThreadInfoExample {

    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setName("AutoSaveThread");
        autoSaveThread.setDaemon(true); //데몬스레드로 설정
        autoSaveThread.start();

        //모든 thread를 가져오는 코드 (getAllStarckTraces() 사용)
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        Set<Thread> threads = map.keySet();

        for (Thread thread : threads) { //Thread를 하나씩 가져와 루핑시킴
            System.out.println("Name: " + thread.getName() + ((thread.isDaemon())? "(데몬)": "(주)"));
            System.out.println("\t" + "소속그룹: " + thread.getThreadGroup().getName());
        }
        System.out.println();
    }
}