/*
    메소드 오버라이딩을 확인하기 위한 자식 객체
    자식 객체에서 메소드 오버라이딩을 통해 접근 제한을 약하게 조정할 수 있다
    ex) 부모가 default 라면, 오버라이딩을 통해 public으로 접근 제한자를 변경 할 수 있다.
 */
package inheritance.methodOverride;

public class MethodOverrideChild extends MethodOverrideParents {
    //오버라이딩되는 자식 객체의 메소드
    @Override
    double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }

    //만약 자식 메소드에서 오버라이딩 되지 않은 부모 메소드를 사용하고 싶을경우 (super.methodName) 사용
    double notOverride(double r) {
        //super.methodName(); super를 이용하여 오버라이딩 되지 않은 메소드를 사용할 수 있다.
        return super.areaCircle(r);
    }
}
