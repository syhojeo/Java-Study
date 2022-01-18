## 중첩 클래스
중첩클래스 분류는 크게 2가지로 클래스 내부에 선언하느냐 메소드 내부에 선언하느냐로 멤버 클래스와 로컬클래스로 나뉜다
<ol>
    <li> 
        인스턴스 멤버 클래스<br/>
        <pre>
            <code>
                class A {
                    class B {...}
                }
            </code>
        </pre>
        A 객체를 생성해야만 사용할 수 있는 클래스 내부 중첩 클래스 B
    </li><br/>
    <li> 
        정적 멤버 클래스<br/>
        <pre>
            <code>
                class A {
                    static class B {...}
                }
            </code>
        </pre>
        A 클래스로 바로 접근할 수 있는 클래스 내부 중첩 클래스 B
    </li><br/>
    <li> 
        로컬 클래스<br/>
        <pre>
            <code>
                class A {
                    void method() {
                        class B {...}   
                    }
                }
            </code>
        </pre>
        method()가 실행할 때만 사용할 수 있는 중첩 클래스 B
    </li>
    
</ol>
멤버 클래스도 하나의 클래스이기 때문에 컴파일 하면 바이트 코드 파일 (.class) 가 별도로 생성된다.
<br/> A $ B .class (멤버클래스 바이트 코드파일명) 
<br/> A $1 B .class (로컬 클래스 바이트 코드파일명)

