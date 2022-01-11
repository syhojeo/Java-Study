/*
    추상 메소드
    추상 클래스에서만 사용할 수 있는 메소드로 추상클래스에서 정의하지 못하고, 각각의 객체에서 직접 정의해야되는
    메소드의 경우 추상메소드를 만들어 사용한다

    추상메소드를 사용할 경우 추상클래스를 상속하는 모든 자식객체들에서 추상메소드에 대한 오버라이딩을 반드시 해줘야하는
    의무를 가지게 되며 이를 하지 않을 경우 컴파일 에러가 발생한다.
 */

package inheritance.abstractt;

//추상클래스
abstract class Animal {
    public String kind;

    public void breathe() {
        System.out.println("숨을 쉽니다.");
    }

    //추상 메소드 선언
    public abstract void sound();
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    @Override
    public void sound(){
        System.out.println("야옹");
    }
}

public class AbstractMethodOverride {

    public static void animalSound(Animal animal) {
        animal.sound();
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.sound();
        cat.sound();
    }
}
