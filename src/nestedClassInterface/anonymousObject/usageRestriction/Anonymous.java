/*
    메소드 내부 익명 객체의 로컬 변수 사용
    메소드 내부에 선언되지 않은 익명 객체의 경우 중첩 인터페이스와 마찬가지로 클래스의 모든 필드와 메소드에 제한없이 접근 가능하지만

    매소드 내부에 선언된 익명객체의 경우 로컬변수나 매개변수에 의한 문제
    (객체는 head에 남아있는데 참조하는 로컬,매개변수가 stack 에서 날라가는 경우)
    (final 이 없이 사용할 경우 매개변수와 로컬변수가 중간에 변하는 경우)

    가 발생할 수 있어 이를 생각하여 로컬 변수, 매개변수를 사용해줘야한다.
 */

package nestedClassInterface.anonymousObject.usageRestriction;

public class Anonymous {
    private int field;

    public void method(final int arg1, int arg2) {
        final int var1 = 0;
        int var2 = 0;

        field = 10;

        //중첩 클래스나 인터페이스에서 사용되는 로컬변수, 매개변수는 자동적으로 final 처리되기 때문에 값을 변경 할 수 없다.
        //final을 넣는 이유는 값이 변경되면
        //arg1 = 20; (x)
        //arg2 = 20; (x)

        //var1 = 30; (x)
        //var2 = 30; (x)

        Calculatable calc = new Calculatable() {
            //final 이 명시되지 않은 arg2, var2 는 객체의 필드로 저장
            @Override
            public int sum() {
                //final 이 명시된 arg1, var1은 내부 메소드의 로컬 변수로 저장
                int result = field + arg1 + arg2 + var1 + var2;
                return result;
            }
        };

        System.out.println(calc.sum());
    }
}

