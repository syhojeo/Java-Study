package multiThread.synchronizedMethodAndBlock;

public class User1 extends Thread{
    private Calculator calculator;

    public void setCalculator(Calculator calculator) {
        this.setName("User1");
        this.calculator = calculator;
    }

    @Override
    public void run() {
        //공유 객체인 Calculator 의 메모리에 100을 저장
        calculator.setMemory(100);
    }
}
