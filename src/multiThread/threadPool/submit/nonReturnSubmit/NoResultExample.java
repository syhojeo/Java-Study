//리턴값이 없는 작업 완료 통보
package multiThread.threadPool.submit.nonReturnSubmit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample {

    public static void main(String[] args) {
        //스레드풀 생성
        ExecutorService executorSerivce = Executors.newFixedThreadPool(
            //CPU코어 수만큼 최대 스레드를 생성
            Runtime.getRuntime().availableProcessors()
        );

        System.out.println("[작업 처리 요청]");
        //작업 설정
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= 10; i++) {
                    sum += i;
                    System.out.println("[처리 결과]" + sum);
                }
            }
        };
        //위에서 설정한 작업을 스레드풀의 작업 큐로 넣고 Future 객체 받아오기
        //Callable 이 아닌 runnable 객체를 submit의 매개변수로 넣었기 때문에
        //future 의 작업완료통보 값은 없음에도 future 객체를 리턴하는데 이는 스레드가 작업 처리를 정상적으로
        //완료했는지 작업 처리 도중에 예외가 발생했는지 확인하기 위해서이다
        Future future = executorSerivce.submit(runnable);

        //Futre.get() 사용해서 작업완료통보값은 없지만 예외처리나 interrupt를 당하지 않고 정상적으로 완료했는지 확인
        try {
            future.get();
            System.out.println("[작업 처리 완료]");
        } catch (Exception e) {
            System.out.println("[실행 예외 발생함] " + e.getMessage());
        }
    }
}