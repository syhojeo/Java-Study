/*
    싱글톤
    두개 이상의 객체 생성을 원하지 않는 객체를 사용하고 싶을 때 사용한다
    private 접근지정자를 이용하여 접근을 제한하는 singleton 객체를 생성하고
    getInstance()와 같은 메소드를 만들어 객체에 접근 할 수 있도록 한다

    실체 객체 생성은 heap 에 되지만
    static 참조 변수로 이 주소를 받아와 다른 메소드들에 제공한다.
 */

public class Singleton {
    //정적 필드를 통해 객체 생성된 Sington 메모리의 주소를 받아온다
    private static Singleton singleton =  new Singleton();

    //생성자
    private Singleton() {

    }

    //heap 메모리의 주소를 받아온 참조변수(stack에 저장되어 있음)을 리턴하여
    //getInstance 함수를 이용하여 Singleton 객체에 접근 할 수 있도록 한다.
    static Singleton getInstance() {
        return singleton;
    }
}
