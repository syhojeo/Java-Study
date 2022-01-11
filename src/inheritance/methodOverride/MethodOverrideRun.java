/*
    부모 객체의 메소드와 상속받은 객체의 생성, 실행을 통해 오버라이딩된 메소드의 차이점 확인
 */

package inheritance.methodOverride;

public class MethodOverrideRun {

    public static void main(String[] args) {
        int r = 10;

        //사용하려던 객체 생성
        MethodOverrideParents methodOverrideParents = new MethodOverrideParents();
        System.out.println("원 면적: " + methodOverrideParents.areaCircle(r));

        //메소드 오브라이딩(재정의) 된 상속 자식 객체 생성
        MethodOverrideChild methodOverrideChild = new MethodOverrideChild();
        System.out.println("원면적: " + methodOverrideChild.areaCircle(r));
    }
}
