//try - catch를 이용한 사용자 정의 에러 발생 및 처리
package exception;

public class LoginExample {

    public static void main(String[] args) {
        //NotExistIdException 발생
        try {
            login("white", "12345");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        //WrongPasswordException 발생
        try {
            login("blue", "54321");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //login메소드에서 NotExistIDException과 WrongPasswordException 이 발생했을때
    // 이것에 대한 예외처리를 login 메소드를 호출한 곳에서 처리하도록 한다 (throws 설정)
    public static void login(String id, String password) throws NotExistIDException, WrongPasswordException{
                                                            //thorws Exception으로 한번에 떠넘기기도 가능
        //id가 "blue"가 아니라면 NotExistIDException 발생시킴
        if (!id.equals("blue")) {
            //예외 객체를 생성하여 예외를 발생시킴
            //String형 message를 생성자에 넣어줌으로써 Exception 클래스의 getMessage 메소드를 사용하여
            //에러 메세지를 출력할 수 있도록 해준다
            throw new NotExistIDException("아이디가 존재하지 않습니다.");
        }

        //password가 "12345"가 아니라면 WrongPasswordException 발생시킴
        if (!password.equals("12345")) {
            //예외 객체를 생성하여 예외를 발생시킴
            //String형 message를 생성자에 넣어줌으로써 Exception 클래스의 getMessage 메소드를 사용하여
            //에러 메세지를 출력할 수 있도록 해준다
            throw new WrongPasswordException("패스워드가 틀립니다.");
        }
    }
}