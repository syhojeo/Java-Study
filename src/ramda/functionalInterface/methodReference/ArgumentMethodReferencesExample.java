//매개변수의 메소드 참조
package ramda.functionalInterface.methodReference;
import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferencesExample {

    //compareToIgnoreCase 를 이용한 소대문자 상관없이 문자열이 같은지 비교
    public static void main(String[] args) {
        ToIntBiFunction<String, String> function;

        function = (a, b) -> a.compareToIgnoreCase(b);
        print(function.applyAsInt("Java8", "JAVA8"));

        //1. 타겟 타입을 참조한뒤
        function = String :: compareToIgnoreCase;
        //2. 알맞는 타입의 매개변수를 apply를 통해 넣어주면 된다
        print(function.applyAsInt("Java8", "JAVA8"));
    }

    public static void print(int order) {
        if (order < 0) {
            System.out.println("사전순으로 먼저 옵니다.");
        }
        else if (order == 0) {
            System.out.println("동일한 문자열입니다.");
        }
        else {
            System.out.println("사전순으로 나중에 옵니다.");
        }
    }
}
