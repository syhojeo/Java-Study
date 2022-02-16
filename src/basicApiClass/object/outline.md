#Object 클래스 (java.lang.Object)
자바의 최상위 부모 클래스에 해당하며 java.lang 패키지에 위치한다 <br/>
클래스를 선언할때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 Object 클래스를 상속하게 된다.

ex) ```public boolean equals(Object obj) {...}```

equals() 메소드의 매개변수를 보면 Object로 되어있으며 이는 모든 객체가 매개값으로 대입될 수 있음을 말한다

모든 객체는 Object 타입으로 자동 타입 변환될 수 있기 때문이다

## HashCode, equals 의 Override

HashCode와 equals 메소드는 기본적으로 Object 클래스에 정의 되어 있으며 equals 메소드는 객체의 주소값을 비교하고
HashCode는 그 객체의 주소값을 hash 알고리즘을 통해 int 형 정수로 나타낸다

하지만 이것은 Object에 정의된 메소드이고, 우리는 단순히 객체를 주소값으로 비교하는것이 아닌 논리적으로 동등한지
비교를 하고 싶고 그렇기 때문에 이 둘을 오버라이딩하여 사용한다

ex)

```java
import java.util.HashMap;

public class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

    public static void main(String[] args) {
        Student s1 = new Student("홍길동", 1);
        Student s2 = new Student("김첨지", 2);
        Student s3 = new Student("홍길동", 1);
    }
```

위에서 우리는 보통 equals와 hashCode를 통해서 s1과 s3가 같은 객체로 다뤄지길 원한다 (논리적 동등성)

하지만 Object 의 equals와 hashCode 메소드는 단순히 객체의 주소를 비교하기 때문에 s1과 s3는 다른 객체로
다뤄질 것이다

이것을 바꾸기 위해 우리는 보통 equals와 hashCode를 오버라이딩 한다

ex)
```java
    public class Member {
        private String id;
        
        public Member(String id) {
            this.id = id;
        }
        
        @Override
        public int hashcode() {
            return id.hashCode(); //String.hashCode()
        }
        
        @Override
        public boolean equals(Obejct obj) {
            //매개변수가 Object 타입으로 들왔기 때문에 
            //비교하기 위해선 강제 형변환이 필요
            //강제 형변환을 하기 위해 객체가 같은 객체인지 확인
            if (obj instanceof Member) { 
                Member member =  (Member) obj; //비교를 위한 강제 형변환
                if (id.equals(member.id)) {
                    return true;
                }
            }
            else
                return false;
        }
    }
```

다만 이처럼 equals() hashCode() 두 메소드를 오버라이딩 하는것에는 규칙이 존재한다
1. 두 객체가 같으면(사용자 입맛에 맞는 해당 기준이 같다고 판단되면 = 논리적으로 같다)
   반드시 같은 hashCode를 가져야한다
2. 두 객체가 같으면 equals() 메서드를 호출 했을때 true 를 반환해야한다
3. **두객체의 hash가 같다고 해서 반드시 같은 객체는 아니다**

hashCode()는 리턴 값이 int 형이기 때문에 매우매우매우 낮은 확률로 객체가 다르다하더라도 같은 hashCode값이
나올 수가 있다 이때문에 두객체가 같은지를 확인할때에는 hashCode만 비교하는 것이 아닌 equals 메소드를 통해
정말로 동등한 객체인지를 확인한다

4. equals() 메소드를 오버라이드 하며 반드시 hashCode() 메소드도 override한다
   equals() 메소드를 오버라이딩 했다는 것은 메모리 주소 비교가 아닌 사용자가 정한 기준의 논리성 비교를 한다는
   이야기인데

hashCode()는 기본적으로 Heap에 있는 각 객체에 대한 메모리 주소 메핑 정보를 기반으로 정수값을 반환하기 때문에
논리성 비교가 아닌 메모리 주소값에 대한 hashCode가 된다 때문에 equals()를 오버라이드한다면 hashCode()
또한 반드시 오버라이드 해줘야한다

예를 들어 위의 Student 클래스에서 s1과 s3가 같다는 비교를 할수 없기 때문에 equals 메소드를 오버라이딩 했다면
hashCode() 또한 오버라이딩 해줘야한다

#### hashCode와 equals 의 속도차이
equals 메소드는 값을 하나씩 비교해서 검증하기 때문에 시간이 걸리는 반면 해시값은 간단한 계산의 결과만 가지고
비교하기 때문에 상대적으로 속도가 빠르다. 객체 안의 필드값이 많을 수록 속도 차이가 많이 나게 된다

때문에 hashCode로 먼저 거르고, 그래도 같다면 낮은 확률로 객체가 다를 경우를 대비해서 equals 메소드를 사용한다
