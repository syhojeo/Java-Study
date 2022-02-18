//Stack을 이용한 동전 케이스
package collectionFramework.stackAndQueue;

import java.util.Stack;

class Coin {
    private int value;

    public Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class StackExample {

    public static void main(String[] args) {
        Stack<Coin> coinBox = new Stack<Coin>();

        //Stack.push() 스택에 값 저장
        coinBox.push(new Coin(100));
        coinBox.push(new Coin(50));
        coinBox.push(new Coin(100));
        coinBox.push(new Coin(10));

        //스택이 비었는지 확인
        while(!coinBox.isEmpty()) {
            //Stack.pop 하나씩 값 꺼내기
            Coin coin = coinBox.pop();
            System.out.println("꺼내온 동전 : " + coin.getValue() + "원");
        }
    }
}
