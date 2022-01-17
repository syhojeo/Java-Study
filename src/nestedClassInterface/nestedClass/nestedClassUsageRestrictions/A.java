//바깥 클래스의 필드와 메소드에서의 멤버 클래스 사용 제한
package nestedClassInterface.nestedClass.nestedClassUsageRestrictions;

public class A {
    //인스턴스 멤버 클래스
    class B {}

    //정적 멤버 클래스
    static class C {}

    //인스턴스 필드 (두 멤버 클래스 모두 사용가능)
    B field1 = new B();
    C field2 = new C();

    //인스턴스 메소드 (두 멤버 클래스 모두 사용가능)
    void method1() {
        B var1 = new B();
        C var2 =  new C();
    }

    //정적 필드 초기화
    //static B field3 = new B(); 사용(X)
    static C field4 = new C();

    //정적 메소드
    static void method2() {
        //B var1 = new B(); 사용(X)
        C var2 = new C();
    }

    /*
        인스턴스 멤버 클래스의 경우 정적 필드와 정적 메소드로의 객체 생성이 불가능하다
        정적으로 선언된다는 것은 바깥 class A의 객체가 생성되지 않아도 사용할 수 있어야한다는 뜻인데
        인스턴스 멤버 클래스는 class A가 객체 생성되어야 사용할 수 있는 클래스 이기 때문에
        정적 필드나 정벅 메소드에서 인스턴스 멤버 클래스를 정적으로 객체 생성을 할 수 없다.
     */

}
