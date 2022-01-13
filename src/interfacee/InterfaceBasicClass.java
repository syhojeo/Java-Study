package interfacee;

//다중 인터페이스 구현 (InterfaceBasic, MultipleInterface)
public class InterfaceBasicClass implements InterfaceBasic, MultipleInterface {
    //InterfaceBasic 인터페이스에 선언된 추상 메소드의 실체 메소드 선언
    //필드
    private int volume;

    //추상 메소드의 실체 메소드
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }

    public void setVolume(int volume) {
        if (volume > InterfaceBasic.MAX_VOLUME) {
            this.volume = InterfaceBasic.MAX_VOLUME;
        }
        else if (volume < InterfaceBasic.MIN_VOLUME) {
            this.volume = InterfaceBasic.MIN_VOLUME;
        }
        else {
            this.volume = volume;
        }
        System.out.println("현재 Audio 볼륨: " + this.volume);
    }


    //MultipleInterface의 실체 메소드
    public void search(String url) {
        System.out.println(url + "을 검색합니다.");
    }

    public void test() {
        System.out.println("테스트");
    }
}
