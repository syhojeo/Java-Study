//hello world.java 파일은 하나지만 여러개의 클래스를 만들 수 있다.
//클래스명과 파일명이 동일할 경우 해당 클래스에 public 을 붙여주어야 한다.
package helloJava;

public class HelloWorld_00 {
    public static void main(String[] args){
        System.out.println("Hello World");
    }
}

/*
    public: 메소드의 접근제어자 (누구나 이 메소드에 접근 가능하다는 의미)
    static: 메소드에 static이 지정되어 있는 경우 이 메소드는 인스턴스 생성없이 실행 할 수 있다는 의미
    void: 메소드의 리턴값이 없음
    String[]: []가 있기 때문에 한개가 아닌 여러개의 값으로 이루어진 배열
    args: String[]에 대한 변수명
    System.out.println: 표준출력하는 자바의 내장메소드

자바 소스코드 구조

클래스 블록
public class 클래스명 {

    메소드 블록
    [public|private|protected] [static] (리턴자료형|void) 메소드명1(입력자료형 입력변수, ...) {
        명령문(statement);
        ...
    }

    메소드 블록
    [public|private|protected] [static] (리턴자료형|void) 메소드명2(입력자료형 입력변수, ...) {
        명령문(statement);
        ...
    }

    ...
}
*/