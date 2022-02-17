package collectionFramework.tree.treeSet;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample2 {

    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<Integer>();
        scores.add(new Integer(87));
        scores.add(new Integer(98));
        scores.add(new Integer(75));
        scores.add(new Integer(95));
        scores.add(new Integer(80));

        //내림차순으로 정렬된 값
        NavigableSet<Integer> descendingSet = scores.descendingSet();
        for (Integer score : descendingSet) {
            System.out.println(score + " ");
        }
        System.out.println();

        //descendingSet을 두번 사용하여 오름차순으로 정렬하기
        NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();

        for (Integer score : ascendingSet) {
            System.out.println(score + " ");
        }
    }
}
