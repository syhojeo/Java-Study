package interfacee;

public interface InterfaceBasic {
    /*
        상수 필드
        인터페이스는 객체 사용 설명서이므로 런타임 시 데이터를 지정할 수 있는 필드를 선언할 수 없다.
        하지만 상수 필드는 선언이 가능하다
        상수만 사용할 수 있기 때문에 public static final 만 사용할 수 있으며 자동으로 생략되어 붙는다
     */

    //상수필드
    public static final int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;


    /*
        추상 메소드
        객체가 가지고 있는 메소드를 설명할 것으로 호출할 때 어떤 매개값이 필요하고, 리턴 타입이 무엇인지만 알려준다.
        추상 메소드는 public abstarct의 특성을 갖기 때문에 생략하더라도 자동적으로 컴파일과정에서 붙게 된다
     */

    //추상 메소드
    public abstract void turnOn();
    public abstract void turnOff();
    public void setVolume(int volume);


    /*
        디폴트 메소드
        인터페이스에 선언되지만 사실은 객체가 가지고 있는 인스턴스 메소드라고 생각해야한다. (구현 객체 생성이 되어있어야 사용가능)
        자바 8에서부터 허영되며 기존 인터페이스를 확장해서 새로운 기능을 추가하기 위해서이다.
        public만 접근 제한자로 사용 가능하고, 쓰지 않으면 기본적으로 public 이 생략되어 붙는다
     */

    //디폴트 메소드
    public default void setMute(boolean mute) {
        if (mute) {
            System.out.println("무음 처리합니다.");
        }
        else {
            System.out.println("무음 해제합니다.");
        }
    }


    /*
        정적 메소드
        정적메소드 또한 자바 8부터 작성할 수 있으며, 디폴트 메소드와는 달리 객체가 없어도 인터페이스만으로 호출이 가능
        public만 접근 제한자로 사용 가능하고, 쓰지 않으면 기본적으로 public 이 생략되어 붙는다
     */

    //정적 메소드
    public static void changeBattery() {
        System.out.println("건전지를 교환합니다.");
    }
}
