/*
    중첩 클래스에서 바깥 클래스 참조 얻기
    중첩 클래스 내에서 변수 Or 메소드() 나 this.변수 Or 메소드() 를 사용하게되면 중첩 클래스의 변수나 메소들를 참조한다.
    바깥 클래스의 변수나 메소드를 참조하기 위해서는
    바깥 클래스명.this.변수 Or 메소드() 를 써줘야 참조가 가능해진다.
 */


package nestedClassInterface.nestedClass.outterClassReference;

public class OutterClassReference {
    String field = "Outter-field";

    //중첩 클래스에서 참조할 메소드
    void method() {
        System.out.println("Outter-method");
    }

    class Nested {
        String field = "Nested-field";

        void method() {
            System.out.println("Nested-method");
        }
        void print() {
            //중첩 객체 참조
            System.out.println(this.field);
//          =System.out.println(field); 위와 동일

            this.method();
//          =method(); 위와 동일

            //바깥 객체 참조 방법 - 바깥클래스명.this.필드명Or메소드명
            System.out.println(OutterClassReference.this.field);
            OutterClassReference.this.method();
        }
    }
}
