package ramda.functionalInterface.apiFuncInterface.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class FunctionExample2 {

    private static List<Student> list = Arrays.asList(
        new Student("홍길동", 90, 96),
        new Student("신용권", 95, 93)
    );

    //2. 매개변수 람다식을 function으로 받고, function의 메소드인 applyXXX를 사용하여 람다식을 실행한다
    public static double avg(ToIntFunction<Student> function) {
        int sum = 0;
        for (Student student : list) {
            //3.람다식 실행
            //s.getEnglishScore => s = student, student.getEnglishScore 실행
            sum += function.applyAsInt(student);
        }
        double avg = (double) sum / list.size();
        return avg;
    }

    public static void main(String[] args) {
        //1. 람다식을 실행하는 function(함수적 인터페이스의 표준 API)을 매개변수로 넣어준다
        double englishAvg = avg(s -> s.getEnglishScore());
        System.out.println("영어 평균 점수: " + englishAvg);

        double mathAvg = avg(s -> s.getMathScore());
        System.out.println("수학 평균 점수: " + mathAvg);
    }
}
