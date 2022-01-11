/*
    자동 클래스 타입 변환

*/
package inheritance.autoTransform;

//4가지의 여러 상속 클래스 선언
class A {}

class B extends A{}
class C extends A{}

class D extends B{}
class E extends C{}

public class AutoTransform {
    //각 객체 생성
    B b = new B();
    C c = new C();
    D d = new D();
    E e = new E();

    /*
        자동 클래스 타입 변환
        a1 ~ a4 는 자동 타입 변환된 이후 부모 클래스에 선언된 필드와 메소드만 접근이 가능하다
        다만 자식 클래스에서 오버라이딩이 된 메소드가 있다면 오버라이딩 된 메소드만 대신 출력 가능하다.
     */

    A a1 = b;
    A a2 = c;
    A a3 = d;
    A a4 = e;

    B b1 = d;
    C c1 = e;

    //직계 상속이 아니기 때문에 자동 클래스 타입변환이 불가능하다
    //B b3 = e;
    //C c2 = d;
}