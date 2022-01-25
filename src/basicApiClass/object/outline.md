#Object 클래스 (java.lang.Object)
자바의 최상위 부모 클래스에 해당하며 java.lang 패키지에 위치한다 <br/>
클래스를 선언할때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 Object 클래스를 상속하게 된다.

ex) ```public boolean equals(Object obj) {...}```

equals() 메소드의 매개변수를 보면 Object로 되어있으며 이는 모든 객체가 매개값으로 대입될 수 있음을 말한다

모든 객체는 Object 타입으로 자동 타입 변환될 수 있기 때문이다