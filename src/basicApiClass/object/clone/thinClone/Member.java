package basicApiClass.object.clone.thinClone;

//Cloneable 인터페이스를 구현함으로서 복제가능하다는 클래스임을 명시해준다
//Cloneable 인터페이스는 텅비어 있는 인터페이스이므로 따로 무엇인가를 구현할 필요는 없다 (커서올리고 F4눌러보기)
public class Member implements Cloneable{
    public String id;
    public String name;
    public String password;
    public int age;
    public boolean adult;

    public Member(String id, String name, String password, int age, boolean adult) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.adult = adult;
    }

    //객체를 얇은 복제하는 메소드
    public Member getMember() {
        Member cloned = null;
        try {
            //clone() 메소드의 리턴타입은 Object 타입이므로 반드시 Member타입으로 캐스팅 해야한다
            cloned = (Member) clone();
        }
        catch (CloneNotSupportedException e) {}
        return cloned;
    }
}
