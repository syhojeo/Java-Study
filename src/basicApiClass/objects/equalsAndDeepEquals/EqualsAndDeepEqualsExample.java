package basicApiClass.objects.equalsAndDeepEquals;


import static java.util.Objects.deepEquals;

import java.util.Arrays;
import java.util.Objects;

public class EqualsAndDeepEqualsExample {

    public static void main(String[] args) {
        Integer ol = 1000;
        Integer o2 = 1000;
        System.out.println(Objects.equals(ol, o2) ); //true
        System.out.println (Objects.equals(ol, null)); //false
        System.out.println(Objects.equals (null, o2)); //false
        System.out.println(Objects.equals(null, null)); //true
        System.out.println(deepEquals(ol, 02) + "\n"); //true

        Integer[] arr1 = { 1, 2 };
        Integer[] arr2 = { 1, 2 };
        //배열비교이기 때문에 false
        System.out.println(Objects.equals(arr1, arr2)); //false
        //배열 내 항목이 같기 때문에 true
        System.out.println(deepEquals(arr1, arr2)); //true
        //Arrays.deepEquals 와 deepEquals는 동일하게 동작한다
        System.out.println(Arrays.deepEquals(arr1, arr2) ); //true
        System.out.println(deepEquals(null, arr2) ); //false
        System.out.println (deepEquals(arr1, null) ); //false
        System.out.println(Objects.deepEquals(null, null)); //true
        }
}

