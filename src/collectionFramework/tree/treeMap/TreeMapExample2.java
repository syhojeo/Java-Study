//TreeMap의 정렬 메소드
package collectionFramework.tree.treeMap;

import java.util.Map;

import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample2 {

    public static void main(String[] args) {
        TreeMap<Integer, String> scores = new TreeMap<Integer, String>();
        scores.put(new Integer(87), "홍길동");
        scores.put(new Integer(98), "이동수");
        scores.put(new Integer(75), "박길순");
        scores.put(new Integer(95), "신용권");
        scores.put(new Integer(80), "김자바");

        //TreeMap.descendingMap() 을 사용하면 Key값이 내림차순으로 정렬되어 NavigableMap 타입으로 리턴한다
        NavigableMap<Integer, String> descendingMap = scores.descendingMap();
        //정렬된 상태의 entrySet을 받아온다
        Set<Map.Entry<Integer, String>> descendingEntrySet = descendingMap.entrySet();
        //정렬된 상태의 entrySet을 루핑한다
        for (Map.Entry<Integer, String> entry : descendingEntrySet) {
            System.out.println(entry.getKey() + "-" + entry.getValue() + " ");
        }
        System.out.println();
        
        //descendingMap을 한번더 사용함으로써 오름차순 정렬
        NavigableMap<Integer, String> ascendingMap = descendingMap.descendingMap();
        Set<Map.Entry<Integer, String>> ascendingEntrySet = ascendingMap.entrySet();
        for (Map.Entry<Integer, String> entry : ascendingEntrySet) {
            System.out.println(entry.getKey() + "-" + entry.getValue() + " ");
        }
    }
}
