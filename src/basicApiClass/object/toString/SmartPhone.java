//스마트폰의 제조회사 정보와, os정보를 가지는 클래스 객체
package basicApiClass.object.toString;

public class SmartPhone {
    private String company;
    private String os;

    public SmartPhone(String company, String os) {
        this.company = company;
        this.os = os;
    }

    //toString을 유용하게 사용할 수 있도록 오버라이딩
    //toString 메소드의 의미인 객체의 정보를 문자열로 리턴할 수 있도록 오버라이딩
    @Override
    public String toString() {
        return company + ", " + os;
    }
}