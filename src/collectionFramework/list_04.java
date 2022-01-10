/*
배열과 리스트, 제네릭스

배열 선언방법
String[] weeks = {"월, 화, 수"};
String[] weeks = new String[3];
배열 사용
System.out.println(weeks([2]);

List
리스트는 배열과 비슷한 자료형이지만 배열은 크기가 정해져 있고, 리스트는 동적으로 변한다

 */

package collectionFramework;

//list 를 사용하기 위한 라이브러리
import java.util.ArrayList;

public class list_04 {
    public static void main(String[] args){
        //리스트 객체 생성
        ArrayList pitches = new ArrayList();

        //add : 배열에 값 추가
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");
        pitches.add(0, "134"); // 0번째 인덱스 138 -> 134 로 변경

        //get : 배열의 인덱스에 접근하여 값을 리턴
        System.out.println(pitches.get(1)); // 1번째 인덱스 129 리턴하여 출력

        //size : Arryalist 의 갯수를 리턴
        System.out.println(pitches.size()); // 리스트의 원소 개수 3 출력

        //contains : 리스트 안에 해당 항목이 있는지를 탐색하여 결과를 boolean 자료형으로 리턴
        System.out.println(pitches.contains("142")); // 인덱스 2의 값이 142 이므로 true 출력

        /*
        remove
        1. remove(객체) 의 경우 객체에 해당되는 항목을 삭제하고, 삭제가 됐으면 true 안됐으면 false 리턴
        2. remove(인덱스) 의 경우 인덱스에 해당하는 항목을 삭제하고, 인덱스 값을 리턴
         */
        System.out.println(pitches.remove("129")); // 1번 인덱스에 129가 존재하므로 129를 삭제하고 true 리턴
        System.out.println(pitches.remove(2)); // 3번째 인덱스를 삭제하고 3번째 인덱스의 값 142 출력
    }
}

/*
제네릭스 (Generics)
제네릭스 객체 생성 예
ArrayList<String> aList = new ArrayList<String>();
위와 같이 리스트를 생성하는데 사용하는 자료형을 명시해주는 것을 제네릭스라고 한다

장점
1. 불필요한 형변환을 줄여 코드의 간결함을 높인다
일반적인 리스트는 add를 통해 저장할때 object(모든 객체가 상속하고 있는 자료형) 자료형으로 저장되기 때문에 저장할때는 문제가 없지만
이것을 get을 통해 다른 자료형에 사용할 경우 이를 맞춰주는 형변환이 필요하다

ex)제네릭스를 안쓴경우
ArrayList pitches = new ArrayList();
String Hello = pitches.get() (X) -> String 자료형변수 Hello 에 object 자료형 pitches.get(1) 을 사용
String Hello = <String>pitches.get() (O)
---------------------------------------------------------
ex)제네릭스를 쓴경우
ArrayList<String> pitches = new Arraylist<String>();
String Hello = pitches.get(); (O)


2. 타입의 안전성
의도하지 않은 타입의 객체가 저장되는 것을 막고, 다른 타입의 객체로 인한 타입의 형태가 맞지 않아 발생하는 문제를 없애준다.
 */

/*
object 자료형 - 모든 자료형의 조상이며 모든 자료형은 object자료형에서 파생되어 상속하고 있다. 떄문에 object가 가지고 있는 기능들은
모든 값형과 참조형이 물려받아 가지고 있다
때문에 object의 특징은 어떤 값이든 저장할 수 있다
하지만 object형 끼리의 연산은 허용되지 않는다
*/