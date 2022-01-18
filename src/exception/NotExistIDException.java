//사용자 정의 에러 정의
package exception;

//존재하지 않는 ID를 입력했을 경우 발생하는 예외처리
public class NotExistIDException extends Exception{
    public NotExistIDException() {}
    //부모 클래스 Exception에 예외처리 메시지를 보내는 생성자
    public NotExistIDException(String message) {super(message);}
}
