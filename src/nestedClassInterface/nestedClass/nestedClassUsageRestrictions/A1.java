//멤버 클래스 내에서의 사용제한
package nestedClassInterface.nestedClass.nestedClassUsageRestrictions;

public class A1 {
    int field1;
    void method1() {}

    static int field2;
    static void method2() {}

    //인스턴스 멤버 클래스는 바깥 클래스의 모든 필드, 메소드가 사용 가능하다
    //왜냐하면 인스턴스 멤버 클래스는 바깥클래스가 생성된후 사용되기 때문에 접근에 문제가 없다
    class B1 {
        void method() {
            field1 = 10;
            method1();

            field2 = 10;
            method2();
        }
    }

    //반면에 정적 멤버 클래스는 바깥 클래스의 인스턴스 필드와 메소드가 사용이 불가능하다
    //왜냐하면 정적메소드의 경우 바깥클래스인 A1이 객체가 생성되어있지 않아도 사용이 가능해야한데
    //바깥 클래스 A1의 인스턴스 필드와 메소드를 사용한다는 것은 바깥 클래싀 A1의 객체 생성에 의존할 수 밖에 없기 때문이다.
    static class C1 {
        void method() {
            //field1 = 10;
            //method1();

            field2 = 10;
            method2();
        }
    }

}
