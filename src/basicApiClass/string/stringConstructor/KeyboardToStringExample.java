//키보드로 부터 읽어온 byte배열 정보를 문자열로 변환
package basicApiClass.string.stringConstructor;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import java.io.IOException;

public class KeyboardToStringExample {

    public static void main(String[] args) throws IOException {
        //읽은 바이트를 저장하기 위한 배열 생성
        byte[] bytes = new byte[100];

        System.out.println("입력: ");
        //키보드로부터의 입력값을 bytes배열로 받아온다
        int readByteNo = System.in.read(bytes);

        /*
            length의 길이를 -2 하는 이유는 System.in.read 를 하여 키보드 입력을 받아올때
            배열안에 문자정보만 있는것이 아니고 캐리지리턴(\r), 라인피드(\n)이 마지막에 같이 들어있기 때문에
            온전한 문자 정보만을 변환해주기 위해 -2를 처리를 해준다
         */
        String str = new String(bytes, 0, readByteNo-2);
        System.out.println(str);
    }
}
