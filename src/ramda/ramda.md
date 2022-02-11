# 람다식
람다식은 객체 지향언어라기보다 함수 지향언어이다.

자바에서 람다식을 사용하는 이유는
1. 자바코드가 매우 간결해진다
2. 컬렉션의 요소를 필터링하거나 매핑해서 원하는 결과를 쉽게 집계할 수 있다

람다식의 형태는 매개변수를 가진 코드블록이지만, 런타임 시에는 익명 구현 객체를 생성한다

람다식 -> 매개변수를 가진 코드블록 -> 익명 구현 객체

```java
    //익명 구현 객체
    Runnable runnable = new Runnable() {
        public void run() {}
    };

    //람다식 변환 "(매개변수) -> {실행코드}"
    Runnable runnable = () -> {...}
```

##1. 람다식 기본 문법
### 예시
`(타입 매개변수, ...) -> { 실행문...}`
```java
    //세 코드는 같다 (매개변수 타입은 런타임 시에 대입되는 값에 따라 자동으로 인식될 수 있기 때문)
    (int a) -> { System.out.println(a); }
    (a) -> { System.out.println(a); }
    //매개변수가 하나라면 괄호도 생략 가능하다    
    a -> { System.out.println(a); }

    //return
    (x, y) -> { return x + y; };
    //중괄호 내에 return 문만 있을 경우 중괄호와 리턴 생략 가능   
    (x, y) -> x + y 
```

##2. 타겟 타입과 함수적 인터페이스

람다는 메소드를 선언하는것 처럼 보이지만 자바의 메소드는 항상 클래스의 구성 멤버로 선언되어야 하기 때문에
단독으로 선언하는것은 불가능하다 그래서 해당 메소드를 가지고 있는 객체를 생성하는 매커니즘을 가진다

`인터페이스(타겟 타입) 변수 = 람다식;`

람다식은 인터페이스 변수에 대입된다. 즉, 인터페이스의 익명 구현 객체를 생성하는 매커니즘을 가진다
람다식은 대입될 인터페이스 종류에 따라 작성 방법이 달라지기 때문에 람다식이 대입될 인터페이스를 람다식의 
**타겟 타입(Target Type)** 이라한다

##3. 함수적 인터페이스 (@FunctionalInterface)
람다식이 하나의 메소드를 정의하기 때문에 두개 이상의 추상메소드가 선언된 인터페이스는 람다식을 이용해서 구현 객체를 
생성할 수 없다.

때문에 하나의 추상 메소드가 선언된 인터페이스만이 람다식의 타겟 타입이 될 수 있는데 이러한 인터페이스를 함수적 인터페이스
라고 한다

또한 @FunctionalInterface 주석을 사용하여 함수적 인터페이스를 작성할 때 두 개 이상의 추상 메소드가 선언되지 않도록 
컴파일러가 체킹해줄 수 있다

```java
    @FunctionalInterface
    public interface MyFunctionalInterface {
        public void method();
        //public void otherMethod(); //컴파일 오류 (추상메소드가 두개 이상이기 때문)
    }
    
    MyFunctionalInterface fi = () -> {...}
    //참조 변수로 접근하여 구현 메소드 사용가능
    fi.method();
```

##4. 클래스 멤버와 로컬 변수 사용
람다식의 실행블록에는 클래스의 멤버(필드와 메소드) 및 로컬 변수를 사용할 수 있다

클래스의 멤버는 제약 사항이 없이 사용 가능하지만, 로컬 변수는 제약 사항이 따른다

### 클래스의 멤버 사용
클래스의 멤버 사용에는 제약 사항이 없지만 this 키워드를 사용할 때에 주의가 필요하다
```java
    //타겟타입
    public interface MyFunctionalInterface {
        public void method();
    }
    //람다식 사용 클래스
    public Class UsingThis{
        public int outterField = 10;
        //중첩 클래스 inner
        class Inner {
            int innerField = 20;
            
            void method() {
                //람다식
                MyFunctionalInterface fi = () -> {
                    System.out.println("outterField: " + outterField);
                    //바깥 객체(UsingThis)를 사용하기 위해 
                    //클래스명(바깥).this 사용 -> 중첩 클래스에서 나온내용과 같다
                    System.out.println("outterField: " + UsingThis.this.outterField + "\n");
                    
                    System.out.println("innerField: " + innerField);
                    System.outprintln("innerField: " + this.innerField + "\n");
                };
            fi.method();    
            }
        }
    }
    
    public class UsingThisExample {
        public static void main(String[] args) {
            UsingThis usingThis = new UsingThis();
            //인스턴스 멤버 클래스 객체 생성
            UsingThis.Inner inner = usingThis.new Inner();
            inner.method();
        }
    }
```

### 로컬 변수 사용
람다식은 메소드 내부에서 주로 작성되기 때문에 주로 로컬 익명 구현 객체를 생성시킨다

메소드의 매개변수 또는 로컬 변수를 사용하면 이 두 변수는 final 특성을 가져야한다

(중첩 클래스의 로컬클래스에서 사용하는 메소드의 로컬변수, 매개변수는 반드시 final 특성을 가져야하는 것과 같은 이유이다)

```java
    public interface MyFunctionalInterface {
    public void method();
    }

    public class UsingLocalVariable {
        void method(int arg) { //매개 변수 arg는 자동으로 fianl 특성을 가지고 있다(람다식 내부에서 사용되었기 때문에)
            int localVar = 40; //로컬변수 localVar은 자동으로 final 특성을 가진다(람다식 내부에서 사용되었기 때문에)
            
            //arg = 31; // final 특성 때문에 수정 불가
            //localVar = 41; //final 특성 때문에 수정 불가
        }
        
        //람다식
        MyFunctionalInterface fi = () -> {
            //f로컬 변수 읽기
            System.out.println("arg: " + arg); //arg 가 final 특성을 가지는 이유
            System.out.println("localVar: " + localVar + "\n"); // localVar가 final 특성을 가지는 이유
        };
        fi.method();
    }
    
    public class UsingLocalVariableExample {
        public static void main(String[] args) {
            UsingLocalVariable ulv = new UsingLocalVariable();
            ulv.method(10);
        }
    }
```

##5. 표준 API의 함수적 인터페이스
표준 API의 함수적 인터페이스를 사용하여 따로 인터페이스를 만들고 메소드 내부에서 람다를 사용할 필요 없이 편하게 
사용할 수 있도록 만들어 준다

함수적인터페이스의 추상메소드 구현을 람다로 하고, 각각의 구현된 메소드를 호출 하여 람다식의 실행을 쉽게 
할 수 있도록 해준다

![](https://github.com/syhojeo/Java-Study/blob/main/image/6.png)

### Consumer 함수적 인터페이스
리턴값이 없고, 매개변수만 있는 accept() 메소드를 가지고 있다 (데이터를 소비)

![](https://github.com/syhojeo/Java-Study/blob/main/image/7.png)

ex)
```java
    Consumer<String> consumer = t -> { t를 소비하는 실행문; };
    BiConsumer<String, String> consumer = (t, u) -> { t와 u를 소비하는 실행문; } 
```

### Supplier 함수적 인터페이스
매개 변수가 없고, 리턴값이 있는 getXXX()메소드를 가진다 (데이터를 공급)

![](https://github.com/syhojeo/Java-Study/blob/main/image/8.png)

ex)
```java
    Supplier<String> supplier = () -> { ...; return "문자열"; }
    IntSupplier supplier = () -> { ...; return int 값; }
```

### Function 함수적 인터페이스
매개값과 리턴값이 있는 applyXXX() 메소드를 가지고 있다 (매핑 = 타입변환 하는 역할)

![](https://github.com/syhojeo/Java-Study/blob/main/image/9.png)

![](https://github.com/syhojeo/Java-Study/blob/main/image/10.png)

ex)
```java
    Function<Student, String> function = t -> { return t.getName(); }
    ToIntFunction<Student> function = t -> { return t.getScore(); }
```

### Operator 함수적 인터페이스
Function 과 동일하게 매개변수와 리턴값이 있는 applyXXX() 메소드를 갖는다

하지만 Function 의 mapping(타입변환) 하는 역할보다 **매개값을 이용해서 연산을 수행한 후 동일한 타입으로 리턴값을 
제공**하는 역할을 한다

![](https://github.com/syhojeo/Java-Study/blob/main/image/11.png)

ex)
```java
   IntBinaryoperator operator = (a, b) -> {...; return int 값;} 
```

### Predicate 함수적 인터페이스
매개변수와 boolean 리턴값이 있는 testXXX() 메소드를 갖는다 (매개값을 조사해서 true 또는 false 를 리턴하는 역할)

![](https://github.com/syhojeo/Java-Study/blob/main/image/12.png)

![](https://github.com/syhojeo/Java-Study/blob/main/image/13.png)

```java
    //equals 를 사용하여 boolean 리턴값이 나오도록 한다
    Predicate<Student> predicate = t -> { return t.getSex().equals("남자");}
    //또는
    predicate(Student) predicate = t -> t.getSex().equals("남자");
```

### andThen() compose() 디폴트 메소드
Consumer, Function, Operator 는 함수적 인터페이스이기 때문에 **andThen() 과 compose()** 라는 디폴트 
메소드를 가지고 있다

두 메소드는 두개의 함수적 인터페이스를 순차적으로 연결하고, 첫 번째 처리 결과를 두 번째 매개값으로 제공해서
최종결과값을 얻을때 사용한다

ex)
```java
    //A andThen B : A 먼저 실행 후 처리결과를 매개값으로 B 실행
    인터페이스AB = 인터페이스A.andThen(인터페이스B);   
    최종결과 = 인터페이스AB.method();
    
    //A compose B: B 먼저 실행 후 처리결과를 매개값으로 B 실행
    인터페이스AB = 인터페이스A.compose(인터페이스B);
    최종결과 = 인터페이스AB.method();
```
사용 가능한 함수적 인터페이스 목록

![](https://github.com/syhojeo/Java-Study/blob/main/image/14.png)


### and(), or(), negate() 디폴트 메소드와 isEqual() 정적 메소드
predicate 종류의 함수적 인터페이스는 and(), or(), negate() 디폴트 메소드를 가진다

이는 각각 논리연산자인 &&, ||, ! 와 대응된다

![](https://github.com/syhojeo/Java-Study/blob/main/image/15.png)

predicate 는 디폴트메소드 이외에 isEqual() 이라는 정적 메소드를 추가로 가지고 있다
isEqual() 메소드는 predicate 의 test

```java
    //isEqual 의 매개값과 test 메소드의 매개값이 동등한지 비교한다
    // = targetObject와 sourceObject이 동등한지 비교
    Predicate<Object> predicate = Predicate.isEqual(targetObject);
    boolean result = predicate.test(sourceObject);
```

### minBy(), maxBy() 정적 메소드
BinaryOperator<T> 함수적 인터페이스는 minBy()와 maxBy() 정적메소드를 제공한다

![](https://github.com/syhojeo/Java-Study/blob/main/image/16.png)

minBy()와 maxBy()는 Comparator를 이용해서 최대 T와 최소T를 얻는 BinaryOperator<T>를 리턴한다

#### Comparator
```java
    //o1, o2 를 비교해서 o1 이 작으면 음수, 같으면 0, o1이 크면 양수를 리턴하는 
    //compare 메소드가 Comparator 내부에 선언되어 있다
    @FunctionalInterface
    public interface Comparator<T> {
    public int compare(T o1, T o2);
    }

    //o1, o2 가 모두 Integer일때 람다로 메소드 구현
    (o1, o2) -> Integer.compare(o1, o2);

    //maxBy()
    maxBy((o1, o2) -> Integer.compare(o1, o2));
    
    //minBy()
    minBy((o1, o2) -> Integer.compare(o1, o2));
    
    //maxBy(), minBy() 안에서 알아서 최소값 최대값을 나눠주기 때문에 compare 만 해주면 된다
```

##6. 메소드 참조
람다식이 단순히 메소드만 참조할경우에 메소드 참조를 사용한다

메소드를 참조하여 매개 변수의 정보 및 리턴 타입을 알아내어, 람다식에서 불필요한 매개 변수를 제거할 수 있다

ex) 두개의 값을 받아 큰 수를 리턴하는 Math클래스의 max() 정적 메소드 호출
```java
    (left, right) -> Math.max(left, right);

    //위와 같이 단순히 매개변수를 넣고 호출하는 경우에는 람다식을 사용하지 않고 메소드 참조 방식을 사용하여
    //람다식의 불필요한 매개변수를 제거한다
    Math :: max;
```

메소드 참조도 람다식과 마찬가지로 인터페이스의 익명 구현 객체로 생성되기 때문에
타겟 타입인 인터페이스의 추상 메소드가 어떤 매개 변수를 가지고, 리턴 타입이 무엇인가에 따라 달라진다

ex)
```java
    //IntBinaryOperator 인터페이스는 두 개의 int 매개값을 받아 int 값을 리턴하므로 
    // Math :: max 메소드를 참조 대입할 수 있다
    IntBinaryOperator operator = Math :: max;
```

메소드 참조는 정적 또는 인스턴스 메소드를 참조할 수 있고, 생성자 참조도 가능하다

### 정적메소드와 인스턴스 메소드 참조
#### 정적 메소드

`` 클래스 :: 메소드 ``

#### 인스턴스 메소드
``참조변수 :: 메소드``

### 매개변수의 메소드 참조
```java
    //람다식에서 제공되는 a 매개변수의 메소드를 호출해서 b 매개변수를 매개값으로 사용할 경우
    (a, b) -> { a.instanceMethod(b); } 
    //다음과 같이 메소드 참조를 통해 매개변수를 제거할 수 있다 
    클래스 :: instanceMethod
```

### 생성자 참조
객체 생성 후 리턴만 하는 경우 생성자 참조를 할 수 있다
```java
    (a, b) -> { return new 클래스(a, b); }

    클래스 :: new
```