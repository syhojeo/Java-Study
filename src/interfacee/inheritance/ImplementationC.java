package interfacee.inheritance;

//InterfaceC 는 InterfaceA, InterfaceB로 부터 상속 받았기 때문에
//InterfaceC의 추상 메소드(methodC) 뿐만 아니라
//InterfaceA, InterfaceB의 추상 메소드(methodA, methodB) 까지 실체 메소드로 구현해줘야한다.
public class ImplementationC implements InterfaceC{
    public void methodA() {
        System.out.println("ImplementationC-methodA() 실행");
    }

    public void methodB() {
        System.out.println("ImplementationC-methodB() 실행");
    }

    public void methodC() {
        System.out.println("ImplementationC-methodC() 실행");
    }
}
