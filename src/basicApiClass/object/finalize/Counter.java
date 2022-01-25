package basicApiClass.object.finalize;

public class Counter {
    private int no;
    
    public Counter(int no) {
        this.no = no;
    }
    
    @Override
    //Throwable 은 Exception과 Error의 상속을 해주는 예외처리의 최상위 클래스 이다
    protected void finalize() throws Throwable {
        System.out.println(no + "번 객체의 finalize()가 실행됨");
    }
}