package collectionFramework.ex;

import java.util.TreeSet;

public class Ex10 {

    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<Student>();
        treeSet.add(new Student("blue", 96));
        treeSet.add(new Student("hong", 86));
        treeSet.add(new Student("white", 92));

        Student student = treeSet.last();
        System.out.println("최고점수: " + student.score);
        System.out.println("최고점수를 받은 아이디: " + student.id);
    }
}

class Student implements Comparable<Student> {
    public String id;
    public int score;

    public Student(String id, int score) {
        this.id = id;
        this.score = score;
    }

    //오름차순 정렬: 매개 변수보다 주어진값이 작으면 음수를 리턴
    @Override
    public int compareTo(Student o) {
        if (score < o.score) return -1;
        else if (score == o.score) return 0;
        else return 1;
    }
}