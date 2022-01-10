//문자열 관련 메소드
package string;

public class String_Method_02 {
    //1. equals() 메소드 : 두문자열이 같은지 다른지 비교하여 true , false (boolean 자료형) 값을 리턴한다
    public static void equals(){
        String a = "hello";
        String b = "java";
        String c = "hello";

        System.out.println("\n\"equals Method\"");
        System.out.println(a.equals(b)); //false
        System.out.println(a.equals(c)); //true
        System.out.println(a.equals("hello")); //true
        System.out.println(("java").equals("hello")); //false
        System.out.println(("hello").equals("hello")); //true
    }
    //2. indexOf() - 문자열에서 특정 문자열을 찾아 문자의 인덱스(몇번쨰 단어인지)를 리턴한다
    public static void indexOf(){
        String a = "Hello java";

        System.out.println("\n\"indexOf Method\"");
        System.out.println(a.indexOf("java"));
    }
    //3. replaceAll() - 문자열 중 특정 문자열를 다른 문자열로 바꾸고 싶을 경우에 사용
    public static void replaceAll(){
        String a = "Hello java";

        System.out.println("\n\"replaceAll Method\"");
        System.out.println(a.replaceAll("java", "World")); // a의 문자열 java를 world로 변환 (a = "Hello World")
    }
    //4. substring() - 문자열 중 특정 부분을 추출 경우 사용 (index 번호로 추출 문자열 명시)
    public static void substring(){
        String a = "helloJava";

        System.out.println("\n\"substring Method\"");
        System.out.println(a.substring(0,4)); // a 문자열의 index 0~4(Hell)을 추출
                                                //0~4에서 숫자 4는 4까지(포함)가 아니라 4는 빼고(4미만)을 뜻함
                                                // 결과값: Hell (substring(0,4)라고 적었지만 배열원소상 0~3 까지만 추출한다)
        System.out.println(a);
    }
    //5. toUpperCase, toLowerCase - 문자열의 소문자를 대문자로 변환, 대문자를 소문자로 변환
    public static void to_Upper_Lower_case(){
        String a = "helloJava";

        System.out.println("\n\"toUpperCase, toLowercase Method\"");
        System.out.println(a.toUpperCase()); // HELLO JAVA
        System.out.println(a.toLowerCase()); // hello java
    }
    public static void main(String[] args){
        //클래스 객체 생성
        String_Method_02 string_method = new String_Method_02();

        equals();
        indexOf();
        replaceAll();
        substring();
        to_Upper_Lower_case();
    }
}
