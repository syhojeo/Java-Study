package ramda.functionalInterface.apiFuncInterface.supplier;

import java.util.function.IntSupplier;

public class SupplierExample {

    public static void main(String[] args) {
        //1. 어떤 메소드를 실행할지 람다식 정의 (메소드 정의)
        IntSupplier intSupplier = () -> {
            int num = (int) (Math.random() * 6) + 1;
            return num;
        };
        
        //2. intSupplier(함수적인터페이스 표준API) 의 getXXX 메소드를 사용하여 람다식 실행
        int num = intSupplier.getAsInt();
        System.out.println("눈의 수: " + num);
    }
}
