//연습 문제 HashMap 사용하기
package collectionFramework.ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Ex09 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("blue", 96);
        map.put("hong", 86);
        map.put("white", 92);

        String name = null; //최고 점수를 받은 아이디 저장
        int maxScore = 0; //최고 점수 저장
        int totalScore = 0; //점수 합계 저장

        //Iterator로 돌기
        //Step1. Iterator 를 사용하기 위해 Set 을 만들어야된다
        Set<Map.Entry<String, Integer>> entryset = map.entrySet();
        //Step2. Set.Iterator() 를 사용하여 Iterator를 만든다
        Iterator<Map.Entry<String, Integer>> iterator = entryset.iterator();
        //Step3. Iterator 를 사용하여 합계를 구한다
        while (iterator.hasNext()) {
            //Step4. Iterator.next() 를 이용하여 하나씩 읽어오기위한 변수 Map.Entry 타입 선언
            Map.Entry<String, Integer> entry = iterator.next();
            //Step5. Map.Entry.getValue().  Map.Entry.getKey()를 이용하기
            totalScore += entry.getValue();
            if (maxScore < entry.getValue()) {
                maxScore = entry.getValue();
                name = entry.getKey();
            }
        }
        System.out.println("평균점수: " + (totalScore / entryset.size()));
        System.out.println("최고점수: " + maxScore);
        System.out.println("최고점수를 받은 아이디: " + name);
    }
}
