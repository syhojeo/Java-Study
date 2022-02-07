package generic.ex4;

public class Util {
    //제네릭을 통해 명시를 해줌으로서 형변환이 필요없게끔 만들어준다
    public static <K, V> V getValue (Pair<K, V> pair, K key) {
        if (pair.getKey().equals(key)) {
            return pair.getValue();
        }
        else
            return null;
    }
}
