/*
    강제형변환
    부모클래스의 자식클래스로의 자동형변환은 자식클래스의 오버라이딩된 메소드만 사용가능했다.
    하지만 추가적으로 자식클래스의 추가 필드와 메소드를 사용하기 원한다면
    자동형변환된 객체를 강제형변환을 하여 사용할 수 있도록 해줄 수 있다.
 */
package inheritance.autoTransform;

class Parent {}

class Child extends Parent {}

public class casting {

    public static void main(String[] args) {
        Parent parent = new Child(); //자동 형변환
        //Child child = (Child) parent; //강제 형변환

        //강제 형변환을 위해서는 이미 자식클래스로 자동형변환이된 부모클래스가 필요한데
        //자동형변환이 되어있는지 확인하기 위해 instanceof 를 사용한다
        // boolean result = 좌항(확인할객체) instanceof 우항(확인할타입)
        if (parent instanceof Child) { //instanceof를 이용한 자동형변환 확인
            Child child = (Child) parent;
        }
    }
}