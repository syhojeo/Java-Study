# 컬렌션 프레임 워크

자료구조를 바탕으로 객체들을 효율적으로 추가, 삭제, 검색 할 수 있도록 java.util 패키지에 컬렉션과
관련된 인터페이스와 클래스들이 포함되어있다. 이것들을 총칭한것을 **컬렉션 프레임워크**라고 한다

컬렉션 프레임워크의 주요 인터페이스

![](https://github.com/syhojeo/Java-Study/blob/main/image/17.png)

List와 Set은 객체를 추가, 삭제, 검색하는 방법에 공통점이 많아 Collection 인터페이스로 모아 정의해 두고 있고,
Map의 경우 따로 정의되어 있다.

![](https://github.com/syhojeo/Java-Study/blob/main/image/18.png)

## [1. List 컬렉션](https://github.com/syhojeo/Java-Study/tree/main/src/collectionFramework/list)

객체를 저장하면 자동으로 인덱스가 부여되고, 인덱스로 객체를 검색, 삭제할 수 있는 기능을 제공한다

동일한 객체를 중복 저장할 수 있고, null도 저장이 가능한데 이경우 해당 인덱스는 객체를 참조하지 않는다

![](https://github.com/syhojeo/Java-Study/blob/main/image/19.png)


List 컬렉션 메소드

![](https://github.com/syhojeo/Java-Study/blob/main/image/20.png)

ex)
```java
    List<String> list = ...;
    //add
    list.add("홍길동"); //맨끝에 객체 추가
    list.add(1, "신용권") // 지정된 인덱스에 객체 삽입
    //get
    String str = list.get(1) // 인덱스로 객체 찾기
    //remove
    list.remove(0); //인덱스로 객체 삭제
    list.remove("신용권") //객체 삭제
```

### 1.1 ArrayList

List 인터페이스의 구현 클래스로, 인덱스로 객체를 관리한다는 점에서 일반 배열과 매우 유사하지만 큰차이가 있다

배열은 생성할 때 크기가 고정되고, 사용 중에 크기를 변경할 수 없지만, 

ArrayList는 저장 용량(capacity)을 초과한 객체들이 들어오면 자동적으로 저장 용량(capacity)이 늘어난다

#### ArrayList 내부구조

![](https://github.com/syhojeo/Java-Study/blob/main/image/21.png)

```java
    //저장 용량 (capacity) = 10으로 시작
    List<T> list = new ArrayList<T>();

    //저장 용량 (capacity)를 설정하고 싶을때
    List<T> list = new ArrayList<T>(capacity);
```

#### ArrayList 특징

객체를 추가하면 인덱스 0부터 차례대로 생성된다

객체를 제거하면 모두 앞으로 1씩 인덱스가 당겨진다

특정 인덱스에 객체를 삽입하면 해당 인덱스부터 마지막 인덱스까지 모두 1씩 밀려난다

=> 따라서 빈번한 객체 삭제와 삽입이 일어나는 곳에서는 ArrayList는 바람직하지 않고 LinkedList를 사용하는것이 좋다

그러나 인덱스 검색이나, 맨마지막에 객체를 추가하는 경우에는 ArrayList가 더 좋은 성능을 발휘한다



#### 고정된 객체들로 구성된 List (Arrays.asList(T... a))

List를 선언할때 초기값을 넣어버리는 방법으로는 Arrays.asList를 사용한다

추가, 검색, 삭제등의 메소드는 ArrayList와 동일하다

```java
    List<T> list = Arrays.asList(T...a);

    //ex
    List<String> list1 = Arrays.asList("홍길동", "신용권", "감자바");
    for (String name : list1) {
        System.out.println(name);
    }
    
    List<Integer> list2 = Arrays.asList(1, 2, 3);
    for (int value : list2) {
        System.out.println(value);
    }
```

#### remove를 반복할때에는 iterator(반복자) 를 사용하는것이 좋다

```java
    ArrayList<Integer> nums = new ArrayList<Integer>();
    nums.add(1);
    nums.add(3);
    nums.add(5);
    nums.add(7);
    Iterator<Integer> it = nums.iterator();
    while(it.hasNext()) {
        Integer i = it.next();
        if (i < 5) {
            it.remove();
    }
    }
```

### 1.2 Vector

Vector는 ArrayList와 동일한 내부 구조를 가지고 있다

다른 점은 동기화된(synchronized) 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 이 메소드들을
실행 할 수 없고, 하나의 스레드가 실행을 완료해야만 다른 스레드를 실행할 수 있다

때문에 멀티 스레드 환경에서 안전하게 객체를 추가, 삭제할 수 있다 (Thread safe)

#### Vector의 내부 구조
![](https://github.com/syhojeo/Java-Study/blob/main/image/22.png)

```java
    List<E> list = new Vector<E>();
```


### 1.3 LinkedList

List의 구현 클래스이므로 ArrayList와 사용방법은 똑같지만 내부 구조는 완전 다르다

#### LinkedList 특징

LinkedList에서 특정 인덱스의 객체를 제거하면 앞뒤 링크만 변경되고 나머지 링크는 변경되지 않는다

객체를 삽입 할때에도 앞뒤 링크만 변경된다

![](https://github.com/syhojeo/Java-Study/blob/main/image/24.png)

#### LinkedList의 내부 구조

![](https://github.com/syhojeo/Java-Study/blob/main/image/23.png)

```java
    List<E> list = new LinkedList<E>();
```

#### LinkedList vs ArrayList

![](https://github.com/syhojeo/Java-Study/blob/main/image/25.png)

## [2. Set 컬렉션](https://github.com/syhojeo/Java-Study/tree/main/src/collectionFramework/set)

List 컬렉션은 저장 순서를 유지하지만, Set 컬렉션은 저장 순서가 유지되지 않는다

또한 객체를 중복해서 저장할 수 없고, 하나의 null만 저장할 수 있다

#### set 컬렉션 구조

![](https://github.com/syhojeo/Java-Study/blob/main/image/49.png)
1. HashSet: 순서가 필요없는 데이터를 Hashtable(Hash알고리즘의 hashtable)에 저장 Set중에 가장 성능이 좋다
2. TreeSet: 저장된 데이터의 값에 따라 정렬됨 red-black tree 타입으로 저장되며 HashSet보다 성능이 느리다
3. LinkedHashSet: 연결된 목롭 타입으로 구현하여 Hashtable에 데이터 저장 저장된 순서에 따라 
값이 정렬 셋중에 가장느리다

![](https://github.com/syhojeo/Java-Study/blob/main/image/26.png)


#### set 컬렉션 인터페이스 메소드
![](https://github.com/syhojeo/Java-Study/blob/main/image/27.png)

ex)
```java
    Set<String> set = ...;
    set.add("홍길동"); //객체 추가
    set.add("신용권");
    set.remove("홍길동"); //객체 삭제
```

Set 컬렉션은 인덱스로 객체를 검색해서 가져오는 **get()메소드**가 없다

대신, 전체 객체를 대상으로 한번씩 반복해서 가져오는 **반복자(Iterator)를** 제공한다

```java
    Set<String> set = ...;
    Iterator<String> iterator = set.iterator();
    //저장된 객체 수만큼 루핑
    while(iterator.hasNext()) { // hasNext() : 가져올 객체가 있으면 true, 없으면 false 리턴
        //String 객체 하나를 가져옴
        String str = iterator.next(); // next() : 컬렉션에서 하나의 객체를 가져온다
        //"홍길동" 제거
        if (str.equals("홍길동")) {
            iterator.remove();
    }
    }
    
    //혹은 향상된 for문 사용하기
    Set<String> set = ...;
    for (String str : set) {
    }
```

### 2.1 HashSet

Set 인터페이스의 구현 클래스이다 객체들을 순서 없이 저장하고(Iterator로 읽어올 시 순서가 랜덤으로 읽어진다) 
반면 LinkedHashSet의 경우 입력한 순서를 기억하여 저장한다

[Hash 알고리즘](https://github.com/syhojeo/Java-Study/tree/main/src/collectionFramework/Hash.md)

동일한 객체는 중복 저장하지 않는다

### HashSet 의  add() 매커니즘
HashSet 은 Set 의 구현 인터페이스 이기 때문에 add() 할때 마다 중복되는 객체가 저장되어 있는지를 확인해야한다


HashSet이 판단하는 동일한 객체란 꼭 같은 인스턴스를 뜻하지 않는다 (논리적으로 동등한 객체 확인한다)
때문에 오버라이딩 된 hashCode와 equals를 사용하여 비교한다

1. HashSet은 객체를 저장하기 전에 객체의 HashCode() 메소드를 호출하여 해시코드를 얻어낸다
2. 저장되어 있는 객체들의 해시코드와 비교한다. 
3. 만약 동일한 해시코드가 있다면 다시 equals() 메소드로 두객체를 비교해서 true가 나오면 동일한 객체로 
판단하고 중복저장을 하지 않는다

![](https://github.com/syhojeo/Java-Study/blob/main/image/28.png)

HashCode 비교 (클래스가 같은지) -> equals 비교 (객체가 같은지) -> 저장

#### hashCode와 equals 를 두번 비교하는 이유
**1. hashCode가 같아도 equals는 false 로 나올 수 있기 때문이다**

hashCode는 기본적으로 int 형 정수로 리턴되는 값이기 때문에 아주아주아주 낮은 확률로 객체가 다르더라도
정수값이 같을 수 있다 때문에 속도가 빠른 Hashcode로 거르고 equals 메소드로 정확히 확인한다

**2. hashCode가 equals 보다 연산 속도가 빠르다**

equals 메소드는 값을 하나씩 비교해서 검증하기 때문에 시간이 걸리는 반면 해시값은 간단한 계산의 결과만 가지고
비교하기 때문에 상대적으로 속도가 빠르다. 객체 안의 필드값이 많을 수록 속도 차이가 많이 나게 된다

[hashCode와 equals 추가 설명](https://github.com/syhojeo/Java-Study/blob/main/src/basicApiClass/object/outline.md)

ex) HashSet 사용법
```java
    Set<E> set = new HashSet<E>();
```

## [3. Map 컬렉션](https://github.com/syhojeo/Java-Study/tree/main/src/collectionFramework/map)
Map 컬렉션은 키(key)와 값(value)로 구성된 Entry 객체를 저장하는 구조를 가지고 있다. Key과 value 는
모두 객체이며 Key는 중복 저장될 수 없지만 value는 중복 저장될 수 있다

**HashSet 과 반대로 기존에 저장된 Key가 동일한 Key로 저장하면 기존의 값은 없어지고, 새로안 값으로 대치된다**

![](https://github.com/syhojeo/Java-Study/blob/main/image/29.png)

Map 컬렉션에는 HashMap, Hashtable, LinkedHashMap, Properties, TreeMap 등이 있다

다음은 Map 에서 사용 하는 메소드이며 K와 V는 Key값과 Value값의 제네릭 타입이다

![](https://github.com/syhojeo/Java-Study/blob/main/image/30.png)
![](https://github.com/syhojeo/Java-Study/blob/main/image/31.png)

```java
    //Map method 사용 예시
    Map<String, Integer> map = ~;
    map.put("홍길동", 30); //객체 추가
    int score = map.get("홍길동") //객체 찾기
    map.remove("홍길동") //객체 삭제
```

전체 객체를 대상으로 값을 탐색을 진행하고 싶을때 2가지 방법

```java
    //1. keySet() 메소드를 이용한 Set의 반복자 사용
    Map<K, V> map = ~;
    //반복자 사용을 위해 map의 keySet을 이용하여 Set 선언
    Set<K> keySet = map.keySet();
    //Set 객체를 이용한 Iterator 선언
    Iterator<K> keyIterator = keySet.Iterator();
    while(keyIterator.hasNext()) {
        //반복자로 순서대로 key값을 가져온다음
        K key = keyIterator.next();
        //가져온 key값을 매개변수로 get() 메소드 호출
        V value = map.get(key);
    }
    
    //2. entrySet() 메소드를 이용한 반복자 사용
    Map<K, V> map = ~;
    //반복자 사용을 위해 map의 entrySet을 이용하여 Set 선언
    Set<Map.Entry<K, V>> entrySet = map.entrySet();
    //Set 객체를 이용한 Iterator 선언
    Iterator<Map.Entry<K, V>> entryIterator = entrySet.iterator();
    while(entryIterator.hasNext()) {
        Map.Entry<K, V> entry = entryIterator.next();
        K key = entry.getKey();
        V value = entry.getValue();
    }
```

### keySet과 entrySet의 차이
KeySet은 key만 Set으로 반환하는데 비해 entrySet은 key와 value값 모두를 Set으로 반환한다

때문에 KeySet의 경우 value값을 찾아아야하는데 Map을 다시 재탐색하는 비용이 추가로 소모된다

만약 Key값과 Value값을 모두 탐색해야 한다면 entrySet을 사용하는것이 좋다


## 3.1 HashMap
HashMap은 Map 인터페이스를 구현한 대표적인 Map 컬렉션이다

HashMap의 Key로 사용한 객체는 hashCode()와 equals() 메소드를 재정의 해서 동등 객체가 될 조건을 
정해야 한다.

동등 객체, 즉 동일한 키가 될 조건은 hashCode()의 리턴값이 같아야하고, equals() 메소드가 true를 리턴해야 한다

![](https://github.com/syhojeo/Java-Study/blob/main/image/32.png)

**hashCode()와 euqals() 메소드를 사용하여 중복체크를 하기 때문에 반드시 두 메소드를 오버라이딩 하여
동등 객체가 될 조건을 정해야 중복관련 문제가 발생하지 않는다**

HashMap 생성
```java
    Map<K, V> map = new HashMap<K, V>();
```

**키와 값은 기본타입(boolean, char, int .. )을 사용할 수 없고, 클래스 및 인터페이스 타입만 가능하다
(String, Integer ...)**

## 3.2 Hashtable

Hashtable은 HashMap과 동일한 내부 구조를 가지고 있다 Hashtable 또한 HashMap과 같이 hashCode(), equals()
메소드를 재정의 하여 동등 객체가 될 조건을 정해야 한다

차이점은 Hashtable은 동기화(synchronized) 메소드로 구성되어 있기 대문에 멀티 스레드가 동시에 이 메소드들을
실행할 수는 없고, 하나의 스레드가 실행을 완료해야만 다른 스레드를 실행할 수 있다

때문에 멀티 스레드 환경에서 안전하게 객체를 추가, 삭제할 수 있고 이것을 Thread safe라고 한다

ex) Hashtable 사용법
```java
    Map<K, V> map = new Hashtable<K, V>();
```

## 3.3 Properties

Properties 는 Hashtable의 하위 클래스익 때문에 특징을 그대로 가지고 있지만 Key와 value를 String 타입으로만
제한한 컬렉션이다

### 특징
Properties 는 String 타입을 가지고 있기 때문에 주로 애플리케이션의 옵션 정보, 데이터베이스 연결정보, 
국제화(다국어) 정보가 저장된 .properties 파일을 읽을때 주로 사용한다

프로퍼티 파일은 ``Key = value`` 형식으로 연결되어 있는 텍스트 파일로 ISO 8859-1 문자셋으로 저장되나
표현할 수 없는 문자들은(한글) 유니코드로 변환되어 저장된다

ex)
``contry = 대한민국 => contry=\uB300\uD55\uBBFC\uAD6D``

### 사용법
property 파일을 읽기 위해서는 Properties 객체를 생성하고, load() 메소드를 호출하면 되고
load() 메소드는 프로퍼티 파일로부터 데이터를 읽기 위해 FileReader 객체를 매개값으로 받는다
```java
    //path 상대경로 지정
    String path = 클래스명.class.getResource("database.properties").getPath();
    //path = C:/~/database.properties (절대경로)

    //경로에 한글이 있는경우 한글을 복원
    path = URLDecoder.decode(path, "utf-8)"); 
    //propertiess 객체 생성
    Properties prperties = new Properties();
    //FileReader로 load
    properties.load(new FileReader(path));
    //key값을 이용하여 value 값 얻기
    String value = properties.getProperty("key");
```

## 4. 검색 기능을 강화 시킨 컬렉션

컬렉션 프레임워크는 검색 기능을 강화시킨 TreeSet과 TreeMap을 제공하고 있다 
TreeSet은 Set을 강화시킨 컬렉션이고, TreeMap은 Map을 강화시킨 컬렉션이다

이러한 컬렉션들은 이진트리(binary tree)를 이용해서 계층적 구조(Tree 구조)를 가지면서 객체를 저장한다

## 4.1 이진트리 구조 (binary tree)

![](https://github.com/syhojeo/Java-Study/blob/main/image/33.png)

여러개의 node가 트리 형태로 연결된 구조로, root node 라고 불리는 하나의 node에서 부터 시작해서
각 node에 최대 2개의 node를 연결할 수 있는 구조를 가지고 있다

위아래로 연결된 두 노드를 부모 - 자식 관계로 부모노드, 자식노드로 부른다

### 이진트리 데이터 저장 방법
루트 노드가 생성되고 자식노드는 부모의 노드값보다 작으면 왼쪽, 크면 오른쪽에 위치시킨다

예를들어 6, 3, 9, 2, 5 의 순서로 값을 저장하면 다음과 같이 저장된다

![](https://github.com/syhojeo/Java-Study/blob/main/image/34.png)

숫자가 아닌 문자를 저장할 경우에는 문자의 유니코드 값으로 비교한다 

### 이진트리의 특징
이진트리로 데이터를 저장하면 왼쪽 마지막 노드가 제일 작은 값이 되고, 오른쪽 마지막 노드가 가장 큰값이 된다

#### 오름차순 정렬된 값 얻기
왼쪽 마지막 노드에서부터 오른쪽 마지막 노드까지(왼쪽 노드 -> 부모 노드 -> 오른쪽 노드) 순으로 읽기

#### 내림차순 정렬된 값 얻기
오른쪽 마지막 노드에서부터 왼쪽 마지막 노드까지 (오른쪽 노드 -> 부모 노드 -> 왼쪽 노드) 순으로 읽기

이진트리를 사용하면 값들이 정렬되어 있어 그룹핑이 쉬워지기 때문에 범위 검색을 쉽게 할 수 있다

![](https://github.com/syhojeo/Java-Study/blob/main/image/35.png)

## 4.2 TreeSet
이진트리를 기반으로한 Set 컬렉션이다

### 특징
노드값인 value와 왼쪽, 오른쪽 자식 노드를 참조하기 위한 두개의 변수로 구성된다

value 는 기본적으로 이진트리와 같이 왼쪽 자식노드에는 부모노드보다 작은값
오른쪽 자식 노드에는 부모 노드보다 큰값으로 정렬되어 저장된다
![](https://github.com/syhojeo/Java-Study/blob/main/image/36.png)

### 사용 예시
```java
    TreeSet<E> treeSet = new TreeSet<E>();
```

### TreeSet 메소드

#### 검색관련 메소드
![](https://github.com/syhojeo/Java-Study/blob/main/image/37.png)
![](https://github.com/syhojeo/Java-Study/blob/main/image/38.png)

#### 정렬 관련 메소드
![](https://github.com/syhojeo/Java-Study/blob/main/image/39.png)

descendingIterator() 메소드는 Iterator 를 리턴하므로 반복자를 사용하듯이 사용하면되고

descendingSet() 의 경우에는 NavigableSet<E> 타입을 리턴하는데
NavigableSet은 TreeSet과 마찬가지로 first(), last(), ... 등의 메소드를 제공하고, 정렬순서를 바꾸는
descendingSet()메소드를 제공한다

만약 오름차순으로 정렬하고 싶다면 descendingSet() 메소드를 두번 호출하면 된다
ex)
```java
    NavigableSet<E> descendingSet = treeSet.descendingSet();
    NavigableSet<E> ascendingSet = descendingSet.descendingSet();
```

#### 범위 검색 관련 메소드

![](https://github.com/syhojeo/Java-Study/blob/main/image/40.png)
![](https://github.com/syhojeo/Java-Study/blob/main/image/41.png)

객체의 포함 여부는 boolean 값이 true일 경우 포함한다

## 4.3 TreeMap

이진 트리를 기반으로 한 Map 컬렉션 Map 인터페이스 타입변수에 대입해도 되지만 
특정 객체를 찾거나 범위 검색과 관련된 메소드를 사용하기 위해서 TreeMap을 사용한다

TreeSet과의 차이점은 Key와 value가 저장된 Map.Entry를 저장한다는 점이다
또한 좌측 우측으로 정렬되는 기준값이 Key값이 된다

![](https://github.com/syhojeo/Java-Study/blob/main/image/42.png)

### 사용 예시
```java
    TreeMap<K, V> treemap = new TreeMap<k, V>();
```

### TreeMap 사용 메소드

#### 검색 관련 메소드

![](https://github.com/syhojeo/Java-Study/blob/main/image/43.png)

[ex) TreeMap의 검색 메소드](https://github.com/syhojeo/Java-Study/tree/main/src/collectionFramework/treeMap/TreeMapExample1.java)

#### 정렬 관련 메소드

![](https://github.com/syhojeo/Java-Study/blob/main/image/44.png)

[ex) TreeMap의 정렬 메소드](https://github.com/syhojeo/Java-Study/tree/main/src/collectionFramework/treeMap/TreeMapExample2.java)

#### 범위 검색 관련 메소드

![](https://github.com/syhojeo/Java-Study/blob/main/image/45.png)
![](https://github.com/syhojeo/Java-Study/blob/main/image/46.png)

[ex) TreeMap의 범위 검색 관련 메소드](https://github.com/syhojeo/Java-Study/tree/main/src/collectionFramework/treeMap/TreeMapExample3.java)

## 4.4 Comparable과 Comparator

TreeSet과 TreeMap은 정렬(자동 오름차순 binarytree)을 위해 java.lang.Comparable 구현한 객체를 요구한다

Integer, Double, String 타입은 모두 Comparable 인터페이스를 구현하고 있다

사용자 정의 클래스 또한 Comparable의 compareTo() 메소드를 오버라이딩하여 구현한다면 자동 정렬이 가능하다

![](https://github.com/syhojeo/Java-Study/blob/main/image/47.png)

위의 규칙에 맞게 CompareTo()를 오버라이딩 해주어야 한다

[ex) Comparable 구현](https://github.com/syhojeo/Java-Study/tree/main/src/collectionFramework/comparableAndComparator/ComparableExample.java)

하지만 TreeSet과 TreeMap의 Key가 Comparable을 구현하고 있지 않을 경우에는 저장하는 순간 ClassCastException이
발생한다

때문에 Comparable 비구현 객체를 정렬하려면 TreeSet 또는 TreeMap 생성자의 매개값으로 정렬자(Comparator)를
제공하면 Comparable 비구현 객체도 정렬시킬 수 있다

ex)
```java
    TreeSet<E> treeSet = new TreeSet<E>(new AscendingComparator()); //오름차순 정렬자
    TreeMap<K, V> treeMap = new TreeMap<K, V> (new DescendingComparator()); //내림차순 정렬자
```

정렬자는 Comparator 인터페이스를 구현한 객체를 말하는데 Comparator 인터페이스에도 Compare 메소드가 정의되어 있다

![](https://github.com/syhojeo/Java-Study/blob/main/image/48.png)

[ex) Comparator 구현](https://github.com/syhojeo/Java-Study/tree/main/src/collectionFramework/comparableAndComparator/ComparatorExample.java)

## 5. LIFO와 FIFO 컬렉션
후입선출(LIFO: Last In First Out) 나중에 넣은 객체가 먼저 빠져나가는 구조

ex) Stack - JVM 스택 메모리

선입선출(FIFO: First In First Out) 먼저 넣은 객체가 먼저 빠져나가는 구조

ex) Queue - 스레드풀의 작업 큐

![](https://github.com/syhojeo/Java-Study/blob/main/image/56.png)

## 5.1 Stack
Stack 클래스의 주요 메소드
![](https://github.com/syhojeo/Java-Study/blob/main/image/57.png)

```Java
    Stack<E> stack = new Stack<E>();
```
[ex) Stack 구현](https://github.com/syhojeo/Java-Study/tree/main/src/collectionFramework/stackAndQueue/StackExample.java)

## 5.2 Queue
Queue 인터페이스의 주요 메소드

![](https://github.com/syhojeo/Java-Study/blob/main/image/58.png)

Queue 인터페이스를 구현한 대표적인 클래스는 LinkedList이다 다음은 LinkedList객체를 Queue 인터페이스 타입으로
변환한 것이다 LinkedList는 List 인터페이스를 구현했기 대문에 List 컬렉션이기도 하다

```java
    Queue<E> queue = new LinkedList<E>();
```

[ex) LinkedList의 Queue 처럼 사용하기](https://github.com/syhojeo/Java-Study/tree/main/src/collectionFramework/stackAndQueue/QueueExample.java)

## 동기화된 컬렉션
컬렉션 프레임워크의 대부분의 클래스들은 싱글 스레드 환경에서 사용할 수 있도록 설계되었다. 때문에 Vector와 Hashtable
같이 동기화된 메소드로 구성되지 않은 ArrayList, HashSet, HashMap은 멀티스레드 환경에서 안전하지 않다

컬렉션 프레임워크는 비동기화된 메소드를 동기화된 메소드로 래핑하는 Collections 의 synchronizedXXX() 메소드를 제공
하고 있다 매개값으로 비동기화된 컬렉션을 대입하면 동기화된 컬렉션을 리턴한다

![](https://github.com/syhojeo/Java-Study/blob/main/image/59.png)

ex) 비동기화 컬레션 동기화하는 법
```java
    List<T> list = Collections.synchronizedList(new ArrayList<T>());
    Set<E> set = Collections.synchronizedSet(new HashSet<E>());
    Map<K, V> map = Collections.synchronizedMap(new HashMap<K, V>());
```

## 병렬 처리를 위한 컬렉션

동기화된 컬렉션은 멀티스레드 환경에서 요스를 안전하게 처리하도록 도와주지만 빠르게 처리하지는 못한다 
때문에 요소를 병렬적으로 처리할 수 있는 컬렉션을 제공한다

java.util.concurrent 패키지의 ConcurrentHashMap(Map 구현 클래스)과 
ConcurrentLinkedQueue(Queue 구현 클래스) 이다

ex) 사용법
```java
    Map<K, V> map = new ConcurrentHashMap<K, V>();
    Queue<E> queue = new ConcurrentLinkedQueue<E>();
```