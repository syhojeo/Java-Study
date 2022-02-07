package generic.genericMethod;

import generic.genericType.Box;

public class Util {
    //box에 set을 대신해주는 boxing 메소드
    public static <T> Box<T> boxing(T t) {
        Box<T> box =  new Box<T>();
        box.set(t);
        return box;
    }

    //두개의 Pair 를 매개값으로 받아 K와 V값이 동일한지 검사
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        boolean keyCompare = p1.getKey().equals(p2.getKey());
        boolean valueCompare = p1.getValue().equals(p2.getValue());
        return keyCompare && valueCompare;
    }
}
