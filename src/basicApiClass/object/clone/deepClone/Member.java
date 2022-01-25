package basicApiClass.object.clone.deepClone;

import java.util.Arrays;

public class Member implements Cloneable {
    public String name;
    public int age;
    //참조 타입 필드 ( 깊은 복제 대상)
    public int[] scores;
    public Car car;

    public Member(String name, int age, int[] scores, Car car) {
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.car = car;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //먼저 얕은 복사를 해서 name, age를 복사한다
        Member cloned = (Member) super.clone();
        
        //깊은 복제는 필드값 하나하나 직접 객체를 만들어 넣어줘야한다
        //scores를 깊은 복제한다
        cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
        //car를 깊은 복제한다
        cloned.car = new Car(this.car.model);
        //깊은 복제된 Member 객체를 리턴
        return cloned;
    }

    public Member getMember() {
        Member cloned = null;
        try {
            cloned = (Member) clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloned;
    }
}
