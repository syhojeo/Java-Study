//Comparable 의 구현객체를 만들어 사용자 정의 객체를 나이순으로 정렬하기
package collectionFramework.tree.comparableAndComparator;

import java.util.Iterator;
import java.util.TreeSet;

class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Comparable 의 메소드 오버라이딩
    @Override
    public int compareTo(Person o) {
        if (age < o.age) return -1;
        else if (age == o.age) return 0;
        else return 1;
    }
}

public class ComparableExample {

    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<Person>();
        //Comparable의 compareTo 메소드를 오버라이딩 했기 때문에 저장될 때 자동으로 나이순으로 정렬됨
        treeSet.add(new Person("홍길동", 45));
        treeSet.add(new Person("감자바", 25));
        treeSet.add(new Person("박지원", 31));

        //반복자를 이용하여 정렬(오름차순)된 treeSet을 읽어온다
        Iterator<Person> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person.name + ":" + person.age);
        }
    }
}
