package interfacee.defaultMethod.inheritance;

public interface ParentInterface {
    void method1();

    default void defaultmethod() {
        System.out.println("origin default method");
    }
}
