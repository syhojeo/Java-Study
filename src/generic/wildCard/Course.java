package generic.wildCard;

public class Course<T> {

    private String name;
    private T[] students;

    public Course(String name, int capacity) {
        this.name = name;
        /*
            타입 파라미터로 배열을 생성하려면 new T[n] 형태로 배열을 생성할 수 없고
            (T[]) (new Object[n]) 형태로 생성해야한다
         */
        students = (T[]) (new Object[capacity]);
    }

    public String getName() { return name; }
    public T[] getStudents() { return students; }
    //배열에 비어있는 부분을 찾아서 수강생을 추가하는 메소드
    public void add(T t) {
        //제네릭 타입 객체 참조하는법
        //1. 강제 형변환으로 타입 변형 후
        //Person person = (Person) t;
        //2. 필드등에 접근
        //students[i] = (T) person.job;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                //객체의 참조변수 즉 객체의 주소값을 넣고, 자동으로 toString이 호출되어 저장된다
                students[i] = t;
                break;
            }
        }
    }
}
