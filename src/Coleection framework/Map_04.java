/*
Map
key      | value
people   | 사람
baseball | 야구

위와같이 하나의 key값에 value 값이 대응하는 식의 자료형을 가지는것을 map이라한다
map 은 사람, 야구라는 value를 찾기 위해 자료의 모든값을 탐색할 필요없이 key값 하나만 통하여 찾아 낼 수 있다.

Map 에는 HashMap, LinkedHashMap, TreeMap 등이 있다
HashMap은 순서에 상관없지만 LinkedHashMap과 TreeMap은 데이터 입력 순서까지 고려해준다

 */

import java.util.HashMap;

public class Map_04 {
    public static void main(String[] args){
        //HashMap 객체 생성 , <String, String> => 제네릭스 사용
        HashMap<String, String> map = new HashMap<String, String>();

        //put - key값 value값 넣기
        map.put("people", "사람");
        map.put("baseball", "야구");

        //get - key값에 맞는 value 값 출력
        System.out.println(map.get("people"));

        //containskey - 해당 key값이 있는지를 조사하여 그 결과를 boolean 형으로 리턴
        System.out.println(map.containsKey("people")); //people 이 존재하므로 true를 리턴

        //remove - 해당 key값과 value값 모두 삭제한 후 value 값을 리턴
        System.out.println(map.remove("people")); //people 의 value 값인 "사람" 리턴

        //size - Map의 갯수를 리턴
        System.out.println(map.size()); //people,baseball 두가지 값을 가지고 있었으나 remove 에 의해 people 이 삭제되었기에
                                        //size 는 1이 출력될것이다.

    }
}
