package multiThread.threadPool.saveOutsideObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnableExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
        );

        System.out.println("[작업 처리 요청]");
        //생성자 추가를 해야하기 때문에 Runnable 구현 객체를 직접 만들어줘야한다
        class Task implements Runnable {
            Result result;
            //생성자 설정
            Task(Result result) {
                this.result = result;
            }
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= 10; i++) {
                    sum += i;
                }
                //바깥 외부 객체 Result에 작업 결과 저장
                result.addValue(sum);
            }
        }

        Result result = new Result();
        //작업을 두번 처리하기 위함
        Runnable task1 = new Task(result);
        Runnable task2 = new Task(result);

        //작업 요청 및 Future 객체 받기
        Future<Result> future1 = executorService.submit(task1, result);
        Future<Result> future2 = executorService.submit(task2, result);

        //Future.get()
        try {
            //스레드 작업이 끝날때 까지 블로킹
            result = future1.get();
            //스레드 작업이 끝날때 까지 블로킹
            result = future2.get();
            System.out.println("[처리 결과] " + result.accumValue);
            System.out.println("[작업 처리 완료]");
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.out.println("[실행 예외 발생함] " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("[실행 인터럽트 발생함] " + e.getMessage());
        }
        //스레드풀 종료
        executorService.shutdown();
    }
}

class Result {
    int accumValue;
    //동기화 메소드를 사용해서 두개 이상의 스레드가 Result 객체에 접근하여도 문제가 발생하지 않게끔 만들어준다
    synchronized void addValue(int value) {
        accumValue += value;
    }
}
