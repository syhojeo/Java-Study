//hashCode(), equals() 오버라이딩
package collectionFramework.map.hashMap;

import java.util.HashMap;
import java.util.Map;

class Student {
    public int sno;
    public String name;

    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return ((sno == student.sno) && (name.equals(student.name)));
        }
        else
            return false;
    }

    @Override
    //equals 를 오버라이딩 했을 경우 hashCode() 또한 반드시 오버라이딩 해줘야한다
    //그러지 않으면 논리적으로 같다고 생각되는 객체를 다르게 보고 중복된 객체도 저장하기 때문이다
    public int hashCode() {
        return sno + name.hashCode();
    }
}

public class HashMapExample2 {

    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<Student, Integer>();

        //동일한 객체를 put 해줬을 경우에는 Set과는 반대로 가장 최근에 넣은 Key값으로 대체된다
        map.put(new Student(1, "홍길동"), 95);
        map.put(new Student(1, "홍길동"), 95);
        
        //hashCode() 를 오버라이딩 하지 않으면 size가 2가 나온다
/*
        why?
        map.put을 이용하여 값을 넣을때 중복되는 객체인지 아닌지 확인을 hashCdoe()와 equals()를 가지고
        체크를 하기 때문에 hashCode()를 오버라이딩 하지않고 단순히 Object의 본래 메소드인 객체의
        주소값만 가지고 hashCode를 리턴하게 되면 위에서 map.put 의 Key값으로 넣어준 객체는 서로 다르다고 인식할
        것이고 때문에 논리적 동등의 중복체크를 사용자 입맛대로 할수 없게된다
 */
        System.out.println("총 Entry 수: " + map.size());
    }
}