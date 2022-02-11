package ramda.functionalInterface.apiFuncInterface.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {

    public static void main(String[] args) {
        //람다를 이용한 익명 구현 객체 만들기 (추상메소드 구현)
        Consumer<String> consumer = t -> System.out.println(t + "8");
        //매개값을 넣고, 메소드 호출
        consumer.accept("java");

        BiConsumer<String, String> bigConsumer = (t, u) -> System.out.println(t + u);
        bigConsumer.accept("Java", "8");

        DoubleConsumer doubleConsumer = d -> System.out.println("Java" + d);
        doubleConsumer.accept(8.0);

        ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t + i);
        objIntConsumer.accept("Java", 8);
    }
}
