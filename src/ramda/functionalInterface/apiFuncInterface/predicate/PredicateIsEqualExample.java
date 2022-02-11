//predicate 의 isEqual 정적 메소드 사용
package ramda.functionalInterface.apiFuncInterface.predicate;

import java.util.function.Predicate;

public class PredicateIsEqualExample {

    public static void main(String[] args) {
        Predicate<String> predicate;

        //1. 첫번째 비교할 값을 isEqual 메소드의 매개변수로 넣기
        predicate = Predicate.isEqual(null);
        //2. 두번쨰 비교할 값을 predicate.test 메소드를 실행해서 넣기기
       System.out.println("null, null: " + predicate.test(null));

        predicate = Predicate.isEqual("Java8");
        System.out.println("null Java8: " + predicate.test(null));

        predicate = Predicate.isEqual(null);
        System.out.println("null Java8: " + predicate.test("Java8"));

        predicate = Predicate.isEqual("Java8");
        System.out.println("Java8 Java8: " + predicate.test("Java8"));

        predicate = Predicate.isEqual("Java8");
        System.out.println("Java8 Java7: " + predicate.test("Java7"));
    }
}
