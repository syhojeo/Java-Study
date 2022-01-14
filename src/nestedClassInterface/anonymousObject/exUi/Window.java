//인터페이스의 매개변수 다형성을 이용한 onclick 구현
package nestedClassInterface.anonymousObject.exUi;

import nestedClassInterface.anonymousObject.exUi.Button.OnClickListener;



public class Window {
    Button button1 = new Button();
    Button button2 = new Button();

    //필드 초기값으로 대입
    //매개변수에 필드값을 직접 넣어주기 위함
    Button.OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick() {
            System.out.println("전화를 켭니다");
        }
    };

    //생성자를 통해 각각의 버튼에 listener들을 초기화 해준다 (매개변수의 다형성을 이용한다)
    Window() {
        button1.setOnClickListener(listener);
        //button1 처럼 필드를 초기화하여 매개변수를 넣지않고 직접 익명객체를 이용하여 매개변수를 넣어준다
        button2.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick() {
                    System.out.println("메시지를 보냅니다.");
                }
            }
        );
    }
}
