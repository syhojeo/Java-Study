package inheritance.autoTransform.autoTransfromMethod;

public class Drive {
    void start (Vehicle vehicle) { //자식클래스를 매개변수로 대입시 자식클래스로의 자동형변환이 일어나게 된다.
        vehicle.run();
    }
}
