/*
    newInstance()
    클래스의 이름을 코드작성시에 결정할 수 없고, 런타임 시에 클래스 이름이 결정되는 경우 사용된다
    Class.forName() 메소드로 Class 객체를 얻은 다음 NewInstance로 객체를 생성한다
    다만 Object타입으로 리턴하기 때문에 알맞은 타입으로 타입 변환을 해줘야한다
 */
package basicApiClass.ClassClass.newInstance;

public class NewInstanceExample {

    public static void main(String[] args) {
        try {
            //forName을 통해 객체를 받아오고
            Class clazz = Class.forName("basicApiClass.ClassClass.newInstance.SendAction");
            //Class clazz = Class.forName("basicApiClass.ClassClass.newInstance.ReceiveAction");
            //받아온 객체를 생성
            //생성된 객체는 Object 타입이기 때문에 Action 타입으로 자동타입변환을 해준다
            Action action = (Action) clazz.newInstance();
            action.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
