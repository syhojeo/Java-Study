package collectionFramework.tree.comparableAndComparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class DescendingComparator implements Comparator<Fruit> {
    //가격을 기준으로 내림차순 정렬 (오버라이딩을 통해 Map의 Key값이 아닌 Value값 기준으로도 정렬이 가능하다)
    @Override
    public int compare(Fruit o1, Fruit o2) {
        if (o1.price < o2.price) return 1;
        else if (o1.price == o2.price) return 0;
        else return -1;
    }
}

class Fruit{
    public String name;
    public int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class ComparatorExample{

    public static void main(String[] args) {
        /*
        TreeSet<fruit> treeSet = new TreeSet<Fruit>();
        //Fruit이 Comparable을 구현하지 않았기 때문에 ClassCastException 예외가 발생한다
        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));
         */

        //Key값이 Comparable을 구현하지 않았을 경우 Comparator을 이용하여 정렬해준다
        TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new DescendingComparator());
        //저장될때 가격을 기준으로 내림차순 정렬됨
        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));
        Iterator<Fruit> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            Fruit fruit = iterator.next();
            System.out.println(fruit.name + ":" + fruit.price);
        }
    }
}
