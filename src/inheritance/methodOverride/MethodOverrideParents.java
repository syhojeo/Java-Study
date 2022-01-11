//메소드 오버라이딩을 확인하기 위한 부모 객체
package inheritance.methodOverride;

public class MethodOverrideParents {
    //오버라이딩 될 부모 객체의 메소드
    double areaCircle(double r) {
        System.out.println("Calculator 객체의 areaCircle() 실행");
        return 3.14159 *r *r;
    }
}