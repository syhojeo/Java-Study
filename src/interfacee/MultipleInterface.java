package interfacee;


//interface의 메소드는 public abstract가 생략되어 있기 때문에 반드시 구현클래스에서
// 추상메소드에 대한 실체 메소드를 만들어줘야한다.
public interface MultipleInterface {
    void search(String url);
}
