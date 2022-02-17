//ArryaList와 LinkedList의 실행 성능 비교
package collectionFramework.List.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new LinkedList<String>();

        long startTime;
        long endTime;
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list1.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 걸린시간: " + (endTime-startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 걸린시간: " + (endTime-startTime) + " ns");
        //결과: 계속해서 뒤로 미루는 작업을 ArrayList에서 실행하기 때문에
        //중간에 삽입하는 삽입속도는 LinkedList 가 ArrayList에 비해 빠르다
    }
}