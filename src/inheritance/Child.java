/*
    상속의 자식 클래스
 */

package inheritance;

//상속을 위한 extends Parents 추가
public class Child extends Parents{
    //필드
    int channel;

    //생성자
    Child(String model, String color, int channel) {
        //부모 생성자는 적어주지 않으면 생략되어 호출되며, 항상 자식생성자 첫줄에 존재한다.
        //만약 부모클래스의 생성자가 매개값을 가지고 있다면, 자식클래스에서 매개값을 넣어서 부모 생성자를 호출해야 한다.
        super(model); //부모생성자 호출

        this.model = model; //상속받은 필드
        this.color = color; //상속받은 필드
        this.channel = channel;
    }

    //메소드
    void TrunOnDmb() {
        System.out.println("채널 " + channel + "번 DMB 방송 수신을 시작합니다.");
    }

    public static void main(String[] args) {
        //child 객체 생성
        Child child =  new Child("자바폰", "검정", 10);
        child.TrunOnDmb(); //자식 내부 메소드
        child.powerOn(); //부모에게 상속 받은 메소드
    }
}