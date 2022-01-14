package nestedClassInterface.anonymousObject.anonymousObjectBasicClass;

public class AnonymousExample {

    public static void main(String[] args) {
        Anonymous anony = new Anonymous();

        //익명 객체 필드 사용
        anony.field.wake();
        /*
            field 에 선언된 field2, work()는 사용 불가능하다
            오버라이드 되지 않은 필드와 메소드는 (field2, work())
            익명 객체 외부에서 사용 불가능하다 (자식객체로 자동타입변환된 객체 이기 때문이다)

            anony.field.work();
            anony.field.field2 = 4;
         */
        //익명 객체 로컬 변수 사용
        anony.method1();

        //익명 객체 매개값 사용
        anony.method2(
            new Person() {
                //매개변수로써의 타입변환이 일어나고 부모객체 없는 즉 오버라이딩이 되지않은 메소드는 익명 객체 바깥에서 사용이 불가능하다.
                //다만 익명 객체 내부에서 사용할 수 있기 때문에 정의하고 사용한다.
                void study() {
                    System.out.println("공부합니다.");
                }

                @Override
                void wake() {
                    System.out.println("8시에 일어납니다.");
                    study();
                }
            }
        );
    }
}
