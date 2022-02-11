//Function 의 순차적 연결
package ramda.functionalInterface.apiFuncInterface.defaultMethod.function;

import java.util.function.Function;
import ramda.functionalInterface.apiFuncInterface.defaultMethod.consumer.Address;
import ramda.functionalInterface.apiFuncInterface.defaultMethod.consumer.Member;

public class FunctionAndThenComposeExample {

    public static void main(String[] args) {
        Function<Member, Address> functionA;
        Function<Address, String> functionB;
        Function<Member, String> functionAB;
        String city;

        //1. Function의 람다 정의
        functionA = m -> m.getAddress();
        functionB = a -> a.getCity();

        //2. Function의 순차적 연결을 위해 Function의 디폴트 메소드 andThen 을 사용한 Function 정의
        //andThen: functionA 먼저 실행 후 결과값을 매개변수로 functionB 를 순차적 실행 한다
        functionAB = functionA.andThen(functionB);
        //3. Function.apply() 메소드를 사용하여 람다 실행
        city = functionAB.apply(
            new Member("홍길동", "hong", new Address("한국", "서울"))
        );
        System.out.println("거주 도시: " + city);

        //compose: functionB 먼저 실행 후 결과값을 매개변수로 functionA 를 순차적 실행 한다
        functionAB = functionB.compose(functionA);
        city = functionAB.apply(
            new Member("홍길동", "hong", new Address("한국", "서울"))
        );
        System.out.println("거주 도시: " + city);
    }
}
