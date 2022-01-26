package basicApiClass.objects.hashAndHashCode;

import java.util.Objects;

public class HashCodeExample {

    public static void main(String[] args) {
        Student s1 = new Student(1, "홍길동");
        Student s2 = new Student(1, "홍길동");

        //생성자의 매개변수가 같은 객체들을 이용하여 Objecs.hashcode를 사용했기 때문에 값은 같다
        System.out.println(s1.hashCode());
        //차이점은 Objects.hashCode() 의 매개값이 null 이면 0을 리턴한다
        System.out.println(Objects.hashCode(s2));
    }
    
    static class Student {
        int sno;
        String name;
        Student(int sno, String name) {
            this.sno = sno;
            this.name = name;
        }

        @Override
        public int hashCode() {
            //매개값 sno, name을 이용하여 해시코드를 만들고 이 값을 리턴한다
            return Objects.hash(sno, name);
        }
    }
}
