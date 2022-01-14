//주로 익명 객체는 UI 프로그래밍에서 많이 사용되는데 그 사용 예시에 대해서 구현한다
package nestedClassInterface.anonymousObject.exUi;

/*
    setOnClickListener를 통해 어떤 리스너(OnClickListener 인터페이스)인지 받아오고
    touch 를 통해 동작(OnClickListener.onClick)을 수행한다.
 */
public class Button {
    OnClickListener listener; //인터페이스 타입 필드

    void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    void touch() {
        listener.onClick();
    }

    interface OnClickListener {
        void onClick();
    }
}
