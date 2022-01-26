package basicApiClass.system.getenv;

public class SystemEnvExample {

    public static void main(String[] args) {
        //java_HOME 의 환경변수를 저장 (name을 이용해서 value 읽어오기)
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println("JAVA_HOME:: " + javaHome);

    }
}
