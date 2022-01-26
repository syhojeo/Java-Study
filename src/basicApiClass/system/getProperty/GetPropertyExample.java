package basicApiClass.system.getProperty;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {

    public static void main(String[] args) {
        //System.getPorperty 사용법
        String osName = System.getProperty("os.name");
        String userName = System.getProperty("user,name");
        String userHome = System.getProperty("user.home");
        System.out.println("운영쳬제 이름： " + osName);
        System.out.println("사용자 이름： " + userName);
        System.out.println("“사용자 홈디렉토리： " + userHome);
        System.out.println("-------------------");
        System.out.println(" [ key I value");
        System.out.println("-------------------");

        //getProperties 메소드를 통해 모든 시스템 정보값 저장
        Properties props = System.getProperties();
        Set keys = props.keySet();
        for (Object objKey : keys) {
            String key = (String) objKey;
            String value = System.getProperty(key);
            System.out.println("[ " + key + " } " + value);
        }
    }
}
