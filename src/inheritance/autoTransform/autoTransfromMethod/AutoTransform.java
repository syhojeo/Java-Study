//클래스의 매개변수 대입을 통한 자동형변환을 사용함으로써 메소드의 다형성 기술적으로 구현한다
package inheritance.autoTransform.autoTransfromMethod;

public class AutoTransform {

    public static void main(String[] args) {
        Drive drive = new Drive();
        Vehicle vehicle =  new Vehicle();
        Bus bus = new Bus();

        drive.start(vehicle); //일반적인 경우
        drive.start(bus); //bus 객체로 자동형변환이 일어난다
    }
}
