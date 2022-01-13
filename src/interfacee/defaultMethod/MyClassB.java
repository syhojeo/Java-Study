package interfacee.defaultMethod;

public class MyClassB implements MyInterface{
    @Override
    public void method1() {
        System.out.println("MyClassB-method1() 실행");
    }

    //인터페이스의 디폴트 메소드 또한 오버라이딩이 가능하다
    @Override
    public void method2() {
        System.out.println("MyClassB-method2() 실행");
    }
}