/*
    CompletionService를 사용하지 않고, 여러개의 작업 요청을 해보았다

    만약 CompletionService를 사용하지 않는다면 CompletionService.take()를
    이용하여 future 객체를 받아 올수 없고,
    그렇게 된다면 future 객체를 submit 할때마다 Future 객체를 읽어오고,
    ExecutorService.get()을 통해 한번씩 블로킹 되며 받아 올수 밖에 없다

    CompletionService 를 통해 일단 작업을 제출하고
    다른 스레드를 통해 제출된작업이 완료되면 순서대로 가져오는 식으로 처리를 하도록 하자
 */
package multiThread.threadPool.completionService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestNotCompletionService extends Thread {

    public static void main(String[] args) {
        //스레드풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
        );

        System.out.println("작업 처리 요청");
        for (int i = 0; i < 3; i++) {
            //CompletionService를 사용하지 않으면 submit 할때 마다 Future 객체를 받아 올 수 밖에 없다
            Future<Integer> future = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 1; i <= 10; i++) {
                        sum += i;
                    }
                    return sum;
                }
            });
            try {
                //포문이 지나기 전에 Future.get()을 사용하지 않으면 새로운 submit에 대한 Future객체를 받기 때문에
                //반드시 사용해야되고 사용시에는 블로킹이 되어 비슷한 작업을 여러번 요청할때에는
                //CompletionService 를 사용하는 것이 좋다
                int sum = future.get();
                System.out.println("작업 처리 결과: " + sum);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

}
