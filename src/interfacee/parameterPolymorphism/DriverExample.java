//자동 타입 변환을 이용한 매개변수의 다형화 구현

package interfacee.parameterPolymorphism;

public class DriverExample {

    public static void main(String[] args) {
        Driver driver = new Driver();

        //driver.drive(new Taxi());
        //driver.drive(new Bus());

        Taxi taxi = new Taxi();
        Bus bus = new Bus();

        //자동 타입변환
        driver.drive(bus);
        driver.drive(taxi);
    }
}
