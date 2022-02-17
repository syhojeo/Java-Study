package collectionFramework.List.arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        //add
        list.add("Java");
        list.add("JDBC");
        list.add("Servlet/JSP");
        list.add(2, "Database");
        list.add("iBATIS");

        //size
        int size = list.size();
        System.out.println("총 객체수:" + size);
        System.out.println();

        //get
        String skill = list.get(2); //두번째 인덱스
        System.out.println("2: " + skill);
        System.out.println();

        //looping
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(i + ":" + str);
        }
        System.out.println();

        //remove
        list.remove(2);
        list.remove(2);
        list.remove("iBATIS");

        //looping
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(i + ":" + str);
        }
    }
}
