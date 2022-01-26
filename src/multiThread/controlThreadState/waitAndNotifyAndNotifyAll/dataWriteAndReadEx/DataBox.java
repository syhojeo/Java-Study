/*
    데이터를 write 하는 스레드와 read하는 스레드 두 스레드가 공유해서 참조하는 개체 DataBox이다

    Databox안의 값이 null 일때만 write 와 read가 동작하게 하는 DataBox를 만들기 위해서 두가지 스레드 제어기술을 사용했다

    1. synchronized (동기화)
    동기화를 통해 가장 먼저 getData() 든 setData()든 두 메소드를 동시에 사용하지 못하도록 막았다
    읽고 쓰기를 동시에 하는건 할 수 없기 때문이다

    2. notify() , wait()
    notify()와 wait()을 통해 완벽하게 서로 한번씩 돌아가면서 스레드가 동작할 수 있도록 만들었다
    wait 을 통해 write, read하는 스레드가 각자의 조건
    databox null이 아니라면 write를 하지않는것, databox가 null 이라면 read를 하지 않는것을
    할 수 있도록 if문을 안의 wait을 통해 구현하였다

    그러다 write이든 read든의 동작을 하게되면 notify()를 이용하여 반대편의 일시정지 상태를 풀어주고,
    자신의 상태를 일시정지로  만듦으로서 완변하게 한번씩 번갈아가며 동작할 수 있도록
 */
package multiThread.controlThreadState.waitAndNotifyAndNotifyAll.dataWriteAndReadEx;

public class DataBox {

    private String data;

    //wait과 notify는 synchronized 내부에서만 사용가능하다
    public synchronized String getData() {
        if (this.data == null) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        String returnValue = data;
        System.out.println("ConsummerThread가 읽은 데이터: " + returnValue);
        data = null;
        notify();
        return returnValue;
    }

    public synchronized void setData(String data) {
        if (this.data != null) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        this.data = data;
        System.out.println("ProducerThread가 생성한 데이터: " + data);
        notify(); //notify가 실행되어도 바로 일시정지 상태가 되지않고, notify가 존재하는 Sysnchronized 내부 코드는
                    //실행 시킨 후에 wait 메소드를 호출한다
        System.out.println("다음줄감?");
    }
}
