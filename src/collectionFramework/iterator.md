# Iterator (반복자)

![](https://github.com/syhojeo/Java-Study/blob/main/image/61.png)

Iterator (반복자)는 주로 이름 그대로 데이터들을 묶는 List나 Map, Set과 같은 Collection에서 사용된다.

Iterator 는 컬렉션이 상속하는 인터페이스로써 모든 컬렉션 프레임워크에서 Iterator를 이용하여 반복할 수 있게 만들어준다

## Iterator 를 사용하는 이유

집합체를 다룰때는 개별적인 클래스에 대해 데이터를 읽는 방법을 알아야 하기 때문에 각 컬렉션에 접근이 힘들어진다
Iterator 를 쓰게 되면 어떤 컬렉션이라도 동일한 방식으로 접근이 가능하여 그안에 있는 항목들에 접근할 수 있는
방법을 제공한다(다형성)

### next()
next()는 데이터들을 중복없이 하나 씩 꺼낼 수 있게 해준다. List 처럼 저장된 데이터의 순서가 있는 경우를
제외하고는 next()는 데이터의 저장 순서와 상관없이 무작위로 꺼낸다.

## 동작방식 (ArrayList)
Iterator의 인스턴스는 new를 사용하지 않고, Collection인스턴스의 iterator()를 통해 내부적으로 생성되어 리턴된다
Collection<E>은 Iteratable<E>를 상속받고 있고, 이것은 iterator() 메소드의 구현을 강제시킨다

ArrayList의 iterator()를 보면 이해할 수 있다
```java
    public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    //..
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {

        int cursor;       // 리턴할 다음 index.
        int lastRet = -1; // 가장 마지막에 리턴한 요소의 index. 없을 경우 -1리턴
        int expectedModCount = modCount; //ArrayList의 modCount 개수 복제

        Itr() {
        }

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            //ArrayList의 modCount와 expectedModCount 비교
            //ArrayList가 중간에 수정, 삭제, 삽입이 있었는지를 확인한다
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            //ArrayList의 배열을 그대로 복사
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            //복사된 배열을 순서대로 하나씩 리턴
            return (E) elementData[lastRet = i];
        }
    }
}
```

Iterator 인스턴스는 new를 사용하지 않고, Collection 인스턴스의 iterator()를 통해 내부적으로 생성된다

좀 더 쉬운 이해를 위해 Iterator를 사용하는 간단한 예를 들어보자

```java
    public void method() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
    }
```

![](https://github.com/syhojeo/Java-Study/blob/main/image/63.png)

list.add()를 통해 내부 배열 elementData에 데이터가 저장된 모습이다. list 이기 때문에 Iterator 인스턴스인 it의
cursor는 인스턴스 초기값인 인덱스 0을 가지고 있다. while(it.hasNext())로 cursor가 요소의 끝까지 갈 때까지 반복한다

![](https://github.com/syhojeo/Java-Study/blob/main/image/64.png)

반복문에서 첫번째로 next()가 실행되면 cursor로 가리키고 있던 값을 lastRet으로 대신 가리키도록 하고(lastRet = i),
cursor는 i + 1 로 다음 요소를 가리킨다

![](https://github.com/syhojeo/Java-Study/blob/main/image/65.png)

두번째 next()

![](https://github.com/syhojeo/Java-Study/blob/main/image/66.png)

세번째 next() 이후 cursor가 size와 같은 인덱스 3을 가리키는 순간 hasNext()에서 false를 리턴하게 되고, while문을
종료하게된다

## ModCount와 ConcurrentException (ArrayList에서 Iterator 주의해야할 사항)

ArrayList에서 Iterator를 사용할 경우 생기는 문제가 있다 바로 next()로 읽어오는 while문 안에서
ArrayList에 대한 삽입, 삭제, 수정등의 행동을 해서는 안된다는 것이다

next() 메소드를 살펴보면 checkForComodification()가 있다 이 메소드에서는 modCount와 expectedModCount를
비교하여 같지않다면 데이터의 변화가 있었다고 생각하고 ConcurrentModificationException을 던진다

modCount는 ArrayList의 데이터 변화 (삭제, 수정, 삽입 등) 이 일어나면 하나씩 카운트가 되는 변수이며

expectedModCount는 Iterator 객체가 처음 생성될때 modCount 개수를 그대로 복사해오며, 이 값을 modCount와 비교하여
ArrayList에서 Iterator 객체가 생성된 후로 데이터의 변화(삭제, 수정, 삽입 등)이 일어났는지에 대해서 확인한다

```java
    while(it.hasnext()){
        String a = it.next();
        System.out.println(a);
        list.remove(a);
    }
```

위와 같은 코드를 작성시 list.remove() 메소드가 실행되면 ArrayList의 데이터 변화를 카운팅하는 modCount는 증가하는데
Iterator의 실행횟수를 카운팅하는 expectedModCount는 증가하지 않기 때문에

checkForComodification() 메소드에서 데이터의 변화가 있었다고 판단하고 ConcurrentModificationException을 던진다

때문에 위의 코드와 같이 생성한 Iterator의 next()를 더이상 실행시키지 않을때까지는 next() 메소드 사이에 
ArrayList의 데이터 변화를 주어서는 안된다

## 회피 방법
1. break로 반복문을 강제 탈출하여 next()를 실행하지 않도록한다

2. ArrayList.remove() 가 아닌 Iterator.remove()를 사용하여 expectedModCount에 modCount를 다시 복사한다

3. Iterator를 사용하지 않는다

```java
    while (!list.isEmpty()) {
        String s = list.get(0);
        System.out.println(s);
        list.remove(s);
    }
```

하지만 list는 가변 배열과 같기 때문에 인덱스를 통해 데이터를 추출하는 get()과 remove()를 하나의 트랜잭션에서
같이 사용하면서 원하는 값을 추출하기 위해서는 주의하며 사용하여야한다 때문에 멀티쓰레드에서의 안전성을 보장받지는 못한다

4. ArrayList가 아닌 CopyOnWriteArrayList를 사용하여 수정 메서드에 대해 Thread-safe를 보장해야한다

CopyOnWriteArrayList의 iterator()는 호출될시 현재 list의 데이터 배열을 참조하여 저장한다 (snampshot)
add()나 remove() 같은 동작은 새로운 배열을 복사(deep Clone)하여 작업하기 때문에 life-time 동안 snapshot은
변경되지 않으며 이는 ConcurrentModificationException을 발생시키지 않는것을 보장한다

(deep clone을 통하여 복사하기 때문에 ModCount가 카운트 되지않아 Exception을 발생시키지 않는다)
또한 수정 메서드들은 synchronized가 되어 있기 때문에 Thread-safe하다

결론: 스레드가 멀티스레드 환경인지 싱글스레드환경인지에 따라서 사용방법을 다르게 하는게 좋다

-----------------------------------------------------------------------------------------------------

Iterator는 각 컬렉션마다 구현된 함수가 다르기 때문에 각 컬렉션마다 Iterator를 다루는 방법이 다르고 이에 따라 생기는
주의사항도 다르기때문에 각 컬렉션 마다 Iterator의 메커니즘에 대해서 이해하고 적절히 사용해야할 필요가 있다