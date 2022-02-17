//iterator를 사용한 Hashset의 객체 추가, 검색, 제거

/*
    String의 경우 객체가 새로 생성되더라도 HashCode와 equals 메소드가 오버라이딩 되어 있기 때문에
    Hashset을 저장하는 과정에서 true가 나와 새로 저장하지 않는다
 */

package collectionFramework.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetString {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("JDBC");
        set.add("servlet/JSP");
        set.add("Java"); //위에서 Java를 저장했기 때문에 한번만 저장된다
        set.add("iBATIS");

        int size = set.size();
        System.out.println("총 객체수: " + size);

        Iterator<String> iterator = set.iterator(); //반복자 얻기
        while (iterator.hasNext()) { //가져올 객체가 있는가?
            String element = iterator.next(); //객체를 가져온다
            System.out.println("\t" + element);
        }
        set.remove("JDBC");
        set.remove("iBATIS");

        System.out.println("총 객체수: " + set.size());

        iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("\t" + element);
        }

        set.clear(); //모든 객체를 제거하고 비움
        if (set.isEmpty()) {
            System.out.println("비어 있음");
        }
    }
}