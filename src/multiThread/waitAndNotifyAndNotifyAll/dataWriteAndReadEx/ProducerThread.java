package multiThread.waitAndNotifyAndNotifyAll.dataWriteAndReadEx;

public class ProducerThread extends Thread {
    private DataBox dataBox;

    public ProducerThread(DataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        int i = 1;
      //  for (int i = 1; i <= 3; i++) {
            String data = "Data-" + i;
            dataBox.setData(data);
      //  }
        System.out.println("ProducerThread 종료");
    }

}