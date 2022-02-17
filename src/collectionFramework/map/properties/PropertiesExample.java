/*
    Properties 를 이용하여 String = String 형 문서들을 읽어 올 수 있다
    주로 애플리케이션의 옵션정보, 데이터베이스의 연결정보, 다국어 정보가 저장된 Properties 파일을 읽을때 주로 사용
 */
package collectionFramework.map.properties;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesExample {

    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        //.properties 파일의 위치 읽어오기
        String path = PropertiesExample.class.getResource(("database.properties")).getPath();
        //경로에 한글이 있는경우 utf-8 로 디코딩 ( 한글 복원)
        path = URLDecoder.decode(path, "utf-8");
        //디코드된 값을 FileReader 객체를 매개변수로 load 한다
        properties.load(new FileReader(path));

        //일반적인 Hashtable 과 같이 get() 메소드에 Key값을 대입하여 대응 되는 value값을 읽어올 수 있다
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        System.out.println("driver : " + driver);
        System.out.println("url : " + url);
        System.out.println("username : " + username);
        System.out.println("password : " + password);
    }
}
