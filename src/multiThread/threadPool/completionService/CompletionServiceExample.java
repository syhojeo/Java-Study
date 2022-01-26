/*
    작업이 완료되는 순차적으로 결과 통보받기
    CompletionService 사용법
 */
package multiThread.threadPool.completionService;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceExample extends Thread {

    public static void main(String[] args) {
        //최대 스레드 = CPU 최대 사용량인 스레드풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
        );
        //순차적으로 결과를 통보받기 위한 CompletionService 생성
        //CompletionService의 구현객체인 Executorservice 를 매개값으로 넣어준다
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
            executorService);

        System.out.println("[작업 처리 요청]");
        //작업 요청
        for (int i = 0; i < 3; i++) {
            //순차적으로 결과를 통보 받기 위해 CompletionService.submit() 메소드 사용
            completionService.submit(new Callable<Integer>() {
                //Callable 객체로 보낼때 run() 이 아닌 call() 사용
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 1; i <= 10; i++) {
                        sum += i;
                    }
                    return sum;
                }
            });
        }
        System.out.println("[처리 완료된 작업 확인]");
        //스레드 풀의 스레드에서 실행
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        //submit 이 아닌 CompletionService.take() 로 부터 Future 객체 받기(완료된 작업 가져오기)
                        Future<Integer> future = completionService.take();
                        int value = future.get();
                        System.out.println("[처리 결과] " + value);
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        //스레드 풀 종료
        executorService.shutdownNow();
    }
}
