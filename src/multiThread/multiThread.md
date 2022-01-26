# MultiThread (java.lang.Thread)

멀티스레드는 대용량 데이터의 처리 시간을 줄이기 위해 데이터를 분할해서 병렬로 처리하거나, Ui를 가진 에플리케이션에서
네트워크 통신을 위해 사용되기도 한다
또한 다수의 클라이언트의 요청을 처리하는 서버를 개발할 때에도 사용된다

기본적으로 싱글스레드는 메인 스레드가 종료되면 어플리케이션이 종료되지만 멀티 스레드의 경우 하나의 스레드라도 작동하고 있다면
어플리케이션이 종료되지 않는다

## 작업 스레드 생성과 실행
###1. Thread 클래스로 부터 직접 생성

```java
    //Thread 클래스를 사용하여 직접 생성하려면 Runnable 타입을 매개값으로 갖는 생성자를 호출해야한다
    Thread thread = new Thread(Runnable target);
```

**Runnable** 은 작업 스레드가 실행할 수 있는 코드를 가지고 있는 객체이다 또한 Runnable 은 인터페이스 타입이기 때문에
구현객체를 만들어 대입해야 한다.


Runnable 객체를 만들어 직접 run()을 가진 클래스 만들기
```java
    //Step1 Runnable 구현객체를 구현
    class Task implements Runnable {
        public void run() {
            //스레드가 실행할 코드
        }
    }
    
    //Step2 Runnable 객체를 생성
    Runnable task = new Task();
    
    //Step3 Thread 클래스를 이용한 스레드 객체 생성
    Thread thread = new Thread(task);
    
    //Step1~3까지의 단계를 익명구현객체를 이용하여 생략 (인터페이스의 익명 구현 객체)
    Thread thread = new Thread(new Runnable() {
            public void run(){
                //스레드가 실행할 코드    
            }       
        });
    
    //run() 부분을 동작시키는 스레드 작동 메소드
    thread.start();
```

Runnable을 가진 객체를 만들지 않고, Thread클래스를 상속하여 그안에 있는 run()을 오버라이딩 해서 만들기
```java
    //Step1 Runnable 인터페이스의 구현객체를 만들어 run() 메소드를 구현하지 않고, 
    // Thead 클래스 내부 run() 코드를 직접오버라이딩
    public class WorkerThread extends Thread {
    @Override
    public void run() {
        //스레드를 실행할 코드
        }
    }
    
    //Step2 스레드 객체 생성
    Thread thread =  new WorkerThread();

    //Step1~2까지의 단계를 익명구현객체를 이용하여 생략 (클래스의 익명 구현 객체)
    Thread thread = new Thread() {
        public void run() {
            //스레드가 실행할 코드
        }
    };
    
    //run() 부분을 동작시키는 스레드 작동 메소드
    thread.start();
```

##2. 스레드의 이름
메인 스레드는 main이라는 이름이 있고, 직접 생성한 스레드는 "Thread-n" 이라는 이름으로 설정

```java
    //스레드 이름 설정
    thread.setName("스레드 이름");

    //스레드 이름 읽어오기
    thread.getName();
    
    //만약 스레드를 참조하는 객체가 없다면 currentThread()를 통해 현재 코드를 동작시키는 스레드명의 참조 주소를 받아온다
    Thread thread = Thread.currentThread();
```

##3. 스레드 우선순위
멀티스레드는 동시성 또는 병렬성으로 실행된다

동시성: 하나의 코어에서 멀티 스레드가 번갈아가며 실행하는 성질

병렬성: 멀티 코어에서 개별 스레드를 동시에 실행하는 성질

싱글코어 CPU를 이용한 멀티 스레드 작업은 병렬적으로 실행되는것처럼 보이지만 워낙에 작업속도가 빨라서 그렇게 보이는것이지
실제로는 번갈아가며 실행하는 동시성 작업이다.

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-21%20130834.png)

###3.1 스레드 스케줄링

쓰레드의 개수가 코어의 수보다 많을경우, 스레드를 어떤 순서에 의해 동시성으로 실행할 것인가를 결정해야하는데 이것을
**스레드 스케줄링** 이라고한다 스레드 스케줄링에 의해 스레드들은 아주 짧은 시간에 번갈아가면서 run() 메소드를 조금씩
실행한다

스레드 스케줄링은 우선순위(Priority) 방식과 순환할당(Round-Robin) 방식 두가지가 있다

1. 우선순위 방식 (Priority) :
우선순위가 높은 스레드가 실행 상태를 더 많이 가지도록 스케줄링 (1~10까지 순위가 부여되며 수가 높을수록 우선순위가 높다)
또한 스레드의 숫자가 코어의 숫자보다 적을 경우 하나의 코어에 하나의 스레드만 할당 되기 때문에 
우선순위 방식은 크게 영향을 끼치지 못한다

2. 순환 할당 방식 (Round-Robin) :
시간 할당량을 정해서 **하나의 스레드를 정해진 시간만큼 실행**하고, 다시 다른 스레드를 실행하는 방식

우선순위 방식은 스레드 객체의 우선순위 번호를 개발자가 코드로 부여할 수 있기 때문에 제어가 가능하지만 
순환 할당 방식의 시간할당량은 자바 가상 기계에 의해서 정해지기 때문에 코드로 제어할 수 없다

우선순위 지정방법
```java
    //Thread.setPriority(우선순위);
    thread.setPriority(Thread.MAX_PRIORITY); //10
    thread.setPriority(Thread.NORM_PRIORITY); //5
    thread.setPriority(Thread.MIN_PRIORITY); //1
```

##3. 동기화 메소드와 동기화 블록

두개 이상의 스레드가 하나의 객체를 사용할 때 동시에 사용해서 문제가 생기는데 이를 임계영역(critical section) 설정을
통해서 제어해줘야한다

자바에서는 임계영역을 지정하기 위해 동기화(synchronized) 메소드와 동기화 블록을 제공한다 synchornized 키워드는
인스턴스와 정적메소드 어디든 붙일 수 있다

```java
    //synchronized 메소드
    public synchronized void method() {
        //critical section //단하나의 스레드만 실행가능한 메소드
    }
    
    //syncrhonized 블록
    public void method () {
        //여러 스레드가 실행 가능 영역
    
        //동기화 블록
        synchronized(공유객체) { // 공유객체에 자신의 객체를 동기화 시키고 싶다면 this를 넣으면 된다
            critical section //단하나의 스레드만 실행 가능
    }
```

하나의 스레드가 critical section에 진입했다면 그 스레드가 critical section을 빠져나올때까지
다른 스레드는 해당 critical section 뿐만아니라 모든 critical section 에 진입할 수 없다

##4. 스레드 상태
![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-21%20152042.png)

스레드의 상태는 객체 생성, 실행, 실행 대기, 일시 정지, 종료 5가지의 상태가 존재한다

기본적으로 스레드 객체가 생성되었을때 객체 생성상태가 되며 

Thread.start() 메소드가 사용되면 스레드 스케줄링에 의해서 실행과 실행 대기 상태를 반복하게 되고 

run()메소드가 종료되면 종료상태로 들어간다

몇몇 상황에 따라 일시정지 상태가 되기도 한다
##5. 스레드 상태 제어
### 스레드 상태 관계

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-21%20154440.png)

###스레드 상태 제어 메소드

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-21%20154518.png)


###5.1 주어진 시간동안 일시정지 sleep()
Thread.sleep() 메소드를 호출한 스레드는 주어진 시간동안 일시정지 상태가 되고, 다시 실행대기 상태로 돌아간다
매개변수로는 밀리 세컨드 단위의 시간을 넣어주면 된다
```java
    try {
        Thread.sleep(1000); //밀리세컨드 단위
    } catch (InterruptedException e) {
        // interrupt() 메소드가 호출되면 실행
    }
```


###5.2 다른 스레드에게 실행 양보 yield()
for 문이나 while문을 통한 무의미한 반복을 하는경우 스레드에 실행대기 상태를 부여하고 다른 스레드에게 
동일한 혹은 높은 우선순위를 할 수 있도록 만들어주는 메소드이다

```java
    public void run() {
        while(true) {
            if(work) { //work 값이 false 라고 가정할때 true로 변경되는 시점이 불명확하다면
                        //의미없는 무한반복을 하게될것이다
                System.out.println("ThreadA 작업 내용");    
            }
            else {
                Thread.yield();   //때문에 다른 스레드에게 실행기회를 부여해주는 yield() 메소드를 사용한다
            }       
        }
    }
```

### 5.3 다른 스레드의 종료를 기다림 join()
다른 스레드의 작업이 끝날때까지 현재 스레드의 상태를 일시정지로 만드는 메소드

```java
    threadB.start(); 
    threadB.join(); //threadB 의 작업이 종료될때까지 현재 스레드는 일시정지 상태에 돌입하고
                    //작업이 종료되면 일시정지에서 풀려 다음 코드를 실행하게 된다
```

###5.4 스레드 간 협업 wait(), notify() , notifyAll()
두개 혹은 여러개의 스레드에서 하나의 critical section에 대한 정확한 교대작업을 위해서 wait, notify 메소드들을 사용한다

wait() : 스레드가 일시정지 상태가 되고, Synchronized 의 락을 해제시킨다

notify() : 일시정지 상태인 하나의 랜덤한 스레드를 실행대기 (Runnable) 상태로 만들어주고, 자기 스레드를 일시정지 상태로 만든다

notifyAll() : notify와 동작은 같지만 하나의 스레드가 아닌 일시정지 상태인 모든 스레드를 Runnable 상태로 만들어 준다

```java
    Synchronized(this) {
        if(this.data == null) {
            wait();
        }
        x = this.data;
        this.data = null;
        notify();
    }
```
### notify() 매커니즘
notify() 메소드를 사용할 떄 알아두어야할 점이 두가지가 있다

첫번째는 notify는 wait하고 있는 스레드가 없는 경우 자신의 스레드를 일시정지 상대로 만드는 등의
추가적인 행동을 하지 않고 소멸된다

두번째는 notify()는 실행된다고 스레드가 바로 일시정지 상태로 돌입하지 않는다는 점이다
notify()메소드가 실행되면 notify 메소드가 있는 **Synchronized 내부 코드를 모두 실행**한 뒤 
일시 정지 상태인 스레드를 찾아 실행대기(Runnable) 상태로 만들어준다 그다음 wait메소드를 호출하여 자신의 스레드가
일시 정지 상태로 돌입하도록 만들어준다

또한 notify는 일시정지 상태인 스레드들 중 랜덤하게 단하나의 스레드만 Runnable 상태로 만들어 준다는 점이다
이때문에 대부분의 소스코드에서는 랜덤성 있는 notify를 사용하기보다 확실하게 Runnable 상태로 만들어 줄 수 있는
notifyAll() 메소드를 사용하는 것을 추천한다

### Synchronized 와 wait(), notify()

wait(), notify() , notifyAll() 메소드들은 Synchornized 내에서만 사용이 가능하다

wait() 의 경우 Synchronized 블럭 내부에서 잠시 일시정지하고 락을 풀어주기 위해 사용되기 때문에 당연히
Synchronized 메소드나 블럭내에서만 사용이 가능하고,

notify()의 경우 두가지 이유가 있는데

하나는 Synchronized 가 한쪽에만 걸리거나 양쪽다 안걸리는 경우를 방지하기 위함이다 두 스레드가 협업하는 과정에서
하나의 객체에 접근하는 조건이 있을 텐데 이 개발 의도와 다르게 맘대로 바뀔 수 있기 때문이다

두번째는 notify의 wait 하고 있는 스레드가 없다면 notify가 아무런 행동도 하지 않고 소멸하는 매커니즘에 있다

만약 Synchronized 안에서 두 스레드가 동작하지 않는다면 스레드의 속도차이 등에서
notify 가 wait 보다 먼저 실행 될 경우가 생길 수 있고,
이때 결국 notify는 wait가 없다고 판단하고 소멸될 것이다

이러한 이유 때문에 wait 과 notify는(notifyAll) 메소드들은 Synchronized 내부에서만 사용되야한다


### java의 condition
자바는 위에서 사용되는 condition(상태) 를 이용하여 깐깐하게 동작하는 세마포어의 notify (wait하는 스레드가 없어도 
notify를 실행된다면 소멸하지 않고 계속해서 wait)
혹은 계속 해서 확인하고 조건문으로 상태를 확인하고 있는 busy-wait 방법 사이의 중간 타협점을 찾았다고 볼 수 있다

스레드의 상태를 생성, 실행대기, 일시 정지, 실행, 종료 5가지로 나눔으로써 스레드의 상태를 확인할 수 있고, 이를통해
코드의 복잡성과 CPU 자원의 과사용의 문제점을 중간에서 타협할 수 있도록 했다

### 5.5 스레드의 안전한 종료(stop 플래그, interrupt())
스레드의 종료를 위해 stop()이라는 메소드를 제공했는데 이 메소드는 갑작스러운 스레드의 종료로 인해 사용중이던 자원들이
불안전한 상태로 남겨지기 때문에 deprecated 되었다 때문에 stop 플래그를 사용하거나 interrupt 를 이용해서 사용중이던
스레드 자원을 반납한 후에 스레드를 종료시켜야 한다 총 3가지의 스레드 stop 방법이 있다

1. stop flag
```java
    public class XXXThread extends Thread {
    private boolean stop; //stop 플래그 필드
    
    //다른 스레드에서 setStop을 이용해 중지 시킬수 있다
    public void setStop(boolean stop) {
        this.stop = stop;
    }
    
    public void run() {
        while (!stop) {
            //스레드가 반복하는 코드;
        }
        //스레드가 사용한 자원 정리
    }
}
```

2. interrupt를 이용한 try-catch 블록

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-24%20170124.png)

다만 interrupt() 메소드가 실행되면 즉시 InterruptException 예외가 발생하지 않고, 스레드가 미래에 일시 정지
상태가 되면 InterruptedException 예외가 발생한다

따라서 스레드가 일시 정지 상태가 되지 않으면 interrupt() 메소드 호출은 의미가 없다
때문에 Thread.sleep() 이라는 스레드를 일시정지 시켜주는 장치가 꼭 존재해야한다

3. interrupted() , isInterrupted()

하지만 스레드를 일시정지 상태로 만들지 않고도 interrupt() 호출 여부를 알 수 있는 방법이 있다
interrupt() 메소드가 호출되었다면 스레드의 interrupted(), isInterrupted() 메소드는 true를 리턴한다

interrupted() 는 정적 메소드로 현재 스레드가 interrupted 되었는지 확인

isInterrupted는 인스턴스 메소드로 현재 스레드가 interrupted 되었는지 확인할 때 사용

```java
    boolean status = Thread.interrupted();
    boolean status = objThread.isInterrupted();
```
```java
    public class PrintThread2 extends Thread {
    public void run() {
        while(true) {
            System.out.println("실행중");
            if (Thread.interrupted()) {
                break;
            }
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}
```

##6 데몬스레드
데몬스레드는 주 스레드의 작업을돕는 보조적인 역할을 수행하는 스레드이다 주 스레드가 종료되면 강제적으로 종료된다
적용 예로는 워드프로세서의 자동 저장, 미디어 플레어이어의 동영상 및 음악 재생, 가비지 컬렉터 등이 있다.


```java
    public static void main(String[] args) {
        AutoSaveThread thread = new AutoSaveThread();
        thread.setDaemon(true); //데몬 스레드 생성 (사실상 명시)
        thread.start(); // 주 스레드 시작
    }
    
    //사실상 일반 스레드 만드는것과 다를바 없다. 다만 thread.start() 전에 setDaemon(true)을 통해서
    //데몬스레드 생성해줄것
    public class AutoSaveThread extends Thread{}
```

다만 주의 해야할 점은 위 코드 처럼 setDaemon() 메소드는 주 스레드가 동작하기 전에 선언해줘야만
IllegalThreadStateException 이 발생하지 않는다

#### isDaemon()
데몬스레드일 경우 true 리턴한다

##7 스레드 그룹
관련된 스레드를 묶어서 관리할 목적으로 이용된다

JVM의 경우 JVM이 실행되면 system 스레드 그룹을 만들고, JVM 운영에 필요한 스레드들을 생성해서 system 스레드 그룹에 포함시킨다

그리고 하위 스레드 그룹으로 main을 만들고 메인 스레드를 main 스레드 그룹에 포함시킨다 스레드는 반드시 하나의
스레드 그룹에 포함되는데 스레드 그룹을 명시적으로 포함시켜 주지 않으면 기본적으로 자신을 생성한 스레드와 같은 스레드 그룹에 속하게 된다
### 7.1 스레드 그룹 이름얻기

```java
    ThreadGroup group = Thread.currentThread().getThreadGroup();
    String groupName = group.getName();
```

Thread의 정적 메소드인 getAllStackTraces() 를 이용하면 프로세스 내에서 실행하는 모든 스레드에 대한 정보를 얻을 수 있다

```java
    //key값 = Thread객체, value = Thread의 상태 기록
    Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
```

### 7.2 스레드 그룹생성

```java
    ThreadGroup tg = new ThreadGroup(String name);
    ThreadGroup tg = new ThreadGroup(ThreadGroup parent, String name);
```

위와같은 방법으로 새로운 스레드 그룹을 만들고, 이 그룹에 스레드들을 포함시키려면 Thread객체를 생성할 때 생성자
매개값으로 스레드 그룹을 지정하면 된다

```java
    //스레드 그룹을 매개값으로 갖는 Thread 생성자는 4가지가 있다
    //target: Runnable 가능한 구현객체 (스레드), name: 스레드 이름, stackSize: JVM이 스레드에 할당할 stack의 크기
    Thread t = new Thread(ThreadGroup group, Runnable target);
    Thread t = new Thread(ThreadGroup group, Runnable target, String name);
    Thread t = new Thread(ThreadGroup group, Runnable target, String name, long stackSize);
    Thread t = new Thread(ThreadGroup group, String name);
```

### 7.3 스레드 그룹의 일괄 interrupt()

스레드 그룹의 interrupt()를 이용하여 그룹 내부의 스레드를 모두 일괄 종료 시킬 수 있다

스레드 그룹의 interrupt() 메소드는 소속된 스레드의 interrupt() 메소드를 호출만 할 뿐 개별 스레드에서 발생하는
InterruptedException에 대한 예외 처리를 하지 않는다

따라서 interrupt 신호는 한번 주더라도 스레드 그룹의 내부 스레드들에 대한 안전한 종료를 위해서는 개별적인 예외처리가 필요하다

####TrheadGroup 의 주요 메소드

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-25%20141712.png)

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-25%20141734.png)

##8 스레드풀

스레드 풀은 작업처리에 사용되는 스레드를 제한된 개수만큼 정해 놓고, 작업 Queue에 들어오는 작업들을 하나씩 스레드가 맡아
처리하는 방법이다

보통 병렬 작업 처리가 많아지면 스레드 개수가 증가되고, 증가된 스레드의 생성과 스케줄링을 위해 CPU가 바빠져 
메모리 사용량이 높아진다. 이는 에플리케이션의 성능을 저하시키는데

제한된 수의 스레드를 사용하는 스레드 풀을 사용하면 위의 문제가 해결되어 어플리케이션의 성능이 저하되는것을 막을 수 있다

자바에서 스레드풀을 사용할 수 있도록 java.util.concurrent 패키지에서 Executors(클래스)의 다양한 정적 메소드를 이용하여
ExcutorService(인터페이스) 구현 객체를 만들 수 있는데 이것이 스레드풀이다

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-25%20150002.png)

### 8.1 스레드풀 생성 및 종료

인터페이스인 ExecutorService 구현 객체는  Executors 클래스의 두가지 메소드 중 하나를 이용해서 생성할 수 있다

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-25%20162120.png)

초기 스레드: ExecutorService 객체가 생성될 때 기본적으로 생성되는 스레드 수
코어스레드: 스레드 수가 증가된 후 사용되지 않는 스레드를 스레드 풀에서 제거할 때 최소한 유지해야 할 스레드 수
최대 스레드: 스레드 풀에서 관리하는 최대 스레드 수

####newCachedThreadPool()
스레드 개수보다 작업 개수가 많을때 새 스레드를 생성시켜 작업을 처리한다

이론적으로는 int값이 가질 수 있는 최대값 만큼 스레드가 추가되지만, 운영체제의 성능과 상황에 따라 달라진다
1개 이상의 스레드가 추가되었을 경우 60초 동안 추가된 스레드가 아무 작업을 하지 않으면 추가된 스레드를 종료하고
풀에서 제거한다

```java
    ExecutorService executorService = Executors.newCachedThreadPool();
    
```

####newFixedThreadPool(int nThreads)
코어 스레드 수를 매개변수로 줄 수 있고, 스레드 개수보다 작업개수가 많으면 새 스레드를 생성시키고 작업을 처리한다
이 스레드 풀은 스레드가 작업을 처리하지 않고 놀고 있더라도 스레드 개수가 줄지 않는다

```java
    //CPU의 코어 수만큼 최대 스레드를 사용하는 스레드풀 생성
    ExecutorService executorService = Executors.newFixedThreadPool(
        Runtime.getRuntime().availableProcessors()
    );
```

####Custom ThreadPool 생성
만약 두가지 메소드를 사용하지 않고, 코어 스레드 개수와 최대 스레드 개수를 설정하고 싶다면 직접 ThreadPoolExecutor 객체를 
생성하면 된다

```java
    //초기 스레드 0개, 코어스레드 3개, 최대스레드 100개, 
    // 코어스레드 3개를 제외한 나머지 스레드는 120초간 놀수 있는경우 제거
    ExecutorService threadPool = new ThreadPoolExecutor(
        3, //코어 스레드 개수
        100, //최대 스레드 개수
        120L, //놀고 있는 시간
        TimeUnit.SECONDS, //놀고 있는 시간 단위
        new SynchronousQueue<Runnable>() //작업 Queue
    );
```

#### 스레드풀의 종료
스레드 풀의 스레드는 기본적으로 데몬 스레드가 아니기 때문에 main 스레드가 종료되더라도 작업을
저리하기 위해 계속 실행 상태로 남아 있다 때문에 어플리케이션을 종료시키려면 스레드풀을 종료시켜 스레드들이 종료상태가
되도록 처리해줘야한다

ExecutorService는 종료와 관련해 메소드를 제공하고 있다

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-25%20162219.png)

```java
    //남아있는 작업을 마무리하고 스레드 풀을 종료할 때에는 shutdown()을 일반적으로 호출하고
    executorService.shutdown();
    //남아있는 작업과 상관없이 종료할 때에는 shutdownNow()를 호출한다
    executorService.shutdownNow();
```

###8.2 작업 생성과 처리 요청
#### 작업생성
하나의 작업은 Runnable 또는 Callable 구현클래스로 표현한다
```java
    //Runnable 구현 클래스
    Runnable task = new Runnable() {
        
        @Override
        //Runnable 의 경우 리턴이 존재 하지 않는다
        public void run() {
            //스레드가 처리할 내용
    }
}
```

```java
    //Callable 구현 클래스
    Callable<T> task = new Callable<T>() {
    @Override
    public T call() thorws Exception {
        //스레드가 처리할 작업 내용
        return T;
    }    
}
```

스레드 풀의 스레드는 작업 큐에서 Runnable 또는 Callable 객체를 가져와 run()과 call() 메소드를 실행한다

####작업 처리 요청
ExecutorService 의 작업 큐에 Runnable 또는 Callable 객체를 넣는 행위

ExecutorService의 작업처리 요청 관련 메소드

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-25%20163343.png)

####execute()와 submit() 메소드의 차이점
execute(): 작업처리 결과를 받지 못하고, 작업처리 도중 예외가 발생하면 스레드가 종료되고 해당 스레드는 스레드풀에서 제거된다

submit(): 작업처리 결과를 받을 수 있도록 Future를 리턴, 작업 처리 도중 예외가 발생하더라도 스레드는 종료되지않고, 다음작업을
위해 재 사용된다 스레드의 생성 오버헤더를 줄이기 위해서 submit() 을 사용하는것을 권장한다