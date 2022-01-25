//객체 비교
//Object 객체를 이용한 객체 비교 방법
package basicApiClass.object.equalsMethod;

//Member 클래스의 override 메소드 equals를 사용하여 id 값 비교하기
//step1. 비교를 위해서 자동 타입 변환해 들어온 객체 obj가 같은 Member클래스인지를 확인한다
//step2. 자동타입변환으로 인해 Member클래스의 필드값에 접근할 수 없기 때문에 강제 타입 변환을 해준다
//step3. Member 클래스의 필드값에 접근하여 두값을 비교한다
public class Member {
    public String id;

    public Member(String id) {
        this.id = id;
    }

    //object의 equals 메소드를 오버라이딩 하여 사용한다
    @Override
    //매개변수를 Object 타입으로 만듦으로써 모든 객체의 자동 타입 변환이 적용 될 수 있도록 한다
    public boolean equals(Object obj) {
        //Member로의 강제 타입변환을 하기 위해  instanceof를 사용하여 obj가 Member 타입인지를 확인한다
        if (obj instanceof Member) {
            //강제 타입변환을 사용하여 Member 클래스의 필드값에 접근할 수 있도록한다
            Member member = (Member) obj;
            //필드값을 비교하여 두 id의 값이 같은지 확인한다
            if (id.equals(member.id)) {
                return true;
            }
        }
        return false;
    }
}
