package collectionFramework.map.hashMap;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
    TreeMap은 key값 기준으로 자동정렬을 해줄 수 있지만 key값이 아닌 value값 기준으로 정렬을 해주고 싶다면
    HashMap을 사용하고, ArrayList의 정렬을 이용해야 HashMap의 value값 기준 정렬이 가능하다
 */

public class CollectionsSort {

    public static void main(String[] args) {
        Map<String, Integer> testMap = new HashMap<String, Integer>();

        //Map에 데이터 추가
        testMap.put("apple", 1);
        testMap.put("orange", 2);
        testMap.put("pineapple", 4);
        testMap.put("strawberry", 5);
        testMap.put("melon", 3);

        //Map.Entry 리스트 작성
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(testMap.entrySet());

        //비교함수 Comparator를 사용하여 오름차순으로 정렬
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                //오름 차순 정렬
                //return obj1.getValue().compareTo(obj2.getValue());
                //내림 차순 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        //결과 출력
        System.out.println("오름 차순 정렬");
        for (Entry<String, Integer> entry : list_entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
