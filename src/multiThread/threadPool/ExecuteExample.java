package multiThread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteExample {

    public static void main(String[] args) throws Exception {
        //최대 스레드 개수가 2인 스레드풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            //작업 정의
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    //스레드 총 개수 및 작업 스레드 이름 출력
                    //ThreadPoolExecutor  = 스레드 풀을
                    //newCachedThreadPool(), newFixedThreadPool() 메소드를 사용하지 않고,
                    // 커스텀하여 사용하고 싶을때 사용하던 객체
                    //ThreadPoolExecutor의 getPoolSize() 메소드를 사용하기 위해 강제 타입 변환
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);

                    //예외 발생 시킴
                    int value = Integer.parseInt("삼");
                }
            };
            //작업 처리 요청
            executorService.execute(runnable);
            //executorService.submit(runnable);

            //콘솔에 출력 시간을 주기 위해 0.01초 일시 정지 시킴
            Thread.sleep(10);
        }
        //스레드 풀 종료
        executorService.shutdown();
    }
}
