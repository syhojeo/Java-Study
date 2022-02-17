package collectionFramework.tree.treeSet;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample3 {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("apple");
        treeSet.add("forever");
        treeSet.add("description");
        treeSet.add("ever");
        treeSet.add("zoo");
        treeSet.add("base");
        treeSet.add("guess");
        treeSet.add("cherry");

        System.out.println("[c~f 사이의 단어 검색]");
        //시작객체 = "c" , 시작객체의 포함여부 = true (포함), 끝 객체 = "f", 끝 객체의 포함 여부 = true (포함)
        // "c" <= 검색단어 <= "f"
        NavigableSet<String> rangeSet = treeSet.subSet("c", true, "f", true);
        for (String word : rangeSet) {
            System.out.println(word);
        }
    }
}
