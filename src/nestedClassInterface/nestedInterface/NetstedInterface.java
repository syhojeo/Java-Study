//중첩 인터페이스
//따로 사용제한은 없다. 인터페이스는 실제로 뭘 만들 목적으로 사용하는것이 아니기 때문

package nestedClassInterface.nestedInterface;

public class NetstedInterface {
    OnClickListener listener;

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
