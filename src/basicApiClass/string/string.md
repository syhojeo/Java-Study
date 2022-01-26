#String Class (java.lang.String)

String 문자열은 보통 소스상에서 문자열 리터럴로 자동 객체 생성되지만, String 클래스의 다양한 생성자를 이용해서 
직접 String 객체를 생성할 수도 있다.

##1. String 생성자
매개변수에 따라 사용 방법이 달라지는 13개의 생성자가 String 클래스에 존재하는데 가장 사용빈도수가 높은 것은
**파일의 내용을 읽거나, 네트워크를 통해 받은 데이터인 byte[]을 문자열로 변환하기 위해** 사용된다

``` 
    //배열 전체를 String 객체로 생성
    String str = new String(byte[] byte);
    //지정한 문자셋으로 디코딩
    //문자셋 = UTF-8, EUC-KR 등을 문자열을 어떻게 해석(디코딩)할지를 뜻함
    String str = new String(byte[] bytes, String charsetName);
    
    //배열의 offset 인덱스 위치부터 length만큼 String 객체로 생성
    String str = new String(byte[] bytes, int offset, int length);
    //지정한 문자셋으로 디코딩
    String str = new String(byte[] bytes, int offset, int length, String charsetName);
```


##2. String 메소드
String은 문자열의 추출, 비교, 찾기, 분리, 변환등과 같은 다양한 메소드를 가지고 있다

###2.0 자주 사용하는 메소드

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-20%20153117.png)

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-20%20163819.png)

###2.1 문자 추출 charAt()
매개값으로 주어진 인덱스의 문자를 리턴 여기서 인덱스는 실제 배열 인덱스 수와 같다(문자열길이 -1 까지의 번호)
```java
    String subject = "자바 프로그래밍";
    char charValue = subject.charAt(3); //charValue = '프'
    System.out.println(charValue); // '프' 가 출력됨
```

###2.2 문자열 비교 equals()
기본타입 (byte, char, short, int, long, float, double, boolean ..)변수의 값을 비교할때 == 연산자를 사용하지만
문자열을 비교할 때에는 == 연산자를 사용하면 원하지 않는 결과가 나온다

```java
    String strVar1 = new String("신민철");
    String strVar2 = "신민철";
    String strVar3 = "신민철";
```

위의 코드처럼 선언했을 경우 문자열 리터럴이 동일하다면 동일한 String 객체를 참조하도록 되어 있다.
때문에 strVar2와 strVar3 는 동일한 String 객체 "신민철" 을 참조한다

그러나 strVar1은 new 연산자로 생성된 다른 String 객체를 참조한다

![](https://github.com/syhojeo/Java-Study/blob/main/image/%ED%99%94%EB%A9%B4%20%EC%BA%A1%EC%B2%98%202022-01-20%20164701.png)

때문에 이 경우 == 연산자를 사용하여 비교하는것이 아니라 String.equals() 메소드를 사용하여 문자열을 직접 비교한다

**== 연산자를 사용하는 경우 객체의 참조변수인 메모리 주소를 비교하는것이지 문자열을 비교하는것이 아니다**

```java
    if (strVar1 == strVar2) {
        System.out.println("잘못된 비교연산");
    }
    if (strVar1.equals(strVar2)) {
        System.out.println("옳바른 비교연산");
    }
```

###2.3 바이트 배열로 변환 getBytes()
앞에서 String 의 생성자를 사용하여 byte 데이터를 문자로 변환했다 하지만 종종 문자열을 바이트로 변환하는 경우가 있는데
대표적으로 네트워크로 문자열을 전송하거나, 문자열을 암호화 할때 문자열을 바이트 배열로 변환한다

문자열을 바이트 배열로 변환하는 메소드는 두가지가 있다

```java
    byte[] bytes = "문자열".getBytes();
    byte[] bytes = "문자열".getBytes(Charset charset); //인코딩할 charset 지정가능

    //인코딩을 지정하는 메소드를 사용하려면 UnsupportedEncodingException 에 대한 예외처리르 해줘야한다
    try {
        byte[] bytes = "문자열".getBytes("EUC-KR");
        byte[] bytes = "문자열".getBytes("UTF-8");
    } catch (UnsupportedEncodingException e){ //잘못된 문자셋을 매개값으로 줄 경우 발생
    }
```

###2.4 문자열 찾기 indexOf()
매개값으로 주어진 문자열이 시작되는 인덱스를 리턴한다. 만약 주어진 문자열이 포함되어 있지 않으면 -1을 리턴한다

```java
    String subject = "자바 프로그래밍";
    int index = subject.indexOf("프로그래밍");
    //index = 3 저장 (인덱스는 실제 배열의 인덱스와 같다 전체길이 -1 의 값)
```

###2.5 문자열 길이 length()
문자열의 길이를 리턴한다
```java
    String subject = "자바 프로그래밍";
    int length = subject.length(); //length = 8
```

### 2.6 문자열 대치 replace()
첫번쨰 매개값인 문자열을 찾아 두번째 매개값인 문자열로 대치한 새로운 문자열을 생성시키고 리턴한다

```java
    String oldStr = "자바 프로그래밍";
    String newStr = oldStr.replace("자바", "JAVA"); 
    // newStr = "JAVA 프로그래밍" -> oldstr과는 다른 새로운 문자열 객체가 생성된다
```

### 2.7 문자열 잘라내기 substring()
주어진 인덱스에서 문자열을 추출

매개값에 다라 두가지 형태로 사용된다
```java
    String ssn = "880815-1234567";
    String firstNum = ssn.substring(0, 6); // 0포함 ~ 6제외
    String secondNum = ssn.substring(7); // 인덱스 7 부터 문자열을 추출
```

### 2.8 알파벳 대소문자 변경 toLowerCase(), toUpperCase()
```java
    String original = "Java Programming";
    String lowerCase = original.toLowerCase(); //소문자로 변경
    String upperCase = original.toUpperCase(); //대문자로 변경
    //두가지 모두 original과 다른 새로운 string 객체를 생성한다
```

### 2.9 문자열 앞뒤 공백 잘라내가 trim()

문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성하고 리턴한다.
```java
    String oldStr = "   자바 프로그래밍   ";
    String newStr = oldStr.trim(); //newStr = "자바 프로그래밍" String 객체 생성
```

### 2.10 문자열 변환 valueOf()
기본 타입의 값을 문자열로 변환하는 기능

```java
    //valueOf 의 메소드 오버로딩
    static String valueOf(boolean b)
    static String valueOf(char c)
    static String valueOf(int i)
    static String valueOf(long l)
    static String valueOf(double d)
    static String valueOf(float f)
```

