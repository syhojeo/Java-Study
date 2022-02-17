/*
    hashCode() 와 equals() 메소드 재정의
    Object에 정의된 hashCode() 와 equals() 메소드의 메모리 주소 기반 성격과 달리
    사용자들은 대부분 논리적 객체 비교를 원하기 때문에
    이에 따라 알맞은 오버라이딩을 해줄 필요가 있다
 */
package collectionFramework.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {

    public static void main(String[] args) {
        Set<Member> set = new HashSet<Member>();
        HashSetExample2 ex = new HashSetExample2();

        //인스턴스는 다르지만 내부 데이터가 동일하므로 객체 1개만 저장
        set.add(ex.new Member("홍길동", 30));
        set.add(ex.new Member("홍길동", 30));

        System.out.println("총 객체수 : " + set.size());
    }

    public class Member {
        public String name;
        public int age;

        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

        //단순한 주소 비교가 아닌 사용자가 원하는 논리적 객체 비교를 위한 equals 메소드 오버라이딩
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Member) {
                Member member = (Member) obj;
                return member.name.equals(name) && (member.age == age);
            }
            else {
                return false;
            }
        }
    
        //사용자에게 알맞는 해시코드 생성
        @Override
        public int hashCode() {
            return name.hashCode() + age;
        }
    }
}
