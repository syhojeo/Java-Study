//익명 구현객체 연습
package interfacee.ex.ex5;

import interfacee.ex.ex4.Action;

public class ActionExample {

    public static void main(String[] args) {
        Action action = new Action() {
            public void work() {
                System.out.println("복사를 합니다.");
            }
        };
        action.work();
    }
}
