//자동 타입 변환을 이용한 필드의 다형화 구현
package interfacee.fieldPolymorphism;

public class CarExample {

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.run();

        //금호 타이어 객체로 교체
        //필드의 다형화
        myCar.frontLeftTire = new KumhoTire();
        myCar.frontRightTire = new KumhoTire();

        myCar.run();
    }

}
