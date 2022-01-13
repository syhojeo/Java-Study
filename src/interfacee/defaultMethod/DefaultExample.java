package interfacee.defaultMethod;

public class DefaultExample {

    public static void main(String[] args) {
        MyInterface mi = new MyClassA();
    
        //method1만 오버라이딩 되었고, method2는 interface의 default method로 적용
        mi.method1();
        mi.method2();

        mi = new MyClassB();

        //MyClassB에서 default 메소드도 오버라이딩 했으므로 두 메소드 모두 오버라이딩 된것을 확인
        mi.method1();
        mi.method2();
    }
}
