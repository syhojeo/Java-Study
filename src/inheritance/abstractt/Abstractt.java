/*
    추상클래스
    객체 생성은 할 수 없고, 오로지 자식에게 상속만을 하기 위한 클래스

    추상클래스의 목적
    1. 실체 클래스의 공통된 필드와 메소드의 이름을 통일할 목적
    - 여러객체간, 프로그래머간의 혼선을 만들지 않기 위해 추상클래스를 사용하므로써 필드, 메소드명을 통일하는 목적으로
    사용한다.

    2. 실체 클래스를 작성할 때 시간을 절약
    실체 클래스를 설계 할때마다 사용하는 클래스의 필드, 메소드를 소스코딩할 필요가 없기 때문에 추상클래스로 부터
    상속받은 자원을 재사용하여 쓸데없이 코딩하는 시간을 절약할 수 있도록 도와준다
 */
package inheritance.abstractt;

import javax.swing.Popup;

//추상클래스 선언 방법
abstract class Phone {
    //필드
    public String owner;

    //생성자
    public Phone(String owner) {
        this.owner = owner;
    }

    //메소드
    public void turnOn() {
        System.out.println("폰 전원을 켭니다.");
    }
}

class SmartPhone extends Phone {
    //생성자
    public SmartPhone(String owner) {
        super(owner);
    }

    //메소드
    public void internetSearch() {
        System.out.println("인터넷 검색을 한다");
    }
}

public class Abstractt {

    public static void main(String[] args) {
        SmartPhone smartPhone =  new SmartPhone("홍길동");
        System.out.println(smartPhone.owner); //추상 클래스로부터 상속받은 필드 사용가능
        smartPhone.internetSearch();
        smartPhone.turnOn();

        //Phone phone = new Phone("둘리"); 추상 클래스의 경우 객체를 생성할 수 없다
    }
}
