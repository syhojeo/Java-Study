#System Class (java.lang.System)
자바 프로그램은 운영체제상에서 바로 실행되는것이 아닌 JVM위에서 실행되기 때문에 운영체제의 모든 기능을
자바 코드로 직접 접근하기는 어렵다

하지만 java.lang 패키지에 속하는 System 클래스를 이용하면 운영체제의 일부 기능을 이용할 수 있다.

ex) 프로그램 종료, 키보드로 부터 입력, 모니터로 출력, 메모리 정리, 현재 시간 읽기, 시스템 프로퍼티 읽기,
환경변수 읽기 등

System Class의 모든 필드와 메소드는 정적으로 구성되어 있다

## 1. 프로그램 종료 exit()
현재 실행하고 있는 프로세스를 강제 종료시키는 역할을 한다

매개값으로 int 형 매개값을 가지며 정상종료일 경우 0으로 지정하고, 비정상 종료일 경우 0 이외의 값을 지정한다

```System.exit(0);```

특정값이 입력되었을때 자바의 보안관리자를 직접 설정해서 종료 상태값을 확인 할 수 있다

System.exit() 가 실행되면 보안 관리자의 checkExit() 메소드가 자동 호출되는데, 이 메소드에서 종료 상태값을 
조사해서 특정값이 입력되지 않으면 SecurityException 을 발생시켜 System.exit()를 호출한 곳에서 예외처리를 
할 수 있도록 해준다.

```aidl
    //checkExit의 매개변수를 활용하기 위해 오버라이딩 해준다
    //이 값을 활용해 종료 상태 값에 따른 예외처리가 가능해진다
    //setSecurityManager의 익명객체 사용
    System.setSecurityManager(new SecurityManager() {
    @Override
    public void checkExit(int status) {
      if (status != 5) {
        throw new SecurityException();
      }
    });
```

## 2. Garbage Collector gc()
JVM은 메모리가 부족할 떄, CPU가 한가할 떄에 Garbage Collector 를 실행시켜 사용하지 않는 객체를 자동 제거한다


```
    Car myCar = new Car();
    myCar = null;  //기존의 Car쓰레기
    
    Car myCar = new Car();
    myCar = new Truck(); //기존의 Car 쓰레기
```

위와 같은 경우 맨 처음 생성되었던 Car 객체의 번지를 잃게 되기 때문에 쓰레기가 된다

```System.gc()```

메소드가 호출 되면 Garbage Collection 이 바로 실행되는것은 아니고, JVM이 빠른 시간내에 실행시키기위해 노력한다

다만 쓰레기가 생길때마다 Garbage Collection 이 작동하게 되면 정작 수행해야할 프로그램의 속도가 떨어지기 때문에
성능측면에서 좋지 않다

## 3. 현재 시각 읽기 currentTimeMillis(), nanoTime()
System Class의 currentTimeMillis() 와 nanoTime() 메소드는 컴퓨터의 시계로부터 현재시간을 읽어서
미리세컨드(1/1000초) 단위와 나노세컨드 (1/10^9초) 단위의 long값을 리턴한다

```java
    long time = System.currentTimeMillis(); //미리세컨드
    long time = System.nanoTime();      //나노세컨드
```

리턴값은 주로 프로그램의 실행 소요 시간 측정에 사용된다 (알고리즘할때 시간복잡도 확인)

## 4. 시스템 프로퍼티 읽기 getProperty()
### System property
JVM이 시작할 때 자동 설정되는 시스템의 속성값

ex) 운영체제의 종류, 자바프로그램을 실행시킨 사용자 아이디, JVM의 버전, 
운영체제에서 사용되는 파일 경로 구분자 등

System property는 key 와 value로 구성되어 있다.

![](.https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-20%20121001.png)

```java
    String value = System.getProperty(String key);
```

## 5. 환경 변수 읽기 getenv()
운영체제는 실행되는 프로그램들에게 유용한 정보를 제공할 목적으로 환경변수를 제공한다

환경변수는 운영체제에서 이름(Name)과 값(Value)로 관리되는 문자열 정보이다

```java
    String value = System.getenv (String name);
```