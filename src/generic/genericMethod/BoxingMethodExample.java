package generic.genericMethod;

import generic.genericType.Box;

public class BoxingMethodExample {
    public static void main(String[] args) {
        Box<Integer> box1 = Util.<Integer>boxing(100);
        int intValue = box1.get();

        Box<String> box2 = Util.boxing("홍길동");
        String strValue = box2.get();

        Pair<Integer, String> p1 = new Pair<Integer, String> (1, "사과");
        Pair<Integer, String> p2 = new Pair<Integer, String>(1, "사과");
        //구체적 타입 명시 지정
        boolean result1 = Util.<Integer, String>compare(p1, p2);

        if (result1) {
            System.out.println("논리적으로 동등한 객체입니다.");
        }
        else {
            System.out.println("논리적으로 동등하지 않는 객체입니다.");
        }

        Pair<String, String> p3 = new Pair<String, String>("user1", "홍길동");
        Pair<String, String> p4 = new Pair<String, String>("user2", "홍길동");
        //매개값을 보고 구체적 타입을 추정 (일반적으로 사용)
        boolean result2 = Util.compare(p3, p4);
    }
}
