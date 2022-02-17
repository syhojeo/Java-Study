//TreeSet을 이용한 특정 객체 찾기
package collectionFramework.tree.treeSet;

import java.util.TreeSet;

public class TreeSetExample1 {

    public static void main(String[] args) {
        TreeSet<Integer> scores =new TreeSet<Integer>();
        scores.add(new Integer(87));
        scores.add(new Integer(98));
        scores.add(new Integer(75));
        scores.add(new Integer(95));
        scores.add(new Integer(80));

        Integer score = null;

        score = scores.first();
        System.out.println("가장 낮은 점수: " + score);

        score = scores.last();
        System.out.println("가장 높은 점수: " + score + "\n");

        //만약 아래점수가 존재하지 않는다면 null을 리턴한다
        score = scores.lower(new Integer(95));
        System.out.println("95점 아래 점수: " + score);

        score = scores.higher(new Integer(95));
        System.out.println("95점 위의 점수: " + score + "\n");

        score = scores.floor(new Integer(95));
        System.out.println("95점 이거나 바로 아래 점수: " + score);

        score = scores.ceiling(new Integer(85));
        System.out.println("85점 이거나 바로 위의 점수: " + score + "\n");

        while(!scores.isEmpty()) {
            //제일 낮은 객체를 꺼내오고 컬렉션에서 제거
            //TreeSet.pollLast()(반대로 제일 높은 객체를 꺼내오고 컬레션에서 제거)
            score = scores.pollFirst();
            System.out.println(score + "(남은 객체 수: " + scores.size() + ")");
        }
    }
}
