/*
    requireNonNUll의 경우 매개변수에 따라 3가지의 오버로드를 가진다

    첫번재 매개값이 null이 아니라면 첫 번째 매개값을 리턴
    null이라면 NullPointerException을 발생

    두번째 매개값은 NullPointerException 의 예외 메시지를 제공한다

 */
package basicApiClass.objects.requireNonNull;

import java.util.Objects;

public class NullExample {

    public static void main(String[] args) {
        String str1 = "홍길동";
        String str2 = null;

        System.out.println(Objects.requireNonNull(str1));

        //첫번째 매개값이 null 이므로 NullPointerException 발생
        try {
            String name = Objects.requireNonNull(str2);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        //첫번째 매개값이 null 이므로 NullPointerException 발생, 예외 메시지 설정
        try {
            String name = Objects.requireNonNull(str2, "이름이 없습니다");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        //두번째 매개값으로 Supplier 구현객체가 올 수 있는데 Supplier 구현 객체로 람다식이 대입되었다
        try {
            String name = Objects.requireNonNull(str2, ()->"이름이 없다니깐요");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}