package generic.wildCard;

import java.util.Arrays;


public class WildCardExample {

    // <?> 모든 타입 클래스가 올 수 있다
    public static void registerCourse(Course<?> course) { //와일드 카드를 이용한 모든과정 범위
        System.out.println(course.getName() + "수강생: " + Arrays.toString(course.getStudents()));
    }

    //<? extends type> type 을 포함한 하위 상속 클래스
    public static void registerCourseStudent( Course<? extends Student> course) { //학생 과정
        System.out.println(course.getName() + "수강생: " + Arrays.toString(course.getStudents()));
    }

    //<? super type> type 을 포함한 상위 상속 클래스
    public static void registerCourseWorker ( Course<? super Worker> course) { //직장인과 일반인 과정
        System.out.println(course.getName() + "수강생: " + Arrays.toString(course.getStudents()));
    }

    public static void main(String[] args) {
        //일반인 과정 목록
        Course<Person> personCourse = new Course<Person>("일반인과정", 5);
        personCourse.add(new Person ("일반인"));
        personCourse.add(new Worker("직장인"));
        personCourse.add(new Student("학생"));
        personCourse.add(new HighStudent("고등학생"));

        //직장인 과정 목록
        Course<Worker> workerCourse = new Course<Worker>("직장인과정", 5);
        workerCourse.add(new Worker("직장인"));

        //학생 과정 목록
        Course<Student> studentCourse = new Course<Student>("학생과정", 5);
        studentCourse.add(new Student("학생"));
        studentCourse.add(new HighStudent("고등학생"));

        //고등학생 과정 목록
        Course<HighStudent> highStudentCourse = new Course<HighStudent>("고등학생과정",5);
        highStudentCourse.add(new HighStudent("고등학생"));

        //모든 과정 등록 가능
        registerCourse(personCourse);
        registerCourse(workerCourse);
        registerCourse(studentCourse);
        registerCourse(highStudentCourse);
        System.out.println();

        //학생 과정만 등록 가능
        //registerCourseStudent(personCourse); (x)
        //registerCourseStudent(workerCourse); (x)
        registerCourseStudent(studentCourse);
        registerCourseStudent(highStudentCourse);
        System.out.println();

        //직장인과 일반인 과정만 등록 가능
        registerCourseWorker(personCourse);
        registerCourseWorker(workerCourse);
        //registerCourseWorker(studentCourse); (x)
        //registerCourseWorker(highStudentCourse); (x)
    }
}

class Person{
    public String job;
    Person(String job){
        this.job = job;
    }

    @Override
    public String toString() {
        return job ;
    }
}
class Student extends Person {
    Student(String job) {
        super(job);
    }
}
class HighStudent extends Student{
    HighStudent(String job){
        super(job);
    }
}
class Worker extends Person{
    private String job;
    Worker(String job){
        super(job);
    }
}