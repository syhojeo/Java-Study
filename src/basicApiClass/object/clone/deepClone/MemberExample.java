package basicApiClass.object.clone.deepClone;

public class MemberExample {

    public static void main(String[] args) {
        //원본 객체 생성
        Member original = new Member("홍길동", 25, new int[] {90, 90}, new Car("소나타"));

        //복제 객체를 얻은 후에 참조 객체의 값을 변경
        //deep clone
        Member cloned = original.getMember();
        //deep clone 이후 참조객체의 데이터를 변경
        cloned.scores[0] = 100;
        cloned.car.model = "그랜저";

        System.out.println("원본 객체의 값");
        System.out.println("scores[0]" + original.scores[0]);
        System.out.println("car.model" + original.car.model +"\n");

        System.out.println("deep clone된 객체의 변경된 값");
        System.out.println("scores[0]" + cloned.scores[0]);
        System.out.println("car.model" + cloned.car.model);
    }
}
