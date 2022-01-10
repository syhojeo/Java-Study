//구구단 만들기 (메소드와 객체 생성)

public class GuGu_01 {
    public static void dan(int n){
        /*
        System.out.println(n*1);
        System.out.println(n*2);
        System.out.println(n*3);
        System.out.println(n*4);
        System.out.println(n*5);
        System.out.println(n*6);
        System.out.println(n*7);
        System.out.println(n*8);
        System.out.println(n*9);
         */
        for (int i = 1; i < 10; i++){
            System.out.println(n * i);
        }
    }
    public static void main(String[] args){
        int n = 3;

        dan(n);
    }
}

/*
public void vs public static void 차이
dan 메소드를 선언할때

1. public void 로 선언한다면 (위 함수와 같이)
main 문에서 dan 을 호출할때 gugu.dan(n)식으로 gugu 라는 클래스에서 참조하는 메소드 dan이라고 명시하여 사용해야한다

2. public static void 로 선언된다면
main 문에서 dan 을 호출할때 dan(n)식으로 클래스를 명시할 필요가 없이 간단하게 호출할 수 있다.

static 의 경우 정적 함수를 만드는 키워드로써 정적 변수, 정적 함수의 경우 현재 파일 내부에서만 사용가능하기 때문에 따로 클래스를
명시해줄 필요가 없게 되므로 간단하게 gugu.dan()이 아닌 dan()으로 dan메소드를 호출할 수 있다.
 */

/*
객체 생성

GuGu 클래스의 객체는 다음과 같이 생성된다

GuGu gugu = new GuGu();

GuGu 클래스 자료형을 갖는 변수 gugu에 new라는 키워드를 이용하여 GuGu 클래스 객채를 만들어 저장이 된다
=> gugu라는 변수에 GuGu 클래스 객체를 저장한다
*/