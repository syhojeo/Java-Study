package multiThread.threadPool.createThreadPool;

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
                    //ThreadPoolExecutor
                    //스레드풀을 생성할때 newCachedThreadPool(), newFixedThreadPool() 메소드를 사용하지 않고,
                    // 직접 커스텀하여 사용하고 싶을때 사용하던 객체
                    //위의 두 메소드도 결국 ThreadPoolExecutor 타입을 리턴해줌

                    //ThreadPoolExecutor의 getPoolSize() 메소드를 사용하기 위해 강제 타입 변환
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);

                    //예외 발생 시킴
                    int value = Integer.parseInt("삼");
                }
            };
            /*
                exception 예외가 발생했을때 execute() 메소드와 submit() 메소드의 차이를 알 수 있다
                1.execute()
                execute()메소드의 경우 예외 발생시 예외가 발생한 스레드를 소멸시키고 새로운 스레드를 생성시킨다
                때문에 스레드네임이 1,2,3,4 등 계속해서 변하는것을 확인 할 수 있다
                
                2.submit()
                submit() 메소드의 경우 예외가 발생하더라도 무시하고 계속해서 스레드가 실행된다는것을 스레드 이름이
                1,2만 출력된다는것 에서 알 수 있다
             */

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