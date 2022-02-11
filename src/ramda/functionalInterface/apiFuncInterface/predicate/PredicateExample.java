package ramda.functionalInterface.apiFuncInterface.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import ramda.functionalInterface.apiFuncInterface.predicate.Student;

public class PredicateExample {
    private static List<Student> list = Arrays.asList(
        new Student("홍길동", "남자", 90),
        new Student("김순희", "여자", 90),
        new Student("감자바", "남자", 95),
        new Student("박한나", "여자", 92)
    );

    //2. 정의된 람다식을 Predicate 형식의 매개변수로 받는다
    public static double avg(Predicate<Student> predicate) {
        int count = 0, sum = 0;
        for (Student student : list) {
            //3. predicate 의 test메소드를 사용하여 람다식을 실행한다
            if (predicate.test(student)) {
                count++;
                sum += student.getScore();
            }
        }
        return (double) sum / count;
    }

    public static void main(String[] args) {
        //1. 람다식 정의 후 Predicate 형 매개변수로 넘긴다
        double maleAvg = avg(t -> t.getSex().equals("남자"));
        System.out.println("남자 평균 점수: " + maleAvg);

        double femaleAvg = avg(t -> t.getSex().equals("여자"));
        System.out.println("여자 평균 점수: " + femaleAvg);
    }
}
