# Generic

## 1. Generic 을 쓰는 이유

### 1.1 컴파일시 강한 타입 체크를 할 수 있다
컴파일 시에 강한 타입 체크를 하여 실행 시 타입 에러를 방지할 수 있다

### 1.2 타입 변환 (casting)을 제거한다
비 제네릭 코드는 불필요한 타입 변환을 하기 때문에 프로그램 성능에 악영향을 미친다

```java
    //비 제네릭 코드
    List list = new ArrayList();
    list.add("hello");
    String str = (String) list.get(0); //리스트 타입을 사용했지만 String으로 타입 변환을 해야한다

    //제네릭 코드
    // 리스트에 저장되는 요소를 String으로 국한하기 때문에 타입변환을 할 필요가 없어 프로그램이 향상된다
    List<String> list = new ArrayList<String>();
    list.add("heelo");
    String str = list.get(0);
```

##2. 제네릭 타입 class<T>, interface<T>

#### 제네릭 타입
타입을 파라미터로 가지는 클래스와 인터페이스 

클래스 또는 인터페이스 이름 뒤에 "<>" 붙고, 사이에 타입 파라미터가 위치

```java
    public class 클래스명<T> {...}
    public interface 인터페이스명<T> {...}
```

```java
    public class Box<T> {
    private T t;
    public T get() {return t;}
    public void set(T t) {this.t = t;}
    }
    
    //객체 생성할 때 타입값 <T> 를 설정해 줌으로써 원하는 타입으로 타입 변환없이 사용할 수 있도록 해준다
    Box<String> box = new Box<String>();
```

##3. 멀티 타입 파라미터 class<K,V,...>, interface<K,V,...>
두개 이상의 멀티 파라미터 사용

```java
    public class Product<T, M> {
        private T kind;
        private M model;
    
        //getter
        public T getKind() { return this.kind; }
        public M getModel() { return this.model; }
    
        //setter
        public void setKind(T kind) { this.kind = kind; }
        public void setModel(M model) { this.model = model; }
    }
    
    public class ProductExample {
        public static void main(String[] args) {
            Product<Tv, String> product1 = new Product<Tv, String>();
            //Tv 객체 및 모델명 Product 객체에 넣기
            product1.setKind(new Tv());
            product1.setModel("스마트TV");
            //꺼내서 확인
            Tv tv = product1.getKind();
            String tvModel = product1.getModel();
            
            Product<Car, String> product2 = new Product<Car, String>();
            product2.setKind(new Car());
            product2.setModel("디젤");
            Car car = product2.getKind();
            String carModel = product2.getModel();
        }
    }
```

##4. 제네릭 메소드 <T, R> R method<T t>
제네릭 메소드 : 리턴타입과 매개타입을 제네릭으로 가지는 메소드를 말한다
static 필드의 경우 제네릭을 사용할 수 없다 ( 클래스가 생성되기 전에 제네릭 타입을 알 수 없기 때문 )
하지만 메소드의 경우 static을 사용할 수 있는데 메소드 호출시 제네릭 타입을 명시하기 때문이다
static 메소드의 경우에만 밑의 정의방법 (리턴값옆에 제네릭타입 적는방식)을 사용한다

```java
    // 제네릭 메소드 정의 방법
    // 접근지정자 , <타입 파라미터, ...> , 리턴타입, 메소드명(매개변수, ...) { 메소드 내용 }
    public <T> Box<T> boxing(T t) {...}

    
    // 제네릭 메소드 호출방법 2가지
    // 1. 명시적으로 구체적 타입을 지정
    //리턴 타입 변수 = <구체적 타입> 메소드명(매개값);
    Box<Integer> box = <Integer>boxing(100);

    // 2. 매개값을 보고 구체적 타입을 추정 (일반적으로 사용)
    //리턴 타입 변수 = 메소드명(매개값);
    Box<Integer> box = boxing(100);
```

클래스의 제네릭 타입명과 정적 메소드의 제네릭 타입명이 같은경우
```java
    //다음과 같이 클래스와 메소드의 제네릭타입이 T로 같다 하더라도 둘의 실제 타입은 다를 수 있다.
    //클래스의 제네릭은 인스턴스가 생성될때마다 지정되고, 정적메소드의 타입은 메소드를 호출할때마다 달라지기 때문에
    //지정되는 타이밍이 달라지기 때문이다    
    //이때문에 제네릭 타입의 정적 메소드를 사용한다
    public class Student<T> {
    static <T> T getOneStudent(T id) {
        return id;
    }
    
    //인스턴스 메소드의 경우 리턴타입 뒤에 제네릭 타입을 쓰지않고, 클래스 옆에 있는 T를 가져와 사용한다
    public void add(T t) {}
}
```

###5. 제한된 타입 파라미터 <T extends 최상위타입>
타입 파라미터를 원하는 타입 파라미터만 사용할 수 있도록 제한 하는 방법
```java
    //상위 타입으로는 클래스뿐아니라 인터페이스도 가능하다 
    //(인터페이스라고 해서 implement를 사용하지 않고, 그대로 extends를 사용한다)
    public <T extends 상위타입> 리턴타입 메소드(매개변수, ...) {...}
    //타입 파라미터에 지정되는 구체적인 타입은 상위 타입이거나 상위 타입의 하위 또는 구현 클래스만 사용 가능하다   

    //ex
    public class Util {
        public static <T extends Number> int compare(T t1, T t2) {
            double v1 = t1.doubleValue(); //Number의 doubleValue() 메소드 사용
            double v2 = t2.doubleValue(); //Number의 doubleValue() 메소드 사용
            return Double.compare(v1, v2);
        }
    }
    
    public class BoundedTypeParameterExample {
        public static void main(String[] args) {
            //String str = Util.compare("a", "b"); (x) extends Number를 통해 타입 파라미터를 제한했기 때문에
                                                    // String 형 타입 파라미터를 사용할 수 없다
            
            int result1 = Util.compare(10, 20);
            System.out.println(result1);
            
            int result2 = Util.compare(4.5, 3);
            System.out.println(result2);
        }
    }
```

###6. 와일드카드 타입 <?>, <? extends ...>, <? super ...>
- 제네릭타입<?> : 모든 클래스나 인터페이스 타입이 올 수 있다 (제한없음)
- 제네릭타입<? extends 타입> : 명시된 타입이나 명시된 타입의 하위 타입만 올 수 있다 (상위 클래스 제한)
- 제네릭타입<? supper 타입> : 명시된 타입이나 명시된 타입의 상위 타입만 올 수 있다 (하위 클래스 제한)

###7. 제네릭 타입의 상속과 구현
제네릭 타입도 다른 타입과 마찬가지로 부모 클래스가 될 수 있다
```java
    public class ChildProduct<T, M> extends Product<T, M> {...}
```