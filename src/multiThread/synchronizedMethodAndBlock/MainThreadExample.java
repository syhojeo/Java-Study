//동일한 객체에 접근하는 두개의 스레드를 synchronized(동기화)를 사용하여 critical section 에 동시에 접근하지 못하도록
//막는다

package multiThread.synchronizedMethodAndBlock;

public class MainThreadExample {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        User1 user1 = new User1();
        //같은 공유 객체
        user1.setCalculator(calculator);
        user1.start();

        User2 user2 = new User2();
        //같은 공유 객체
        user2.setCalculator(calculator);
        user2.start();

    }
}
