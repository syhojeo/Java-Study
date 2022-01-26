package multiThread.threadPool.submit.ReturnSubmit;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByCallableExample {

    public static void main(String[] args) {
        //스레드 풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
        );

        System.out.println("[작업 처리 요청]");
        //Callable <> 안에 리턴받을 타입 적기 ex) <Integer> , <String>
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 10; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        //작업 처리 요청 후 통보 받을 future 객체 리턴
        Future<Integer> future = executorService.submit(task);

        try {
            int sum = future.get();
            System.out.println("[처리 결과] " + sum);
            System.out.println("[작업 처리 완료]");
        } catch (ExecutionException e) {
            System.out.println("[작업 처리 실행 중 예외 발생]");
        } catch (InterruptedException e) {
            System.out.println("[작업 처리 실행 중 interrupt 발생]");
        }
        executorService.shutdown();
    }
}
