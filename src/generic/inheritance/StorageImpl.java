package generic.inheritance;

public class StorageImpl<T> implements Storage<T>{
    private T[] array;

    //제네릭 타입을 사용할때에는 (T) (new Object) 형식으로 객체 생성을 해줘야한다
    public StorageImpl(int capacity) {
        this.array = (T[]) (new Object[capacity]);
    }

    @Override
    public void add(T item, int index) {
        array[index] = item;
    }

    @Override
    public T get(int index) {
        return array[index];
    }
}
