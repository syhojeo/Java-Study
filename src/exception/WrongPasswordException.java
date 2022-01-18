//사용자 정의 에러 정의
package exception;

//잘못된 비밀번호를 입력했을때 발생하는 예외처리
public class WrongPasswordException extends Exception{
    public WrongPasswordException(){}
    //부모 클래스 Exception에 예외처리 메시지를 보내는 생성자
    public WrongPasswordException(String message) {super(message);}
}
