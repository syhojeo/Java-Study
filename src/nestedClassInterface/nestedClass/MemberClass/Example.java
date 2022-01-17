//인스턴스 멤버 클래스 생성
package nestedClassInterface.nestedClass.MemberClass;

public class Example {

    public static void main(String[] args) {
        //정적 멤버 클래스는 바깥 객체가 생성되지 않아도 사용이 가능하다

        //정적 멤버 클래스의 정적 필드, 메소드의는 정적 멤버 클래스가 객체 생성되지 않아도 사용가능하다
        A.C.field2 = 3; //정적 필드 사용
        A.C.method2();  //정적 메소드 사용

        //정적 멤버 클래스의 인스턴스 필드, 메소드
        //인스턴스 필드, 메소드의 경우 본인 클래스의 객체 생성이 필요
        A.C c = new A.C();
        c.filed1 = 3; //인스턴스 필드 사용
        c.method1();    //인스턴스 메소드 사용

        //인스턴스 멤버 클래스의 인스턴스 필드, 메소드는 바깥 클래스를 객체 생성 해줘야 사용가능
        A a = new A();

        //인스턴스 멤버 클래스 사용법
        //인스턴스 멤버 클래스인 B 클래스를 객체 생성해야 사용가능
        A.B b = a.new B(); //객체 생성시 a.mew 라는 표현을 기술해야한다.
        b.filed1 = 3;
        b.method1();

        //로컬 클래스 사용
        a.method();
    }
}
