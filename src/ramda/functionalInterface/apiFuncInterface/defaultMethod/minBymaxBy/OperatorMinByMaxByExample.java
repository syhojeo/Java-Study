//MinBy, MaxBy는 Operator(BinaryOperator) 에 선언되어 있는 정적 메소드이다 (디폴트 X)
package ramda.functionalInterface.apiFuncInterface.defaultMethod.minBymaxBy;

import java.util.function.BinaryOperator;

public class OperatorMinByMaxByExample {

    public static void main(String[] args) {
        BinaryOperator<Fruit> binaryOperator;
        Fruit fruit;

        //1. Comparator 로 비교하는 람다식 매개변수로 구현메소드 정의
        binaryOperator = BinaryOperator.minBy((f1, f2) -> Integer.compare(f1.price, f2.price));
        //apply 메소드를 사용하여 람다식 실행
        fruit = binaryOperator.apply(new Fruit("딸기", 6000), new Fruit("수박", 10000));
        System.out.println(fruit.name);

        binaryOperator = BinaryOperator.maxBy((f1, f2) ->  Integer.compare(f1.price, f2.price));
        fruit = binaryOperator.apply(new Fruit("딸기", 6000), new Fruit("수박", 10000));
        System.out.println(fruit.name);
    }
}
