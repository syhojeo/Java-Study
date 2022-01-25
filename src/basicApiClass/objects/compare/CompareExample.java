/*
    compare(T a, T b, Comparator<T>c)
    두 객체 a,b를 비교자 Comparator 로 비교하여 int 값을 리턴한다
    a가 비보다 작으면 음수, 같으면 0 , 크면 양수를 리턴
 */
package basicApiClass.objects.compare;

import java.util.Comparator;
import java.util.Objects;

public class CompareExample {

    public static void main(String[] args) {
        Student s1 = new Student(1);
        Student s2 = new Student(1);
        Student s3 = new Student(2);

        //s1 == s2 이므로 result = 0
        int result = Objects.compare(s1, s2, new StudentComparator());
        System.out.println(result);
        //s1 < s3 이므로 result = -1
        result = Objects.compare(s1, s3, new StudentComparator());
        System.out.println(result);
    }

    static class Student {
        int sno;
        Student(int sno) {
            this.sno = sno;
        }
    }


    static class StudentComparator implements Comparator<Student> {
        /*
            if (a.sno < b.sno) return -1;
            else if (a.sno == b.sno) return 0;
            else return 1;
        */
        //위의 코드를 대체
        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.sno, o2.sno);
        }
    }
}
