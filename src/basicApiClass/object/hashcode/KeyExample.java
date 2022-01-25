package basicApiClass.object.hashcode;

import java.util.HashMap;

public class KeyExample {

    public static void main(String[] args) {
        //Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성
        HashMap<Key, String> hashMap = new HashMap<Key, String>();

        //식별키 "new Key(1)" 로 "홍길동"을 저장함
        hashMap.put(new Key(1), "홍길동");

        //식별키 "new Key(1)" 로 "홍길동"을 읽어옴
        //hashMap.get으로는 같은 객체의 키값을 넣어줘야 value 값이 리턴된다
        String value = hashMap.get(new Key(1));
        System.out.println(value);

        HashMap<Member, String> hashMap2 = new HashMap<Member, String>();
        hashMap2.put(new Member("1"), "1");

/*
        //hash code를 오버라이딩 통해 hashcode() 메소드가 각각의 객체에 대해 값을 리턴하는게 아닌
        //생성자의 매개변수에 따라서 hashcode를 리턴해주도록 오버라이딩 해줘야한다

        Member m1 = new Member("1");
        Member m2 = new Member("1");


        //오버라이딩을 통해 Stirng "1" 의 해쉬코드값으로 모두 리턴된다
        System.out.println(m1.hashCode());
        System.out.println(m2.hashCode());
        String a = "1";
        System.out.println(a.hashCode()); //위의 해쉬코드값과 같다
*/
    }
}
