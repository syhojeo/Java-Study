package nestedClassInterface.anonymousObject.anonymousObjectBasicInterface;

public class Anonymous {
    //필드 초기값으로 대입
    RemoteControl field = new RemoteControl() {
        @Override
        public void turnOn(){
            System.out.println("TV를 켭니다");
        }
        public void turnOff(){
            System.out.println("TV를 끕니다");
        }
    };

    void method1() {
        //로컬 변수값으로 대입
        RemoteControl localVar = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("Audio를 켭니다");
            }

            @Override
            public void turnOff() {
                System.out.println("Audio를 끕니다");
            }
        };
        //로컬 변수 사용
        localVar.turnOn();
        localVar.turnOff();
    }
    
    //매개변수 다형화를 위한 인터페이스형 타입선언
    //익명 객체를 매개변수로 넣어주기 위한 세팅
    void method2(RemoteControl rc) {
        rc.turnOn();
    }
}
