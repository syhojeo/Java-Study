package basicApiClass.object.toString;

public class SmartPhoneExample {

    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("구글", "안드로이드");

        String strObj = myPhone.toString();
        System.out.println(strObj);
        //System.out.println 의 매개값이 객체일경우에는 객체의 toString() 메소드를 호출하여 리턴값을 출력한다
        System.out.println(myPhone);
    }
}