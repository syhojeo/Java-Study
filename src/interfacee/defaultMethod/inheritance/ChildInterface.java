/*
    인터페이스의 상속에서 default 메소드를 상속받는 방법은 총 3가지이다

    1. default 메소드를 그대로 상속 받아 사용한다.
    2. default 메소드를 오버라이딩하여 사용한다.
    3. default 메소드를 추상 메소드로 재정의하여 사용한다.
 */
package interfacee.defaultMethod.inheritance;

// 1, 2, 3 번의 예시
public interface ChildInterface extends ParentInterface {
    // 1번의 경우 아무런 추가 소스코딩을 할 필요가 없다

/*
    // 2번 default 메소드 오버라이딩
    @Override
    default void defaultmethod() {
        System.out.println("ChildInterface의 Override된 default method");
    }
*/

    // 3번 default 메소드 추상 메소드로 재정의
    void defaultmethod();
}
