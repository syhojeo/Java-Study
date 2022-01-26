package basicApiClass.string.stringConstructor;

public class ByteToStringExample {

    public static void main(String[] args) {
        byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97};

        //byte형 배열을 문자열로 변환하는 String 생성자 사용
        String str1 = new String(bytes);
        //문자열로 출력
        System.out.println(str1);

        //byte형 배열의 offset(시작위치)와 offset으로 부터의 길이를 설정해 특정 byte배열의 요소만 변환
        //ex) offset: 6,  length: 4 => bytes[6] 원소 ~ 4글자 를 변환
        String str2 = new String(bytes, 6, 4);
        System.out.println(str2);;
    }
}
