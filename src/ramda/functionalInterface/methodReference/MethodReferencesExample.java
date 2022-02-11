//정적 메소드와 인스턴스 메소드 참조 (기존 메소드만 호출할 경우 사용)
package ramda.functionalInterface.methodReference;

import java.util.function.IntBinaryOperator;

public class MethodReferencesExample {

    public static void main(String[] args) {
        IntBinaryOperator operator;

        //정적 메소드 참조
        operator = (x, y) -> Calculator.staticMethod(x, y);
        System.out.println("결과1: " + operator.applyAsInt(1, 2));

        //위와 똑같이 동작
        operator = Calculator :: staticMethod;
        System.out.println("결과2: " + operator.applyAsInt(3,4));

        //인스턴스 메소드 참조
        Calculator obj = new Calculator();
        operator = (x, y) -> obj.instanceMethod(x, y);
        System.out.println("결과3: " + operator.applyAsInt(5, 6));

        //위와 똑같이 동작
        operator = obj :: instanceMethod;
        System.out.println("결과4: " + operator.applyAsInt(7, 8));
    }

    public static class Calculator {
        //정적 메소드
        public static int staticMethod(int x, int y) {
            return x + y;
        }

        //인스턴스 메소드
        public int instanceMethod(int x, int y) {
            return x + y;
        }
    }
}
