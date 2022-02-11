//메소드 참조를 이용하여 생성자 참조를 한다
package ramda.functionalInterface.methodReference;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferencesExample {

    public static void main(String[] args) {
        //생성자를 참조 할것것을 정의
        Function<String, Member> function1 = Member :: new;
        //Function 의 apply 메소드를 사용하여 생성자를 직접 넣어준다
        Member member1 = function1.apply("angel");

        BiFunction<String, String, Member> function2 = Member :: new;
        Member member2 = function2.apply("신천사", "angel");

        Supplier<Member> supplier = Member :: new;
        Member member3 = supplier.get();
    }

    public static class Member {
        private String name;
        private String id;

        public Member() {
            System.out.println("Member() 실행");
        }

        public Member(String id) {
            System.out.println("Member(String id) 실행");
            this.id = id;
        }

        public Member(String name, String id) {
            System.out.println("Member(String name, String id) 실행");
            this.name = name;
            this.id = id;
        }
        public String getId() { return id; }
    }
}

