package basicApiClass.system.gc;

public class GcExample {

    public static void main(String[] args) {
        Employee emp;

        emp = new Employee(1); //쓰레기 객체가 됨 (밑에줄에서)
        emp = null;
        emp = new Employee(2); //쓰레기 객체가 됨 (밑에줄에서)
        emp = new Employee(3);

        System.out.println("emp가 최종적으로 참조하는 사원번호: ");
        System.out.println(emp.eno);
        System.gc();
    }

}
    class Employee {
        public int eno;

        public Employee(int eno) {
            this.eno = eno;
            System.out.println("Employee(" + eno + ") 가 메모리에 생성됨");
        }

        @Override
        //Garbage Collection 은 객체를 삭제할때 finalize() 를 사용한다
        public void finalize() {
            System.out.println("Employee(" + eno + ") 이 메모리에서 제거됨");
        }
    }

