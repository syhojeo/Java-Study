package ramda.functionalInterface.apiFuncInterface.operator;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
    private static int[] scores = { 92, 95, 87};

    public static int maxOrMin(IntBinaryOperator operator) {
        int result = scores[0];
        for (int score : scores) {
            //2. 람다식 실행
            result = operator.applyAsInt(result, score);
        }
        return result;
    }

    public static void main(String[] args) {
        //최대값 얻기
        //1. 람다식 (함수적 인터페이스(IntBinaryOperator) 매개변수로 넣기
        int max = maxOrMin(
            (a, b) -> {
                if (a >= b) return a;
                else return b;
            }
        );
        System.out.println("최대값: " + max);

        //최소값 얻기
        int min = maxOrMin(
            (a, b) -> {
                if (a <= b) return a;
                else return b;
            }
        );
        System.out.println("최소값: " + min);
    }
}
