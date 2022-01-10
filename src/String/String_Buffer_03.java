/*
    StringBuffer -  문자열을 추가하거나 변경할 때 사용하는 자료형

    StringBuffer와 비슷한 자료형으로 StringBuilder가 있으며 사용법은 동일하다
    다만 StringBuffer는 멀티 스레드 환경에서 안전하다는 장점이 있고, StringBuilder는 성능이 우수한 장점이 있다
    때문에 동기화를 고려할 필요가 없는 상황에서는 StringBuilder를 사용하는것이 바람직하다
*/

public class String_Buffer_03 {
    //append - 문자열 추가하기
    public static void append(){
        System.out.println("\n\"StringBuffer_append\"");
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("jump to java");
        System.out.println(sb.toString()); //StringBuffer 자료형을 string 자료형으로 변환 후 출력
                                            //hello jump to java

        /*
        StringBuffer를 사용하지 않고 String 자료형만 사용하는 경우
        String temp = "";
        temp += "hello;
        temp += " ";
        temp += "jump to java";
        Systemp.out.println(temp);

        둘의 차이점은 StringBuffer 이용하여 문자열을 수정할 경우 객체가 한번만 생성되지만
        temp 에 String 자료형을 더할경우 더할때 마다 새로운 객체가 만들어지게 된다
        또한 이러한 String 자료형은 한번 값이 생성되면 그값을 변경할 수 없다

        하지만 String 자료형보다 StringBuffer 자료형이 무겁기 때문에 StringBuffer로 객체를 생성하는 경우
        일반 String을 사용하는 것보다 메모리 사용량도 많고 속도도 느리다
        때문에 문자열 추가나 변경등의 작업이 많을 경우에는 StringBuffer를,
        문자열 변경 작업이 거의 없는 경우에는 String 자료형을 사용하는것이 바람직하다
         */

    }
    //insert - 원하는 위치에 문자열 추가하기
    public static void insert(){
        StringBuffer sb = new StringBuffer();
        sb.append("jump to java");
        sb.insert(0, "Hello ");
        System.out.println("\n\"StringBuffer_insert\"");
        System.out.println(sb.toString()); //결과값: Hello jump to java
    }
    //substring - String 자료형의 substring과 동일하게 사용되며 특정 인덱스의 문자열을 추출한다
    public static void substring(){
        StringBuffer sb = new StringBuffer();
        sb.append("Hello jump to java");
        System.out.println("\n\"StringBuffer_substring\"");
        System.out.println(sb.substring(0, 4)); // 0~4 index 인 Hell 을 추출한 후 출력
                                                // 결과값: Hell
    }
    public static void main(String[] args) {
        append();
        insert();
        substring();
    }
}