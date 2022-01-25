package basicApiClass.ClassClass.getClassAndforName;

public class ClassExample {

    public static void main(String[] args) {
        Car car = new Car();
        //getClass를 이용하여
        Class clazz1 = car.getClass();
        //Car클래스의 패키지 이름부터 풀네임으로 읽어온다
        System.out.println(clazz1.getName());
        //정확히 클래스 명만 읽어온다 (Car)
        System.out.println(clazz1.getSimpleName());
        //getName을 이용하여 해당 클래스의 패키지명만 읽어온다
        System.out.println(clazz1.getPackage().getName());
        System.out.println();

        //getClass는 해당 객체가 생성되어 있을 경우에만 사용이 가능하며
        //만약 Car 클래스 객체가 생성되지 않았을 경우 forName 메소드를 사용하여 객체를 직접 생성한뒤
        //getName() 등을 이용해준다
        try{
            Class clazz2 = Class.forName("basicApiClass.ClassClass.getClassAndforName.Car");
            System.out.println(clazz2.getName());
            System.out.println(clazz2.getSimpleName());
            System.out.println(clazz2.getPackage().getName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Car {}
