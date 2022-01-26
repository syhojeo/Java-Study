package basicApiClass.system.exit;

public class ExitExample {

    public static void main(String[] args) {
        //보안 관리자 설정
        System.setSecurityManager(new SecurityManager(){
            @Override
            //CheckExit가 정상적으로 실행된다면 JVM은 종료된다
            //즉, 정상적으로 실행되지 못하도록 SecurityException 을 발생시켜 예외처리를 하도록 만든다
            //status 가 5가되면 예외처리를 발생시키지 못하며 checkExit가 정상 실행 되며 JVM은 종료된다
            public void checkExit(int status) {
                if(status != 5) {
                    throw new SecurityException();
                }
            }
        });

        for(int i = 0; i < 10; i++) {
            //i값 출력
            System.out.println(i);
            try {
                //JVM 종료 요청
                System.exit(i);
            } catch (SecurityException e) {
            }
        }
    }
}
