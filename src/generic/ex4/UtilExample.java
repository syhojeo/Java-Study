package generic.ex4;

public class UtilExample {

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("홍길동", 35);
        Integer age = Util.getValue(pair, "홍길동");
        System.out.println(age);

        ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
        Integer childAge = Util.getValue(childPair, "홍삼순");
        System.out.println(childAge);
/*
        OtherPair<String, Integer> otherPair =  new OtherPair<>("홍삼원", 20);
        //getValue 의 매개변수로 Pair 타입이 사용되었고, otherPair는 Pair 혹은 Pair를 상속하지 않은
        //타입이기 때문에 에러가 발생한다
        int otherAge = Util.getValue(otherPair, "홍삼원");
        System.out.println(otherAge);*/
    }
}