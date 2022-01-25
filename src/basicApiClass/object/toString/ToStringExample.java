/*
    toString()
    객체의 문자 정보를 리턴한다(객체를 문자열로 표현한 값)
    "클래스명@16진수해시코드"
 */
package basicApiClass.object.toString;

import java.util.Date;

public class ToStringExample {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Date obj2 = new Date();
        //Object 객체의 클래스명@16진수해시코드 를 리턴
        System.out.println(obj1.toString());
        //오버라이드된 Date 의 객체 정보를 리턴한다 (오늘의 날짜 시간 등)
        System.out.println(obj2.toString());
    }
}
