# HashTable 알고리즘
## Hashing?
Hashing 이란 임의의 길이의 값을 Hash Function를 사용하여 고정된 크기의 값으로 변환하는 작업을 말한다

Hash Function에 dog를 넣었을때

`` f(dog) = 06d80eb0c50b49a509b49f2424e8c805``

이는 암호화에 쓰이는 Hash 알고리즘은 MD5를 사용하여 dog라는 문자를 Hashing한것이다

하지만 우리는 MD5를 사용하는것이 아닌 Hashing을 사용하여 데이터를 저장하는 자료구조를 공부해야한다

## 1. Direct Address Table
첫번째 자료구조로는 Direct Addres Table이 있다 이 자료구조는 간단하게 키값이 곧 value를 저장하는 주소명이다

```C
    char arr[1000];
    int key = 5;
    char value = 'v'
    
    arr[key] = value;
```

이경우 탐색, 삽입, 삭제 연산을 모두 O(1) 에 할 수 있지만 한계점이 존재한다

- 키값의 최대 값을 알고 있어야 배열의 크기를 정할 수 있다 (최대 키값이 작을때 실용적으로 사용 가능하다)
- 때문에 배열의 크기는 고정적이어야 하며 변동적일 수 없다
- 키 값들이 골고루 분포되어 있지 않다면 메모리 낭비가 심할 수 있다

이러한 한계점 때문에 HashTable을 사용한다

## HashTable?
![](https://github.com/syhojeo/Java-Study/blob/main/image/50.png)

HashTable은 (Key, Value)로 데이터를 저장하는 자료구조로 빠르게 데이터를 검색할 수 있는 자료구조이다 
기본연산으로는 탐색, 삽입, 삭제가 있다

HashTable은 Key값을 Hashing하고 이를 bucket(value가 저장되는 공간) 을 가리키는 주소(index)로 사용한다

ex)
```java
   public int Hashcode(int key) {
        return key % 10;
}   
```

위와 같은 HashFunction 가 있다면 HashTable의 최대 Key값을 몰라도 10이상의 크기를 가진 HashTable을 만든다면
모든 Key값들을 Hashing 할 수 있다 하지만 만약 key 값으로 100과 1000이 들어온다면 Hashing 된 index 는 0으로 충돌이
발생하게된다


## HashTable의 한계점
하지만 HashTable에도 한계점이 존재한다 바로 충돌(Collision)이다 충돌은 서로 다른 Key값이 Hashing 되었을때
같은 Hash값을 가지게 되는 경우이다 즉, Key값이 다른데 같은 bucket에 두개 이상의 value를 저장하는 경우를 충돌이 발생
했다고 한다

충돌은 적재율(Load Factor)이 1을 초과해서 발생하게 되는데 

Key의 개수를 K, HashTable의 크기를 N 이라 했을때 적재율은 K/N 이다

위의 Direct Address Table의 경우 항상 배열의 크기가 Key크기보다 크기 때문에 적재율이 1 이하로 유지된다.
하지만 HashTable 의 경우 적재율이 1이 초과할 경우가 발생하는데 이때 충돌이 발생하게 된다

충돌이 발생하지 않는다고 할경우 HashTable의 탐색, 삽입, 삭제 연산은 모두 O(1)에 수행되지만 충돌이 발생할 경우
탐색과 삭제 연산이 최악의 경우 O(K) 만큼 걸리게 된다

때문에 충돌을 최대한으로 줄여서 연산속도를 빠르게 하는것이 HashTable의 핵심이며 이를 위해 2가지 충돌을 완화하는 방법이 있다

1. HashTable의 구조개선
2. Hash Function 을 개선 (알맞은 Hash 알고리즘 구현)

## 충돌 개선1. HashTable의 구조개선
### 1. Chaining

![](https://github.com/syhojeo/Java-Study/blob/main/image/51.png)

Chaining 이란 충돌이 발생했을 때 이를 동일한 Bucket에 LinkedList 형태로 저장하는 방법을 말한다

삽입의 경우 상수 시간인 O(1) 이 걸리지만 탐색, 삭제의 경우 최악의 경우 Key값의 최대 개수인 K에 대해 O(K) 가 걸리게 된다

Chaining 의 평균 시간복잡도는 적재율을 a(K/N) 라 할때 O(a + 1)이다

### 2. Open Addressing
충돌이 발생하였을 경우 주변에 있는 다른 주소를 이용하여 value를 저장하는 기법이다 즉, 충돌이 발생되면 
처음 저장된 주소 주변에 밀집하여 value가 저장되게 된다

![](https://github.com/syhojeo/Java-Study/blob/main/image/52.png)

[HashTable 구조개선의 좀더 자세한 수학적 정리](https://itstory.tk/entry/%ED%95%B4%EC%8A%81%EC%97%90%EC%84%9C%EC%9D%98-%EC%B6%A9%EB%8F%99%ED%95%B4%EA%B2%B0Collision-Resolution)
### Open Address의 3가지 충돌 처리기법
### 1. 선형탐사 (Linear Probing)
![](https://github.com/syhojeo/Java-Study/blob/main/image/53.png)
선형 탐사는 가장 기본적인 충돌해결기법으로 바로 인접한 인덱스에 데이터를 삽입하기 때문에 데이터가 밀집되는 Clustering
문제가 발생하고 이로인해 탐색과 삭제가 느려지게 된다


### 2. 제곱탐사 (Quadratic Probing)

![](https://github.com/syhojeo/Java-Study/blob/main/image/54.png)

제곱탐사는 1^2, 2^2, 3^2.. 으로 탐사를 하는 방식으로 선형탐사에 비해 더 폭넓게 탐사하기 때문에 탐색과 삭제에
효율적일 수 있다. 하지만 이는 제곱의 폭이 적은 초기 해시값에서 충돌하는 경우에는 Clustering 문제가 발생하게 된다

### 3. 이중 해싱 (Double Hashing)
이중 해싱은 선형 탐사와 제곱탐사에서 발생하는 Clustering 문제를 모두 피하기 위해 도입 되었다

첫 Hash Function은 Key값의 Hasing을 위해 사용하고 두번째 Hash Fucntion은 충돌이 발생했을 떄 탐사폭을 계산하기 위해
사용되는 방식이다

![](https://github.com/syhojeo/Java-Study/blob/main/image/55.png)

위에서 배운 충돌 해결기법들을 비교해보면 적재율이 a에 따라서 위와같이 나오는데, 여기서 successful search는 찾고자
하는 데이터가 HashTable에 있는 경우이고, unsuccessful search는 없는 경우 이다

## 충돌 개선2. HashFunction 개선
## Hash Function
Hash Function 에서 중요한 것은 Key값을 이용하여 Value를 저장할 고유한 인덱스 값을 설정하는 것이다

### 대표적 Hash Function
#### 1. Division Method
나눗셈을 이용하는 방법으로 입력값을 테이블의 크기로 나누어 계산한다

(f(x) = key % 테이블의 크기) 테이블의 크기를 소수로 정하고 2의 제곱수와 먼값을 사용해야 효과가 좋다고 알려져있다
#### 2. Digit Folding
각 key의 문자열을 ASCII 코드로 바꾸고 값을 합한 데이터를 value의 index로 사용하는 방법

#### 3. Multiplication Method
0<A<1 인 A를 설정, h(k) = N * (kA mod 1) 

kA를 곱하고 나온 소수점을 N에 곱함으로써 Hashing 되어 나온 값이 절대로 HashTable의 최대 크기 N을 넘지 못하도록 한다  

#### 4. Univeral Hashing
다수의 Hash Function을 만들어 집합 H에 넣어두고, 무작위로 Hash Function을 선택해 Hash 값을 만들어 내는 기법

[HashFunction 개선의 좀더 자세한 수학적 정리](https://itstory.tk/entry/%ED%95%B4%EC%8A%81Hashing-%ED%95%B4%EC%89%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%95%B4%EC%89%AC-%ED%95%A8%EC%88%98)

## HashSet 에서의 Hash
https://siyoon210.tistory.com/144
## HashMap 에서의 Hash
위의 수학공식확인