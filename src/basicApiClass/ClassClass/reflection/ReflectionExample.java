package basicApiClass.ClassClass.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception{
        //상속에서 만들었던 Tire 클래스를 forName을 통해 따로 객체 생성을 하지 않고 읽어온다
        //getClass() 는 따로 객체를 생성해야한다
        Class clazz = Class.forName("inheritance.autoTransform.autoTransFormField.Tire");

        System.out.println("[클래스 이름]");
        System.out.println(clazz.getName()); //패키지를 포함한 전체 클래스명
        System.out.println();

        System.out.println("[생성자 정보]");
        //생성자 배열 타입으로 생성자들 읽어오기
        Constructor[] constructors = clazz.getDeclaredConstructors();
        //각각의 배열 원소에서 생성자를 하나씩 Constructor 타입 변수에 저장하여 읽어온다
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "(");
            //생성자의 매개변수 정보 (타입)
            Class[] parameters = constructor.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }
        System.out.println();

        System.out.println("[필드 정보]");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //필드 타입 + 필드 이름을 출력
            System.out.println(field.getType().getSimpleName() + " " + field.getName());
        }
        System.out.println();

        System.out.println("[메소드 정보]");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            //메소드명
            System.out.println(method.getName() + "(");
            //메소드의 타입을 배열로 읽어와서
            Class[] parameters = method.getParameterTypes();
            //printParameters 내부 for문에서 하나씩 출력
            //다만 public 접근지정자가 아니라면 타입을 확인할 수 없다
            printParameters(parameters);
            System.out.println();
        }
    }

    //매개 변수 정보를 출력하는 공통 코드
    private static void printParameters(Class[] parameters) {
        for(int i = 0; i < parameters.length; i++) {
            System.out.println(parameters[i].getName());
            if (i < (parameters.length - 1)) {
                System.out.println(",");
            }
        }
    }

}
