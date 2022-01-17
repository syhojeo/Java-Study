/*
    인스턴스 멤버 클래스
    인스턴스 멤버 클래스는 static 키워드 없이 선언된 클래스를 말한다
    인스턴스 필드와 메소드만 선언이 가능하고, 정적 필드와 메소드를 선언할 수 없다.
 */
package nestedClassInterface.nestedClass.MemberClass;

public class A {
    //클래스 A 생성자
    A() {
        System.out.println("A 객체가 생성됨");
    }
    
    /*
    인스턴스 멤버 클래스는 static 키워드 없이 선언된 클래스를 말한다
    인스턴스 필드와 메소드만 선언이 가능하고, 정적 필드와 메소드를 선언할 수 없다.
    */
    class B {
        B() {
            System.out.println("B 객체가 생성됨");
        } //생성자
        int filed1; //인스턴스 필드
        //static int filed2; 정적필드는 사용X

        void method1() {} //인스턴스 메소드
        //static void method2(); 정적메소드 사용Xㅇ
    }

    //정적 멤버 클래스 static이 붙어 정적으로 선언된 클래스를 말한다
    //인스턴스 멤버 클래스와 달리 정적 필드나 정적 메소드를 만드는데 대한 제약이 없다
    static class C {
        C() {
            System.out.println("C 객체가 생성됨");
        } //생성자
        int filed1; //인스턴스 필드
        static int field2; //정적 필드
        void method1() {} //인스턴스 메소드
        static void method2(){} //정적 메소드
    }

    void method() {
        //로컬 클래스
        //static 정적 필드, 메소드는 사용하지 못한다
        class D{
            D() { System.out.println("D 객체가 생성된다");}
            int field1;
            //static int field2;

            void method1() {}
            //static void method2() {}
        }
        D d = new D();
        d.field1 = 3;
        d.method1();
    }

}
