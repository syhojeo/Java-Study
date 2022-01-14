//익명 구현 객체는 필드, 메소드, 매개변수의 초기값으로 사용될 수 있다.
package nestedClassInterface.anonymousObject.anonymousObjectBasicClass;

//익명 객체는 생성자를 선언할 수 없다
public class Anonymous {
    //필드 초기값으로 익명 객체 생성
    Person field = new Person() {
        //오버라이드 되지 않은 필드와 메소드는 (field2, work())
        //익명 객체 외부에서 사용 불가능하다 (자식객체로 자동타입변환된 객체 이기 때문이다)
        //다만 익명 객체 내부에서 사용하기 위해 사용된다
        int filed2 = 5;
        void work() {
            System.out.println("출근합니다.");
        }

        //오버라이딩 된 객체만 익명 객체 외부에서 사용가능
        @Override
        void wake() {
            System.out.println("6시에 일어납니다.");
            work();
        }
    };

    void method1() {
        //메소드의 로컬 변수값으로 익명 자식 객체 생성
        Person localVar = new Person() { //익명객체로의 자동 타입 변환으로 인해 익명 객체의 Override 메소드가 적용
            void walk() {
                System.out.println("산책합니다.");
            }
            @Override
            void wake() {
                System.out.println("7시에 일어납니다.");
                walk();
            }
        };
        //로컬 변수 사용
        localVar.wake();
    }
    
    //메소드의 매개변수로 익명객체를 대입하기 위한 메소드를 세팅
    void method2(Person person) {
        person.wake();
    }
}
