//key값 비교할 equals 메소드 오버라이딩
package basicApiClass.object.hashcode;

public class Key {
    public int number;

    public Key(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Key) {
            Key compareKey = (Key) obj;
            if (this.number == compareKey.number)
                return true;
        }
        return false;
    }

    //Object에서 정의된 hashCode를 새로 사용하려는 Key클래스에 맞게 맞춰줘야만 제대로된 리턴값의 사용이 가능하다
    @Override
    public int hashCode() {
        return number;
    }
}
