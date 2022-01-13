package interfacee;


public class InterfaceBasicMain {

    public static void main(String[] args) {
        //정적 메소드의 경우 구현객체를 생성하지 않아도 사용가능하다.
        InterfaceBasic.changeBattery();

        //일반적인 인터페이스 구현객체 사용법 
        //타입을 InterfaceBasic으로 했고, 자동타입변환을 받았기 때문에 InterfaceBasicClass의 추가 메소드는 사용 불가하다
        InterfaceBasic ib;
        ib = new InterfaceBasicClass();

        //인터페이스 타입으로 선언하지 않고, 바로 클래스 타입으로 선언
        InterfaceBasicClass ibc = new InterfaceBasicClass();



        //ib vs ibc

        //ib
        //test는 InterfaceBasicClass에 추가로 만든 메소드 이므로 InterfaceBasic으로 자동타입변환해서 만든
        //ib 변수의 경우 test 메소드 사용이 불가능하다
        //ib.test();


        //ibc
        //InterfaceBasicClass로 타입을 선언했기 때문에 InterfaceBasicClass 내의 모든 메소드 사용가능
        ibc.test();
        //InterfaceBasic 에 구현한 디폴트 메소드도 사용이 가능하다
        ibc.setMute(true);


        /*
            익명 구현 객체
            구현클래스를 작성하지 않고, 일회성의 구현객체를 만들어 사용할 수 있다.
            모든 추상 메소드들의 실체 메소드를 작성해야한다.
            UI프로그래밍의 이벤트 처리, 임시 작업 스레드를 만들기 위해 활용된다.

        InterfaceBasic ib = new InterfaceBasic() {
            private int volume;

            @Override
            public void turnOn() {
                System.out.println("TV를 킨다");
            }

            @Override
            public void turnOff() {
                System.out.println("TV를 끈다");
            }

            @Override
            public void setVolume(int volume) {
                if (volume > InterfaceBasic.MAX_VOLUME) {
                    this.volume = MAX_VOLUME;
                } else if (volume < InterfaceBasic.MIN_VOLUME) {
                    this.volume = MIN_VOLUME;
                } else {
                    this.volume = volume;
                }
                System.out.println("volume: " + this.volume);
            }
        };
        //위의 ; 기억할것!!
        */

        //실체 메소드
        ib.turnOn();
        ib.turnOff();
        ib.setVolume(1000000000);

        //디폴트 메소드는 구현 클래스 내부에서 실체 메소드를 만들지 않아도 사용가능하다
        ib.setMute(true);

    }
}
