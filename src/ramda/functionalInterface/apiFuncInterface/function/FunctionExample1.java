package ramda.functionalInterface.apiFuncInterface.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample1 {
    private static List<Student> list = Arrays.asList(
        new Student("홍길동", 90, 96),
        new Student("신용권", 95, 93)
    );

    //2. 매개변수 람다식을 function으로 받고, function의 메소드인 applyXXX를 사용하여 람다식을 실행한다
    public static void printString(Function<Student, String> function) {
        for(Student student : list) { // list에 지정된 항목 수만큼 루핑
            //3. 람다식실행
            //t -> t.getName() , t = student, t.getName() = student.getName() 실행
            System.out.println(function.apply(student) + " ");
        }
        System.out.println();
    }

    public static void printInt(ToIntFunction<Student> function) {
        for (Student student : list) {
            //람다식실행
            System.out.println(function.applyAsInt(student) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("[학생 이름]");
        //1. 람다식을 실행하는 function(함수적 인터페이스의 표준 API)을 매개변수로 넣어준다
        printString(t -> t.getName());

        System.out.println("[영어 점수]");
        printInt(t -> t.getEnglishScore());

        System.out.println("[수학 점수]");
        printInt(t -> t.getMathScore());
    }
}
