package ramda.functionalInterface;

public class MyFunctionalInterfaceExample {

    public static void main(String[] args) {
        //람다를 사용하기 위해 반드시 필요한 타겟타입
        MyFunctionalInterface fi;

        //매개변수가 없기 때문에 () 만 표시
        fi = () -> {
            String str = "method call1";
            System.out.println(str);
        };
        fi.method();

        fi = () -> {
            System.out.println("method call2");
        };
        fi.method();

        fi = () -> {
            System.out.println("method call3");
        };
        fi.method();
    }
}
