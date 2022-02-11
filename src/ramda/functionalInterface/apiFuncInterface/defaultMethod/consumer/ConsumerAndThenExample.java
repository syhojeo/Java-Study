//Consumer의 순차적 연결
package ramda.functionalInterface.apiFuncInterface.defaultMethod.consumer;

import java.util.function.Consumer;

public class ConsumerAndThenExample {

    public static void main(String[] args) {
        //1. Consumer 정의
        Consumer<Member> consumerA = m -> {
            System.out.println("consumerA: " + m.getName());
        };

        Consumer<Member> consumerB = m -> {
            System.out.println("consumerB: " + m.getId());
        };

        //consumerA 먼저 실행후 consumerB 실행하는 순차적 연결하는 consumerAB 선언
        Consumer<Member> consumerAB = consumerA.andThen(consumerB);
        //Consumer.accept 메소드를 통해 consumerA, consumerB 순차적 실행
        consumerAB.accept(new Member("홍길동", "hong", null));
    }
}
