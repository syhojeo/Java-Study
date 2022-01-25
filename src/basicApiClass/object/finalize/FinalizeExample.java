package basicApiClass.object.finalize;

public class FinalizeExample {

    public static void main(String[] args) {
        Counter counter = null;
        for(int i = 1; i <= 50; i++) {
            counter = new Counter(i);
            //counter 객체를 쓰레기로 만듦
            counter = null;
            //Garbage Collection 실행 요청 (실제 요청이 되지만 바로 실행할 수는 없어서 출력되는 결과의 번호가 뒤죽박죽이 된다)
            //실제로 Garbage Collection은 메모리가 부족하거나 CPU가 한가할 때 JVM에 의해서 자동 실행된다
            System.gc();
        }
    }
}
