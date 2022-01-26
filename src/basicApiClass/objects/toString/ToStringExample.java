/*
    객체를 문자열로 설명해주는 메소드 toString
    Objects의 toString은 null을 다룰 경우 null을 리턴하거나 두번째 매개값인 nullDefault를 리턴한다
 */
package basicApiClass.objects.toString;

import java.util.Objects;

public class ToStringExample {

    public static void main(String[] args) {
        String str1 = "홍길동";
        String str2 = null;

        System.out.println(Objects.toString(str1));
        System.out.println(Objects.toString(str2));
        System.out.println(Objects.toString(str2, "이름이 없습니다."));
    }
}