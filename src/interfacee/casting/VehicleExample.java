package interfacee.casting;

public class VehicleExample {

    public static void main(String[] args) {
        //자동 타입변환
        Vehicle vehicle = new Bus();

        vehicle.run();

        //자동 타입 변환되어 있기 때문에 Bus 클래스의 오버라이딩 된 메소드가 아닌이상 사용할 수 없음
        //vehicle.checkFare(); (x)

        //사용을 원할 경우 강제 타입 변환
        Bus bus = (Bus) vehicle;

        bus.run();
        //사용 가능
        bus.checkFare();

        //instanceof 를 이용한 자동 타입 변환 확인
        Vehicle vehicle2 = new Bus();
        //vehicle2 의 타입이 Bus가 맞는가?
        if (vehicle2 instanceof Bus) {
            Bus bus2 =  (Bus) vehicle;
        }

    }
}
